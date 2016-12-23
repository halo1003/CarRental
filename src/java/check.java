/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import storeAccount.Account;

/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns = {"/check"})
public class check extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //declare
            String connectionURL = "jdbc:mysql://localhost:3306/carrental?user=root;password=";
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            //connect database
            /*try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(connectionURL, "root", "");
                statement = connection.createStatement();

            } catch (SQLException ex) {
            }*/
            //session
            HttpSession session = request.getSession(false);
            //get action
            String action = request.getParameter("action");
            //Login
            if (action.equals("login")) {
                //get username and password
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                rs = statement.executeQuery("SELECT * FROM admin WHERE `AdName`='" + username + "'");
                if (rs.next()) {//AdName = username
                    String AdPass = rs.getString("AdPass");
                    if (password.equals(AdPass)) { // check AdPass
                        String Name = rs.getString("AdFName");
                        String Address = rs.getString("AdAddress");
                        String Phone = rs.getString("AdPhone");
                        Account account = new Account();
                        account.setID("0");
                        account.setName(Name);
                        account.setAddress(Address);
                        account.setPhone(Phone);
                        session.setAttribute("account", account);
                        session.setAttribute("option", "History");
                        connection.close();
                        response.sendRedirect("Admin.jsp");

                    } else {
                        session.setAttribute("checkAccount", "wrongUsername");
                        connection.close();
                        response.sendRedirect("Login.jsp");
                    }
                } else {// AdName != username
                    rs = statement.executeQuery("SELECT * FROM customer WHERE `CName`='" + username + "'");
                    if (rs.next()) {//CName = username
                        String CPass = rs.getString("CPass");
                        String ID = rs.getString("CID");
                        String Name = rs.getString("CFName");
                        String Address = rs.getString("CAddress");
                        String Phone = rs.getString("CPhone");
                        rs = statement.executeQuery("SELECT * FROM ban WHERE `CID`='" + ID + "'");
                        if (rs.next()) {
                            connection.close();
                            response.sendRedirect("banPage.html");
                        } else if (password.equals(CPass)) {// check CPass
                            Account account = new Account();
                            account.setID(ID);
                            account.setName(Name);
                            account.setAddress(Address);
                            account.setPhone(Phone);
                            session.setAttribute("account", account);
                            connection.close();
                            response.sendRedirect("homePage.jsp");
                        } else {
                            session.setAttribute("checkAccount", "wrongPass");
                            connection.close();
                            response.sendRedirect("Login.jsp");
                        }
                    } else {// CName != username
                        session.setAttribute("checkAccount", "wrongUsername");
                        connection.close();
                        response.sendRedirect("Login.jsp");
                    }
                }
            } else if (action.equals("Admin_Car_Update")) { // Car Update
                String CarID = request.getParameter("CarID");
                int ID = parseInt(request.getParameter("CarID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("UPDATE Car SET Status='U' WHERE `CarID`=" + ID);
                connection.close();
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");

            } else if (action.equals("Admin_Car_Already")) {
                int ID = parseInt(request.getParameter("CarID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("UPDATE Car SET Status='A' WHERE `CarID`=" + ID);
                connection.close();
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Delete")) {
                int ID = parseInt(request.getParameter("CarID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("DELETE FROM car WHERE `CarID`=" + ID);
                connection.close();
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Edit")) {
                String ID = request.getParameter("CarID");
                session.setAttribute("option", "carEdit");
                session.setAttribute("CarID", ID);
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Edit_Form")) { //edit
                int ID = parseInt(request.getParameter("carID"));
                String name = request.getParameter("name");
                String price = request.getParameter("price");
                String discount = request.getParameter("discount");
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                if (!name.equals("")) {
                    statement.executeUpdate("UPDATE Car SET CarName='" + name + "' WHERE `CarID`=" + ID);
                }
                if (!price.equals("")) {
                    int Price = parseInt(price);
                    statement.executeUpdate("UPDATE Car SET Price=" + Price + " WHERE `CarID`=" + ID);
                }
                if (!discount.equals("")) {
                    int Discount = parseInt(discount);
                    statement.executeUpdate("UPDATE Car SET Discount=" + Discount + " WHERE `CarID`=" + ID);
                }
                connection.close();
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_addCar")) {
                String name = request.getParameter("name");
                String carType = request.getParameter("carType");
                String Seat = request.getParameter("seat");
                String color = request.getParameter("color");
                String Introduce = request.getParameter("introduce");
                int seat = Integer.parseInt(Seat);
                int price = Integer.parseInt(request.getParameter("price"));
                String Discount = request.getParameter("discount");
                int discount = 0;
                if (Discount.equals("")) {
                    discount = 0;
                } else {
                    discount = Integer.parseInt(request.getParameter("discount"));
                }
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("INSERT INTO `car` (`CarName`, `Discount`, `CarType`, `Seats`, `Color`, `Introduce`, `Price`, `Status`, `Like`, `Dislike`) VALUES ('" + name + "', " + discount + ", '" + carType + "', " + seat + ", '" + color + "', '" + Introduce + "', " + price + ", 'A', 0, 0)");
                connection.close();
                out.println("fuckk");
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_EditAdmin_Form")) { //editAD
                String AdFName = request.getParameter("AdFName");
                String AdPass = request.getParameter("AdPass");
                String adPhone = request.getParameter("AdPhone");
                String AdAddress = request.getParameter("AdAddress");
                Account account = (Account) request.getSession().getAttribute("account");

                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                if (!AdFName.equals("")) {
                    statement.executeUpdate("UPDATE admin SET AdFName='" + AdFName + "' WHERE `AdName`='admin'");
                    account.setName(AdFName);
                }
                if (!AdPass.equals("")) {
                    statement.executeUpdate("UPDATE admin SET AdPass='" + AdPass + "' WHERE `AdName`= 'admin'");
                }
                if (!adPhone.equals("")) {
                    int AdPhone = parseInt(adPhone);
                    statement.executeUpdate("UPDATE admin SET AdPhone=" + AdPhone + " WHERE `AdName`= 'admin'");
                    account.setPhone(adPhone);
                }
                if (!AdAddress.equals("")) {
                    statement.executeUpdate("UPDATE admin SET AdAddress='" + AdAddress + "' WHERE `AdName`= 'admin'");
                    account.setAddress(AdAddress);
                }
                connection.close();
                session.setAttribute("option", "History");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Ban")) {
                int CID = parseInt(request.getParameter("CID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("INSERT INTO ban (CID) VALUES (" + CID + ")");
                connection.close();
                session.setAttribute("option", "Customer");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Unban")) {
                int CID = parseInt(request.getParameter("CID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("DELETE FROM ban WHERE `CID`=" + CID);
                connection.close();
                session.setAttribute("option", "Customer");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Register")) {
                String CName = request.getParameter("CName");
                String cINumber = request.getParameter("CINumber");
                int CINumber = parseInt(cINumber);
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                rs = statement.executeQuery("SELECT * FROM customer WHERE `CName`='" + CName + "' or `CINumber`=" + CINumber);
                if (rs.next()) {
                    connection.close();
                    session.setAttribute("checkAccount", "exist");
                    response.sendRedirect("Register.jsp");
                } else {
                    String CPass = request.getParameter("CPass");
                    String CFName = request.getParameter("CFName");
                    String cPhone = request.getParameter("CPhone");
                    String CAddress = request.getParameter("CAddress");
                    int CPhone = parseInt(cPhone);
                    String Name = CFName;
                    String Address = CAddress;
                    String Phone = cPhone;
                    statement.executeUpdate("INSERT INTO customer (CName, CPass, CFName, CPhone, CAddress, CINumber) VALUES ('" + CName + "', '" + CPass + "', '" + CFName + "', " + CPhone + ", '" + CAddress + "', " + CINumber + ")");
                    rs = statement.executeQuery("SELECT * FROM `customer` WHERE `CName`='" + CName + "'");
                    if (rs.next()) {
                        String CID = rs.getString("CID");
                        Account account = new Account();
                        account.setID(CID);
                        account.setName(Name);
                        account.setAddress(Address);
                        account.setPhone(Phone);
                        session.setAttribute("account", account);
                        connection.close();
                        response.sendRedirect("homePage.jsp");
                    } else {
                        out.println("Can't get CID");
                    }
                    /*if (rs.next()) {
                        String CID = rs.getString("CID");
                        Account account = new Account();
                        account.setID(CID);
                        account.setName(Name);
                        account.setAddress(Address);
                        account.setPhone(Phone);
                        session.setAttribute("account", account);
                        connection.close();
                        response.sendRedirect("login.jsp");
                    } else {
                        out.println("can't");
                    }*/
                }
            } else if (action.equals("rentCar")) {
                int ID = Integer.parseInt(request.getParameter("ID"));
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date current = new Date();
                String getDate = df.format(current);
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("INSERT INTO rent (CarID, CID, RentType, TimeRent)VALUES (" + CarID + "," + ID + ", 'W','" + getDate + "')");
                connection.close();
                response.sendRedirect("homePage.jsp");
            } else if (action.equals("like")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("UPDATE `car` SET `Like` = `Like`+1 WHERE `CarID`=" + CarID);
                connection.close();
                response.sendRedirect("homePage.jsp");
            } else if (action.equals("dislike")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("UPDATE `car` SET `Dislike` = `Dislike`+1 WHERE `CarID`=" + CarID);
                connection.close();
                response.sendRedirect("homePage.jsp");
            } else if (action.equals("getCar")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date current = new Date();
                String getDate = df.format(current);
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                statement.executeUpdate("UPDATE `rent` SET `TimeRent` = '" + getDate + "', `RentType`='R' WHERE `CarID`=" + CarID);
                connection.close();
                session.setAttribute("option", "Rent");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Return")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date current = new Date();
                String TimeReturn = df.format(current);
                int CID = 0;
                String TimeRent = "";
                String CFName = "";
                String CarName = "";
                int Price = 0;
                int Discount = 0;
                //connect
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                rs = statement.executeQuery("SELECT * FROM rent WHERE `CarID`=" + CarID);
                if (rs.next()) {
                    CID = Integer.parseInt(rs.getString("CID"));
                    TimeRent = rs.getString("TimeRent");
                    rs = statement.executeQuery("SELECT CFName FROM customer WHERE `CID`=" + CID);
                    if (rs.next()) {
                        CFName = rs.getString("CFName");
                    }
                    rs = statement.executeQuery("SELECT * FROM car WHERE `CarID`=" + CarID);
                    if (rs.next()) {
                        CarName = rs.getString("CarName");
                        Price = rs.getInt("Price");
                        Discount = rs.getInt("Discount");
                    }
                }
                //date
                Date date1 = df.parse(TimeRent);
                Date date2 = df.parse(TimeReturn);

                double totalDays = (date2.getTime() - date1.getTime()) * 1.0 / (1000 * 60 * 60 * 24);
                int Payment = Price - (Price * Discount / 100);
                int inttotalDays = (int) totalDays;
                double check = totalDays - (double) inttotalDays;
                if (check == 0) {
                    inttotalDays = inttotalDays;
                } else {
                    inttotalDays += 1;
                }
                //total price
                Payment = Payment * inttotalDays;

                statement.executeUpdate("INSERT INTO history (CarName, CFName, CID, TimeRent, TimeReturn, Payment) VALUES ('" + CarName + "', '" + CFName + "', " + CID + ",'" + TimeRent + "','" + TimeReturn + "'," + Payment + ")");
                statement.executeUpdate("DELETE FROM rent WHERE `CarID`=" + CarID);
                connection.close();
                session.setAttribute("option", "Rent");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("CancelOrder")) {
                //connect
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                statement.executeUpdate("DELETE FROM rent WHERE `CarID`=" + CarID);
                session.setAttribute("option", "Rent");
                response.sendRedirect("Admin.jsp");
                connection.close();
            } else if (action.equals("Customer_Edit_Profile")) {
                int CID = Integer.parseInt(request.getParameter("CID"));
                String CPass = request.getParameter("CPass");
                String CFName = request.getParameter("CFName");
                String CPhone = request.getParameter("CPhone");
                String CAddress = request.getParameter("CAddress");
                Account account = (Account) request.getSession().getAttribute("account");
                //connection
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                if (!CPass.equals("")) {
                    statement.executeUpdate("UPDATE customer SET CPass='" + CPass + "' WHERE `CID`=" + CID);
                }
                if (!CFName.equals("")) {
                    statement.executeUpdate("UPDATE customer SET CFName='" + CFName + "' WHERE `CID`=" + CID);
                    account.setName(CFName);
                }
                if (!CPhone.equals("")) {
                    statement.executeUpdate("UPDATE customer SET CPhone='" + CPhone + "' WHERE `CID`=" + CID);
                    account.setPhone(CPhone);
                }
                if (!CAddress.equals("")) {
                    statement.executeUpdate("UPDATE customer SET CAddress='" + CAddress + "'  WHERE `CID`=" + CID);
                    account.setAddress(CAddress);
                }
                connection.close();
                session.setAttribute("option", "allCars");
                response.sendRedirect("homePage.jsp");

            } else if (action.equals("cancelOrder")) {
                //connect
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();

                } catch (SQLException ex) {
                }
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                statement.executeUpdate("DELETE FROM rent WHERE `CarID`=" + CarID);
                connection.close();
                session.setAttribute("option", "Rent");
                response.sendRedirect("homePage.jsp");
            }

        }
    }

    //Redirection
    /*private void goto(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
    dispatcher.forward(request,response);
}*/
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String daysBetween(Date time, Date time0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
