package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <script TYPE=\"text/javascript\">\n");
      out.write("            function checkInput() {\n");
      out.write("                var name = document.forms[\"addCarForm\"][\"name\"].value;\n");
      out.write("                var price = document.forms[\"addCarForm\"][\"price\"].value;\n");
      out.write("                var discount = document.forms[\"addCarForm\"][\"discount\"].value;\n");
      out.write("                var seat = document.forms[\"addCarForm\"][\"seat\"].value;\n");
      out.write("                var color = document.forms[\"addCarForm\"][\"color\"].value;\n");
      out.write("                if (checkName(name) == 0 || checkPrice(price) == 0 || checkDiscount(discount) == 0 || checkSeat(seat) == 0 || checkColor(color) == 0) {\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkName(name) {\n");
      out.write("                if (name == \"\") {\n");
      out.write("                    alert(\"Car name not null\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkPrice(price) {\n");
      out.write("                if (price == \"\") {\n");
      out.write("                    alert(\"Price not null\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkDiscount(discount) {\n");
      out.write("                if (discount >= 100) {\n");
      out.write("                    alert(\"Invalid! 0 < Discount < 100\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkSeat(seat) {\n");
      out.write("                if (seat == \"\") {\n");
      out.write("                    alert(\"A number of seats is not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (seat >= 50) {\n");
      out.write("                    alert(\"Not correct! what is this car??? A lot of seats!\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkColor(color) {\n");
      out.write("                if (color == \"\") {\n");
      out.write("                    alert(\"color not null\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkPassword() {\n");
      out.write("                var pass = document.forms[\"EditForm\"][\"AdPass\"].value;\n");
      out.write("                var repass = document.forms[\"EditForm\"][\"Re-AdPass\"].value;\n");
      out.write("                if (pass != repass) {\n");
      out.write("                    alert(\"Password not equals to Re-Password\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Edit profile successful!\");\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  //declare
            String connectionURL = "jdbc:mysql://localhost:3306/carrental?user=root;password=";
            Connection connection = null;
            Statement statement = null;
            Statement statement2 = null;
            ResultSet rs = null;
            ResultSet rs2 = null;
            //connect database
            /*try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(connectionURL, "root", "");
                statement = connection.createStatement();
                statement2 = connection.createStatement();
            } catch (SQLException ex) {
            }*/
        
      out.write("\n");
      out.write("        ");

            String option = null;
            option = request.getParameter("option");
            if (option == null) {
                option = (String) session.getAttribute("option");
            }
        
      out.write("\n");
      out.write("        ");
      storeAccount.Account account = null;
      synchronized (session) {
        account = (storeAccount.Account) _jspx_page_context.getAttribute("account", PageContext.SESSION_SCOPE);
        if (account == null){
          account = new storeAccount.Account();
          _jspx_page_context.setAttribute("account", account, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <!-- -->\n");
      out.write("        <div class=\"topHome\">\n");
      out.write("\n");
      out.write("            <div class='topHomeL'><p>Welcome MR.");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((storeAccount.Account)_jspx_page_context.findAttribute("account")).getName())));
      out.write("</p></div>\n");
      out.write("\n");
      out.write("            <div class='topHomeR'>\n");
      out.write("                <a href='homePage.jsp'><div class=\"buttonLogin buttonColor\">Home</div></a>\n");
      out.write("                <a href='Login.jsp'><div class=\"buttonLogin buttonColor\">Login</div></a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"adBody removeSpace\">\n");
      out.write("\n");
      out.write("            <div class=\"adOptions\">\n");
      out.write("                <div class=\"adOption\">\n");
      out.write("                    <form method=\"post\" action=\"Admin.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"Rent\">\n");
      out.write("                        <input type=\"submit\" class=\"button buttonPink\" value=\"Rent\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"adOption\">\n");
      out.write("                    <form method=\"post\" action=\"Admin.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"Car\">\n");
      out.write("                        <input type=\"submit\" class=\"button buttonPink\" value=\"Car\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"adOption\">\n");
      out.write("                    <form method=\"post\" action=\"Admin.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"Customer\">\n");
      out.write("                        <input type=\"submit\" class=\"button buttonPink\" value=\"Customer\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"adOption\">\n");
      out.write("                    <form method=\"post\" action=\"Admin.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"addCar\">\n");
      out.write("                        <input type=\"submit\" class=\"button buttonPink\" value=\"Add Car\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"adOption\">\n");
      out.write("                    <form method=\"post\" action=\"Admin.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"History\">\n");
      out.write("                        <input type=\"submit\" class=\"button buttonPink\" value=\"History\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"adOption\">\n");
      out.write("                    <form method=\"post\" action=\"Admin.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"Edit\">\n");
      out.write("                        <input type=\"submit\" class=\"button buttonPink\" value=\"Edit\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"showOption\">\n");
      out.write("                ");

                    if (option.equals("History")) {
                
      out.write("\n");
      out.write("                <div style=\"font-size: 40px; font-family: font1; text-align: center; color: white; width: 797px; margin: auto;background-color: rgba(0,0,0,0.8);;\">Histories</div>\n");
      out.write("                <div style=\"width:797px; margin: auto;     background-color: rgba(0,0,0,0.8);   \">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        out.print("<div class='historys removeSpace'>");
                        out.print("<div class='history historyName headerHistory'>" + "Full Name" + "</div>" + "<div class='history historyName headerHistory'>" + "Car" + "</div>" + "<div class='history historyTime headerHistory'>" + "Time rent" + "</div>" + "<div class='history historyTime headerHistory'>" + "Time return" + "</div>" + "<div class='history historyPayment headerHistory'>" + "Payment" + "</div>");
                        out.print("</div>");
                        //change
                        try {
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            connection = DriverManager.getConnection(connectionURL, "root", "");
                            statement = connection.createStatement();
                        } catch (SQLException ex) {
                        }
                        rs = statement.executeQuery("SELECT * FROM history");
                        while (rs.next()) {
                            String CFName = rs.getString("CFName");
                            String CarName = rs.getString("CarName");
                            String TimeRent = rs.getString("TimeRent");
                            String TimeReturn = rs.getString("TimeReturn");
                            String Payment = rs.getString("Payment");
                            out.print("<div class='historys removeSpace'>");
                            out.print("<div class='history historyName'>" + CFName + "</div>" + "<div class='history historyName'>" + CarName + "</div>" + "<div class='history historyTime'>" + TimeRent + "</div>" + "<div class='history historyTime'>" + TimeReturn + "</div>" + "<div class='history historyPayment'>" + Payment + "</div>");
                            out.print("</div>");
                        }
                        connection.close();
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("                ");
} else if (option.equals("Car")) {
      out.write("\n");
      out.write("                <div style=\"font-size: 40px; font-family: font1; text-align: center; color: white; width: 825px;; margin: auto;background-color: rgba(0,0,0,0.8);;\">All Car in system</div>\n");
      out.write("                <div style=\"width: 825px;; margin: auto;     background-color: rgba(0,0,0,0.8);   \">\n");
      out.write("                    ");

                        String a = option;
                        out.print("<div class='historys removeSpace'>");
                        out.print("</div>");
                        out.print("<div class='historys removeSpace'>");
                        out.print("<div class='history divID headerHistory'>" + "Name" + "</div>" + "<div class='history historyName headerHistory'>" + "Name" + "</div>" + "<div class='history showCarAdmin headerHistory'>" + "Price($)" + "</div>" + "<div class='history showCarAdmin headerHistory'>" + "Discount(%)" + "</div>" + "<div class='history showCarAdmin headerHistory'>" + "Rate" + "</div>" + "<div class='history showCarAdmin headerHistory'>" + "Status" + "</div>");
                        out.print("</div>");
                        //change
                        try {
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            connection = DriverManager.getConnection(connectionURL, "root", "");
                            statement = connection.createStatement();
                        } catch (SQLException ex) {
                        }
                        rs = statement.executeQuery("SELECT * FROM car c WHERE CarID not IN (SELECT r.CarID FROM rent r)");
                        while (rs.next()) {
                            String CarID = rs.getString("CarID");
                            String CarName = rs.getString("CarName");
                            String Discount = rs.getString("Discount");
                            String Price = rs.getString("Price");
                            String Like = rs.getString("Like");
                            String Dislike = rs.getString("Dislike");
                            String Status = rs.getString("Status");
                            int like = Integer.parseInt(Like);
                            int dislike = Integer.parseInt(Dislike);
                            float x;
                            int star = 0;
                            x = (float) like / (float) dislike;
                            if (x < 0.5) {
                                star = 0;
                            } else if (0.5 <= x && x < 1.5) {
                                star = 1;
                            } else if (1.5 <= x && x < 2.5) {
                                star = 2;
                            } else if (2.5 <= x && x < 3.5) {
                                star = 3;
                            } else if (3.5 <= x && x < 4.5) {
                                star = 4;
                            } else if (4.5 <= x) {
                                star = 5;
                            }

                            out.print("<div class='historys removeSpace'>");
                            out.print("<div class='history divID'>" + CarID + "</div>" + "<div class='history historyName'>" + CarName + "</div>" + "<div class='history showCarAdmin'>" + Price + "</div>" + "<div class='history showCarAdmin'>" + Discount + "</div>" + "<div class='history showCarAdmin'>" + star + "</div>" + "<div class='history showCarAdmin'>" + Status + "</div>"
                                    + "<div class='history tableCarList1'>"
                                    + "<form method='post' action='check'>"
                                    + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                    + "<input type='hidden' value='Admin_Car_Edit' name='action'>"
                                    + "<input type='Submit' class='button buttonBlack' value='Edit'>"
                                    + "</form></div>");
                            if (Status.equals("A")) {
                                out.print("<div class='history tableCarList2'>"
                                        + "<form method='post' action='check'>"
                                        + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                        + "<input type='hidden' value='Admin_Car_Update' name='action'>"
                                        + "<input type='Submit' class='button buttonBlack' value='Update'>"
                                        + "</form></div>");
                            } else if (Status.equals("U")) {
                                out.print("<div class='history tableCarList2'>"
                                        + "<form method='post' action='check'>"
                                        + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                        + "<input type='hidden' value='Admin_Car_Already' name='action'>"
                                        + "<input type='Submit' class='button buttonBlack' value='Already'>"
                                        + "</form></div>");
                            }
                            out.print("<div class='history tableCarList2'>"
                                    + "<form method='post' action='check'>"
                                    + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                    + "<input type='hidden' value='Admin_Car_Delete' name='action'>"
                                    + "<input type='Submit' class='button buttonBlack' value='Delete'>"
                                    + "</form></div>");
                            out.print("</div>");
                        }
                        connection.close();
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("                ");
}
else if (option.equals("carEdit")) {
      out.write(" \n");
      out.write("                ");

                    String ID = (String) session.getAttribute("CarID");

                
      out.write("\n");
      out.write("                <div class=\"formEdit\">\n");
      out.write("                    <div class=\"editHeader\">Edit Car Form</div>\n");
      out.write("                    <form method=\"post\" action=\"check\">\n");
      out.write("                        <div class=\"rowEdit removeSpace\">\n");
      out.write("                            <div class=\"col1\">\n");
      out.write("                                <div class=\"headerEdit\">Name</div>\n");
      out.write("                                <div class=\"headerEdit\">Price($)</div>\n");
      out.write("                                <div class=\"headerEdit\">Discount(%)</div>\n");
      out.write("                                <div class=\"buttonEdit1\"><input type=\"reset\" class=\"button buttonBlack\" value=\"Cancel\" style=\"font-size: 20px;\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col2\">\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"name\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" name=\"price\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" name=\"discount\"></div>\n");
      out.write("                                <div class=\"buttonEdit2\"><input type=\"submit\" class=\"button buttonBlack\" value=\"Change\" style=\"font-size: 20px;\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>    \n");
      out.write("\n");
      out.write("                        <input type=\"hidden\" value=\"Admin_Car_Edit_Form\" name=\"action\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(ID);
      out.write("\" name=\"carID\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                ");
}
else if (option.equals("addCar")) {
      out.write("\n");
      out.write("                <div class=\"formEdit\">\n");
      out.write("                    <div class=\"editHeader\">Add New Car</div>\n");
      out.write("                    <form method=\"post\" action=\"check\" name=\"addCarForm\" onsubmit=\"return checkInput()\">\n");
      out.write("                        <div class=\"rowEdit removeSpace\">\n");
      out.write("                            <div class=\"col1\">\n");
      out.write("                                <div class=\"headerEdit\">Car Name</div>\n");
      out.write("                                <div class=\"headerEdit\">Price($)</div>\n");
      out.write("                                <div class=\"headerEdit\">Discount(%)</div>\n");
      out.write("                                <div class=\"headerEdit\">Type</div>\n");
      out.write("                                <div class=\"headerEdit\">Seats</div>\n");
      out.write("                                <div class=\"headerEdit\">Color</div>\n");
      out.write("                                <div class=\"headerEdit\">Introduce</div>\n");
      out.write("                                <div class=\"buttonEdit1\"><input type=\"reset\" class=\"button buttonBlack\" value=\"Cancel\" style=\"font-size: 20px;\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col2\">\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"name\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" min=\"50\" name=\"price\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" min=\"0\" name=\"discount\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><select style=\"border: 1px solid\" name=\"carType\">\n");
      out.write("                                        <option value=\"Travel\">Travel car</option>\n");
      out.write("                                        <option value=\"Sport\">Sport car</option>\n");
      out.write("                                        <option value=\"Family\">Family car</option>\n");
      out.write("                                        <option value=\"Pony\">Pony car</option>\n");
      out.write("                                        <option value=\"Normal\">Normal car</option>\n");
      out.write("                                    </select></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" min=\"2\" name=\"seat\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"color\"></div>\n");
      out.write("                                <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"introduce\"></div>\n");
      out.write("                                <input type=\"hidden\" value=\"Admin_Car_addCar\" name=\"action\">\n");
      out.write("                                <div class=\"buttonEdit2\"><input type=\"submit\" class=\"button buttonBlack\" value=\"Add\" style=\"font-size: 20px;\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>    \n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                ");
}
else if (option.equals("Customer")) {
      out.write("\n");
      out.write("                <div style=\"font-size: 40px; font-family: font1; text-align: center; color: white; width: 657px; margin: auto;background-color: rgba(0,0,0,0.8);\">Control Customers</div>\n");
      out.write("                <div style=\"width: 657px; margin: auto;     background-color: rgba(0,0,0,0.8);   \">\n");
      out.write("\n");
      out.write("                    ");

                            out.print("<div class='historys removeSpace'>");

                            out.print("</div>");
                            out.print("<div class='historys removeSpace'>");
                            out.print("<div class='history historyName headerHistory'>" + "Full Name" + "</div>" + "<div class='history customerAdmin headerHistory'>" + "Phone Number" + "</div>" + "<div class='history customerAdmin headerHistory'>" + "Address" + "</div>" + "<div class='history customerAdmin headerHistory'>" + "Identity Number" + "</div>");
                            out.print("</div>");
                            //change
                            try {
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                connection = DriverManager.getConnection(connectionURL, "root", "");
                                statement = connection.createStatement();
                                statement2 = connection.createStatement();
                            } catch (SQLException ex) {
                            }
                            rs = statement.executeQuery("SELECT * FROM customer");
                            while (rs.next()) {
                                String CID = rs.getString("CID");
                                String CFName = rs.getString("CFName");
                                String CPhone = rs.getString("CPhone");
                                String CAddress = rs.getString("CAddress");
                                String CINumber = rs.getString("CINumber");
                                out.print("<div class='historys removeSpace'>");
                                out.print("<div class='history historyName'>" + CFName + "</div>" + "<div class='history customerAdmin'>" + CPhone + "</div>" + "<div class='history customerAdmin'>" + CAddress + "</div>" + "<div class='history customerAdmin'>" + CINumber + "</div>");
                                rs2 = statement2.executeQuery("SELECT * FROM ban WHERE CID = '" + CID + "'");
                                if (rs2.next()) {
                                    out.print("<div class='history tableCarList2'>"
                                            + "<form method='post' action='check'>"
                                            + "<input type='hidden' name='CID' value='" + CID + "'>"
                                            + "<input type='hidden' value='Admin_Car_Unban' name='action'>"
                                            + "<input type='Submit' class='button buttonBlack' value='unBan'>"
                                            + "</form></div>");
                                } else {
                                    out.print("<div class='history tableCarList2'>"
                                            + "<form method='post' action='check'>"
                                            + "<input type='hidden' name='CID' value='" + CID + "'>"
                                            + "<input type='hidden' value='Admin_Car_Ban' name='action'>"
                                            + "<input type='Submit' class='button buttonBlack' value='Ban'>"
                                            + "</form></div>");
                                }

                                out.print("</div>");
                            }
                            out.print("</div>");
                            connection.close();

                        }
else if (option.equals("Edit")) {
      out.write("\n");
      out.write("                    <div class=\"formEdit\">\n");
      out.write("                        <div class=\"editHeader\">Edit Admin Info</div>\n");
      out.write("                        <form method=\"post\" action=\"check\" name=\"EditForm\" onsubmit=\"return checkPassword()\">\n");
      out.write("                            <div class=\"rowEdit removeSpace\">\n");
      out.write("                                <div class=\"col1\">\n");
      out.write("                                    <div class=\"headerEdit\">Full Name</div>\n");
      out.write("                                    <div class=\"headerEdit\">Pass</div>\n");
      out.write("                                    <div class=\"headerEdit\">Re-Pass</div>\n");
      out.write("                                    <div class=\"headerEdit\">Phone</div>\n");
      out.write("                                    <div class=\"headerEdit\">Address</div>\n");
      out.write("                                    <div class=\"buttonEdit1\"><input type=\"reset\" class=\"button buttonBlack\" value=\"Cancel\" style=\"font-size: 20px;\"></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col2\">\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"AdFName\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"password\" class=\"editCarBlank\" name=\"AdPass\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"password\" class=\"editCarBlank\" name=\"Re-AdPass\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" name=\"AdPhone\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"AdAddress\"></div>\n");
      out.write("                                    <div class=\"buttonEdit2\"><input type=\"submit\" class=\"button buttonBlack\" value=\"Change\" style=\"font-size: 20px;\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>    \n");
      out.write("\n");
      out.write("                            <input type=\"hidden\" value=\"Admin_Car_EditAdmin_Form\" name=\"action\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
else if (option.equals("Rent")) {
      out.write("\n");
      out.write("\n");
      out.write("                    <div style=\"font-size: 40px; font-family: font1; text-align: center; color: white; width: 788px; margin: auto;background-color: rgba(0,0,0,0.8);\">Control Customers</div>\n");
      out.write("                    <div style=\"width: 788px; margin: auto;     background-color: rgba(0,0,0,0.8);   \">\n");
      out.write("                        ");

                            try {
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                connection = DriverManager.getConnection(connectionURL, "root", "");
                                statement = connection.createStatement();
                                statement2 = connection.createStatement();
                            } catch (SQLException ex) {
                            }
                            out.print("<div class='historys removeSpace'>");
                            out.print("<div class='history divID headerHistory'>" + "ID" + "</div>" + "<div class='history historyName headerHistory'>" + "Full Name" + "</div>" + "<div class='history divID headerHistory'>" + "CarID" + "</div>" + "<div class='history historyName headerHistory'>" + "Car Name" + "</div>" + "<div class='history historyTime headerHistory'>" + "Date & Time" + "</div>" + "<div class='history divID headerHistory'>" + "Type" + "</div>");
                            out.print("</div>");
                            rs = statement.executeQuery("SELECT * FROM rent");
                            while (rs.next()) {
                                int CarID = Integer.parseInt(rs.getString("CarID"));
                                int CID = Integer.parseInt(rs.getString("CID"));
                                String TimeRent = rs.getString("TimeRent");
                                String RentType = rs.getString("RentType");
                                String CFName = "";
                                String CarName = "";
                                rs2 = statement2.executeQuery("SELECT CFName FROM customer WHERE CID=" + CID);
                                if (rs2.next()) {
                                    CFName = rs2.getString("CFName");
                                }
                                rs2 = statement2.executeQuery("SELECT CarName FROM car WHERE CarID=" + CarID);
                                if (rs2.next()) {
                                    CarName = rs2.getString("CarName");
                                }

                                out.print("<div class='historys removeSpace'>");
                                out.print("<div class='history divID'>" + CID + "</div>" + "<div class='history historyName'>" + CFName + "</div>" + "<div class='history divID'>" + CarID + "</div>" + "<div class='history historyName'>" + CarName + "</div>" + "<div class='history historyTime'>" + TimeRent + "</div>" + "<div class='history divID'>" + RentType + "</div>");
                                if (RentType.equals("W")) {
                                    out.print("<div class='history tableCarList1'>"
                                            + "<form method='post' action='check'>"
                                            + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                            + "<input type='hidden' value='getCar' name='action'>"
                                            + "<input type='Submit' class='button buttonBlack1' value='Get'>"
                                            + "</form></div>");
                                    out.print("<div class='history tableCarList1'>"
                                            + "<form method='post' action='check'>"
                                            + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                            + "<input type='hidden' value='CancelOrder' name='action'>"
                                            + "<input type='Submit' class='button buttonBlack1' value='Cancel'>"
                                            + "</form></div>");
                                } else if (RentType.equals("R")) {
                                    out.print("<div class='history tableCarList1'>"
                                            + "<form method='post' action='check'>"
                                            + "<input type='hidden' name='CarID' value='" + CarID + "'>"
                                            + "<input type='hidden' value='Return' name='action'>"
                                            + "<input type='Submit' class='button buttonBlack1' value='Return'>"
                                            + "</form></div>");
                                }
                                out.print("</div>");

                            }
                            out.print("</div>");
                            connection.close();
                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
