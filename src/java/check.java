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
import mvc.Authenticator;
import mvc.Car;
import mvc.controlAccount;
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
            //session
            HttpSession session = request.getSession(false);
            //get action
            String action = request.getParameter("action");
            //Login
            if (action.equals("login")) {
                //get username and password
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Authenticator authen = new Authenticator(); //mvc model
                password = authen.hashPassword(password);
                if (authen.checkAdmin(username, password)) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = DriverManager.getConnection(connectionURL, "root", "");
                        statement = connection.createStatement();

                    } catch (SQLException ex) {
                    }
                    rs = statement.executeQuery("SELECT * FROM admin WHERE `AdName`='" + username + "'");
                    if (rs.next()) {
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
                    }
                } else {
                    if (authen.checkCustomer(username, password).equals("banned")) {
                        response.sendRedirect("banPage.html");
                    } else if (authen.checkCustomer(username, password).equals("success")) {
                        try {
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            connection = DriverManager.getConnection(connectionURL, "root", "");
                            statement = connection.createStatement();

                        } catch (SQLException ex) {
                        }
                        rs = statement.executeQuery("SELECT * FROM customer WHERE `CName`='" + username + "'");
                        if (rs.next()) {
                            String CPass = rs.getString("CPass");
                            String ID = rs.getString("CID");
                            String Name = rs.getString("CFName");
                            String Address = rs.getString("CAddress");
                            String Phone = rs.getString("CPhone");
                            Account account = new Account();
                            account.setID(ID);
                            account.setName(Name);
                            account.setAddress(Address);
                            account.setPhone(Phone);
                            session.setAttribute("account", account);
                            connection.close();
                            response.sendRedirect("homePage.jsp");
                        }
                    } else if (authen.checkCustomer(username, password).equals("wrongPass")) {
                        session.setAttribute("checkAccount", "wrongPass");
                        response.sendRedirect("Login.jsp");
                    } else if (authen.checkCustomer(username, password).equals("wrongUsername")) {
                        session.setAttribute("checkAccount", "wrongUsername");
                        response.sendRedirect("Login.jsp");
                    }
                }
            } else if (action.equals("Admin_Car_Update")) { // Car Update
                int ID = parseInt(request.getParameter("CarID"));
                Car car = new Car();
                car.update(ID);
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");

            } else if (action.equals("Admin_Car_Already")) {
                int ID = parseInt(request.getParameter("CarID"));
                Car car = new Car();
                car.already(ID);
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Delete")) {
                int ID = parseInt(request.getParameter("CarID"));
                Car car = new Car();
                car.delete(ID);
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
                Car car = new Car();
                car.edit(ID, name, price, discount);
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_addCar")) {
                String name = request.getParameter("name");
                String carType = request.getParameter("carType");
                String Seat = request.getParameter("seat");
                String color = request.getParameter("color");
                String introduce = request.getParameter("introduce");
                int seat = Integer.parseInt(Seat);
                int price = Integer.parseInt(request.getParameter("price"));
                String Discount = request.getParameter("discount");
                int discount = 0;
                if (Discount.equals("")) {
                    discount = 0;
                } else {
                    discount = Integer.parseInt(request.getParameter("discount"));
                }
                Car car = new Car();
                car.add(name, carType, seat, price, discount, color, introduce);
                session.setAttribute("option", "Car");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_EditAdmin_Form")) { //editAD
                String AdFName = request.getParameter("AdFName");
                String AdPass = request.getParameter("AdPass");
                Authenticator authen = new Authenticator();
                AdPass = authen.hashPassword(AdPass);
                String adPhone = request.getParameter("AdPhone");
                String AdAddress = request.getParameter("AdAddress");
                Account account = (Account) request.getSession().getAttribute("account");
                controlAccount acc = new controlAccount();
                acc.editAdmin(AdFName, AdPass, adPhone, AdAddress);
                if (!AdFName.equals("")) {
                    account.setName(AdFName);
                }
                if (!adPhone.equals("")) {
                    int AdPhone = parseInt(adPhone);
                    account.setPhone(adPhone);
                }
                if (!AdAddress.equals("")) {
                    account.setAddress(AdAddress);
                }

                session.setAttribute("option", "History");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Ban")) {
                int CID = parseInt(request.getParameter("CID"));
                controlAccount acc = new controlAccount();
                acc.ban(CID);
                session.setAttribute("option", "Customer");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Admin_Car_Unban")) {
                int CID = parseInt(request.getParameter("CID"));
                controlAccount acc = new controlAccount();
                acc.unban(CID);
                session.setAttribute("option", "Customer");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Register")) {
                String CName = request.getParameter("CName");
                String cINumber = request.getParameter("CINumber");
                int CINumber = parseInt(cINumber);
                Authenticator authen = new Authenticator();
                if (authen.checkSame(CName, CINumber)) {
                    session.setAttribute("checkAccount", "exist");
                    response.sendRedirect("Register.jsp");
                } else {
                    String CPass = request.getParameter("CPass");
                    CPass = authen.hashPassword(CPass);
                    String CFName = request.getParameter("CFName");
                    String cPhone = request.getParameter("CPhone");
                    String CAddress = request.getParameter("CAddress");
                    //int CPhone = Integer.parseInt(cPhone);
                    String Name = CFName;
                    String Address = CAddress;
                    String Phone = cPhone;
                    
                    controlAccount acc = new controlAccount();
                    acc.register(CName, CPass, CFName, cPhone, CAddress, CINumber);         
                    out.println(CPass);
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = DriverManager.getConnection(connectionURL, "root", "");
                        statement = connection.createStatement();

                    } catch (SQLException ex) {
                    }
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
                    }
                }
            } else if (action.equals("rentCar")) {
                int ID = Integer.parseInt(request.getParameter("ID"));
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date current = new Date();
                String getDate = df.format(current);
                controlAccount acc = new controlAccount();
                acc.rent(CarID, ID, getDate);
                response.sendRedirect("homePage.jsp");
            } else if (action.equals("like")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                Car car = new Car();
                car.like(CarID);
                response.sendRedirect("homePage.jsp");
            } else if (action.equals("dislike")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                Car car = new Car();
                car.dislike(CarID);
                response.sendRedirect("homePage.jsp");
            } else if (action.equals("getCar")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date current = new Date();
                String getDate = df.format(current);
                controlAccount acc = new controlAccount();
                acc.get(CarID, getDate);
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
                controlAccount acc = new controlAccount();
                acc.returnn(CarID, CID, TimeRent, TimeReturn, CFName, CarName, Price, Discount);
                session.setAttribute("option", "Rent");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("CancelOrder")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                controlAccount acc = new controlAccount();
                acc.cancelOrder(CarID);
                session.setAttribute("option", "Rent");
                response.sendRedirect("Admin.jsp");
            } else if (action.equals("Customer_Edit_Profile")) {
                int CID = Integer.parseInt(request.getParameter("CID"));
                String CPass = request.getParameter("CPass");
                Authenticator authen = new Authenticator();
                CPass = authen.hashPassword(CPass);
                String CFName = request.getParameter("CFName");
                String CPhone = request.getParameter("CPhone");
                String CAddress = request.getParameter("CAddress");
                Account account = (Account) request.getSession().getAttribute("account");
                controlAccount acc = new controlAccount();
                acc.editCustomer(CID, CPass, CFName, CPhone, CAddress);
                if (!CFName.equals("")) {
                    account.setName(CFName);
                }
                if (!CPhone.equals("")) {
                    account.setPhone(CPhone);
                }
                if (!CAddress.equals("")) {
                    account.setAddress(CAddress);
                }
                session.setAttribute("option", "allCars");
                response.sendRedirect("homePage.jsp");

            } else if (action.equals("cancelOrder")) {
                int CarID = Integer.parseInt(request.getParameter("CarID"));
                controlAccount acc = new controlAccount();
                acc.cancelOrder(CarID);
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
