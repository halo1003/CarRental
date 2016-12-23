package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Connection;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CarHome</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <script TYPE=\"text/javascript\">\n");
      out.write("            function checkType() {\n");
      out.write("                var type = document.forms[\"rentButton\"][\"type\"].value;\n");
      out.write("                if (type == -1) {\n");
      out.write("                    alert(\"You must login first\");\n");
      out.write("                    return false;\n");
      out.write("                } else if (type == 0) {\n");
      out.write("                    alert(\"You don't need to rent what you own\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Rented\");\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkVote() {\n");
      out.write("\n");
      out.write("                var type = document.forms[\"rentButton\"][\"type\"].value;\n");
      out.write("                if (type == -1) {\n");
      out.write("                    alert(\"You must login first\");\n");
      out.write("                    return false;\n");
      out.write("                } else if (type == 0) {\n");
      out.write("                    alert(\"Admin can't vote\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Thanks for voting\");\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkPassword() {\n");
      out.write("                var pass = document.forms[\"EditForm\"][\"CPass\"].value;\n");
      out.write("                var repass = document.forms[\"EditForm\"][\"Re-CPass\"].value;\n");
      out.write("                if (pass != repass) {\n");
      out.write("                    alert(\"Password not equals to Re-Password\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Edit profile successful!\");\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String connectionURL = "jdbc:mysql://localhost:3306/carrental?user=root;password=";
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            Statement statement2 = null;
            ResultSet rs2 = null;

        
      out.write("\n");
      out.write("        ");
            String option = null;
            option = request.getParameter("option");
            if (option == null) {
                option = "allCars";
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
      out.write("        <div class=\"topHome\">\n");
      out.write("            ");

                String type = null;
                int ID = Integer.parseInt(account.getID());
                if (account.getID().equals("-1")) {
                    type = "-1";
                    out.print("<div class='topHomeL'><p>Welcome to Car Home " + "</p></div>");
                } else if (account.getID().equals("0")) {
                    type = "0";
                    out.print("<div class='topHomeL'><p>Welcome " + account.getName() + "</p></div>");
                } else {
                    type = "1";
                    out.print("<div class='topHomeL'><p>Welcome " + account.getName() + "</p></div>");
                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                if (account.getID().equals("-1")) {
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class='topHomeR'>\n");
      out.write("                <a href='Login.jsp'><div class=\"buttonLogin buttonColor\">Login</div></a>\n");
      out.write("                <a href='Register.jsp'><div class=\"buttonLogin buttonColor\">Register</div></a>\n");
      out.write("            </div>\n");
      out.write("            ");

            } else if (account.getID().equals("0")) {
      out.write("\n");
      out.write("            <div class='topHomeR'>\n");
      out.write("                <a href='Admin.jsp'><div class=\"buttonLogin buttonColor\">Admin</div></a>\n");
      out.write("                <a href='Login.jsp'><div class=\"buttonLogin buttonColor\">Logout</div></a>\n");
      out.write("            </div>\n");
      out.write("            ");
} else {
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class='topHomeR'>\n");
      out.write("                <div class=\"buttonLogin buttonColor \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"editCustomer\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonLogin buttonColor\" value=\"Edit\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"buttonLogin buttonColor \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"Rent\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonLogin buttonColor\" value=\"Rent\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <a href='Login.jsp'><div class=\"buttonLogin buttonColor\">Logout</div></a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"optionHome\">");
///////////
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"optionL\">\n");
      out.write("                <div class=\"optionLHeader \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"allCars\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonHome\" value=\"All Cars\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"optionLHeader \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"Discount\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonHome\" value=\"Discount\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"optionLHeader \">Car Type</div>\n");
      out.write("                <div class=\"optionLHeader \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"travel\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonHome\" value=\"o Travel\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"optionLHeader \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"family\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonHome\" value=\"o Family\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"optionLHeader \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"sport\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonHome\" value=\"o Sport\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"optionLHeader \">\n");
      out.write("                    <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"option\" value=\"pony\">\n");
      out.write("                        <input type=\"submit\" class=\"buttonHome\" value=\"o Pony\" >\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <form method=\"post\" action=\"homePage.jsp\">\n");
      out.write("                    <input type=\"hidden\" name=\"option\" value=\"search\">\n");
      out.write("                    <div class=\"optionLHeaderBlank \"><input  type=\"text\" name=\"searchValue\" class=\"searchBlank\" ></div>\n");
      out.write("                    <div class=\"optionLHeaderSearch \"><input type=\"submit\" class=\"buttonHome\" value=\"Search\" ></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            ");
//Contact
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection(connectionURL, "root", "");
                    statement = connection.createStatement();
                } catch (SQLException ex) {
                }
                rs = statement.executeQuery("SELECT * FROM admin");
                String AdPhone = "";
                String AdAddress = "";
                String AdFName = "";
                if (rs.next()) {
                    AdFName = rs.getString("AdFName");
                    AdPhone = rs.getString("AdPhone");
                    AdAddress = rs.getString("AdAddress");
                }
                connection.close();
                /////

      out.write("\n");
      out.write("\n");
      out.write("            <div style=\"width: 1300px; margin: auto;\">\n");
      out.write("                <div class=\"contact\">\n");
      out.write("                    <div style=\"font-family: font3; font-size: 33px; color: palevioletred;\">\n");
      out.write("                        Best Cars - Best Trips - Best Moments\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"divContactR\">\n");
      out.write("                        <p>Address</p>\n");
      out.write("                        <p>Hotline</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"divContactL\">\n");
      out.write("                        <p>: ");
      out.print(AdAddress);
      out.write("</p>\n");
      out.write("                        <p>: 0");
      out.print(AdPhone);
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"optionR\">\n");
      out.write("                    ");

                        if (option.equals("editCustomer")) {
                    
      out.write("\n");
      out.write("                    <div class=\"formEditCustomer\">\n");
      out.write("                        <div class=\"editHeader\">Edit Customer Profile</div>\n");
      out.write("                        <form method=\"post\" action=\"check\" name=\"EditForm\" onsubmit=\"return checkPassword();\">\n");
      out.write("                            <div class=\"rowEdit removeSpace\">\n");
      out.write("                                <div class=\"col1\">\n");
      out.write("                                    <div class=\"headerEdit\">Pass</div>\n");
      out.write("                                    <div class=\"headerEdit\">re-Pass</div>\n");
      out.write("                                    <div class=\"headerEdit\">Full Name</div>\n");
      out.write("                                    <div class=\"headerEdit\">Phone</div>\n");
      out.write("                                    <div class=\"headerEdit\">Address</div>\n");
      out.write("                                    <div class=\"buttonEdit1\"><input type=\"reset\" class=\"button buttonBlack\" value=\"Cancel\" style=\"font-size: 20px;\"></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col2\">\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"password\" class=\"editCarBlank\" name=\"CPass\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"password\" class=\"editCarBlank\" name=\"Re-CPass\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"CFName\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"CPhone\"></div>\n");
      out.write("                                    <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"CAddress\"></div>\n");
      out.write("                                    <div class=\"buttonEdit2\"><input type=\"submit\" class=\"button buttonBlack\" value=\"Change\" style=\"font-size: 20px;\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>    \n");
      out.write("\n");
      out.write("                            <input type=\"hidden\" value=\"Customer_Edit_Profile\" name=\"action\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print(ID);
      out.write("\" name=\"CID\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");

                    } else if (option.equals("Rent")) {
                        try {
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            connection = DriverManager.getConnection(connectionURL, "root", "");
                            statement = connection.createStatement();
                            statement2 = connection.createStatement();
                        } catch (SQLException ex) {
                        }

                        rs = statement.executeQuery("SELECT * FROM rent WHERE CID=" + ID + " and RentType ='W'");
                        while (rs.next()) {
                            int CarID = rs.getInt("CarID");
                            rs2 = statement2.executeQuery("SELECT * FROM car WHERE CarID=" + CarID);
                            while (rs2.next()) {
                                String CarName = rs2.getString("CarName");
                                String Discount = rs2.getString("Discount");
                                String CarType = rs2.getString("CarType");
                                String Seats = rs2.getString("Seats");
                                String Color = rs2.getString("Color");
                                String Img = rs2.getString("Img");
                                String Introduce = rs2.getString("Introduce");
                                String Price = rs2.getString("Price");
                                String Like = rs2.getString("Like");
                                String Dislike = rs2.getString("Dislike");
                                int like = Integer.parseInt(Like);
                                int dislike = Integer.parseInt(Dislike);

                    
      out.write("\n");
      out.write("                    <div class=\"formCar\">\n");
      out.write("                        <div class=\"formCarL\">\n");
      out.write("                            <div class=\"stars\">\n");
      out.write("                                ");
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
                                    if (star > 0) {
                                        for (int i = 1; i <= star; i++) {
                                
      out.write("\n");
      out.write("                                <div style=\" width: 20%; font-size: 0; height: 30px; display: inline-block;\"><img src=\"background/star.png\" height=\"30\" width=\"30\"></div>\n");
      out.write("                                    ");

                                        }
                                    } else {
                                    
      out.write("<div style=\" width: 20%; font-size: 0; height: 30px; display: inline-block;\"></div>");

                                        }


                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"carImg\">\n");
      out.write("                                <img src=\"");
      out.print(Img);
      out.write("\" class=\"imgCar\">\n");
      out.write("                            </div>\n");
      out.write("                            <div style=\"font-size: 0; width: 100%; height: 30px;\">\n");
      out.write("                                <div class=\"like\">\n");
      out.write("                                    <form method=\"post\" action=\"check\" name=\"rentButton\" onsubmit=\"return checkVote()\">\n");
      out.write("                                        <input type=\"hidden\" name=\"action\" value=\"like\">\n");
      out.write("                                        <input type=\"hidden\" name=\"CarID\" value=\"");
      out.print(CarID);
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" value=\"Like\" class=\"likeButton button buttonBlack\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"dislike\">\n");
      out.write("                                    <form method=\"post\" action=\"check\" name=\"rentButton\" onsubmit=\"return checkVote()\">\n");
      out.write("                                        <input type=\"hidden\" name=\"action\" value=\"dislike\">\n");
      out.write("                                        <input type=\"hidden\" name=\"CarID\" value=\"");
      out.print(CarID);
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" value=\"Dislike\" class=\"dislikeButton button buttonBlack\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"formCarR\">\n");
      out.write("                            <div class=\"carInfo\">\n");
      out.write("                                <pHeader>");
      out.print(CarName);
      out.write("</pHeader>\n");
      out.write("                                <p>Type: ");
      out.print(CarType);
      out.write("</p>\n");
      out.write("                                <p>Seats: ");
      out.print(Seats);
      out.write("</p>\n");
      out.write("                                <p>Color: ");
      out.print(Color);
      out.write("</p>\n");
      out.write("                                <p>Introduce: ");
      out.print(Introduce);
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div style=\"font-size: 0; width: 100%; height: 30px;\">\n");
      out.write("                                <div class=\"carPrice\">\n");
      out.write("                                    $");
      out.print(Price);
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"carDiscount\">\n");
      out.write("                                    Sale ");
      out.print(Discount);
      out.write("%\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"rentButton\">\n");
      out.write("                                    <form method=\"post\" action=\"check\">\n");
      out.write("                                        <input type=\"hidden\" name=\"action\" value=\"cancelOrder\">\n");
      out.write("                                        <input type=\"hidden\" name=\"CarID\" value=\"");
      out.print(CarID);
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" value=\"Cancel\" class=\"rentButtonn button buttonBlack\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    ");
 }

                        }
                        connection.close();
                    } else {
                        //connect database
                        try {
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            connection = DriverManager.getConnection(connectionURL, "root", "");
                            statement = connection.createStatement();
                        } catch (SQLException ex) {
                        }
                        if (option.equals("allCars")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and c.CarID not in (SELECT r.CarID FROM rent r)");
                        } else if (option.equals("Discount")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and (c.Discount > 0) and (c.CarID not in (SELECT r.CarID FROM rent r))");
                        } else if (option.equals("travel")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and (c.CarType = 'Travel') and (c.CarID not in (SELECT r.CarID FROM rent r))");
                        } else if (option.equals("family")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and (c.CarType = 'Family') and (c.CarID not in (SELECT r.CarID FROM rent r))");
                        } else if (option.equals("sport")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and (c.CarType = 'Sport') and (c.CarID not in (SELECT r.CarID FROM rent r))");
                        } else if (option.equals("pony")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and (c.CarType = 'Pony') and (c.CarID not in (SELECT r.CarID FROM rent r))");
                        } else if (option.equals("search")) {
                            rs = statement.executeQuery("SELECT c.* FROM car c WHERE c.Status!='U' and (c.CarID not in (SELECT r.CarID FROM rent r)) and (c.CarName='" + request.getParameter("searchValue") + "' || c.Price='" + request.getParameter("searchValue") + "' || c.Seats='" + request.getParameter("searchValue") + "' || c.Color='" + request.getParameter("searchValue") + "' )");
                        }
                        while (rs.next()) {
                            int CarID = Integer.parseInt(rs.getString("CarID"));
                            String CarName = rs.getString("CarName");
                            String Discount = rs.getString("Discount");
                            String CarType = rs.getString("CarType");
                            String Seats = rs.getString("Seats");
                            String Color = rs.getString("Color");
                            String Img = rs.getString("Img");
                            String Introduce = rs.getString("Introduce");
                            String Price = rs.getString("Price");
                            String Like = rs.getString("Like");
                            String Dislike = rs.getString("Dislike");
                            int like = Integer.parseInt(Like);
                            int dislike = Integer.parseInt(Dislike);

                    
      out.write("\n");
      out.write("                    <div class=\"formCar\">\n");
      out.write("                        <div class=\"formCarL\">\n");
      out.write("                            <div class=\"stars\">\n");
      out.write("                                ");
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
                                    if (star > 0) {
                                        for (int i = 1; i <= star; i++) {
                                
      out.write("\n");
      out.write("                                <div style=\" width: 20%; font-size: 0; height: 30px; display: inline-block;\"><img src=\"background/star.png\" height=\"30\" width=\"30\"></div>\n");
      out.write("                                    ");

                                        }
                                    } else {
                                    
      out.write("<div style=\" width: 20%; font-size: 0; height: 30px; display: inline-block;\"></div>");

                                        }


                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"carImg\">\n");
      out.write("                                <img src=\"");
      out.print(Img);
      out.write("\" class=\"imgCar\">\n");
      out.write("                            </div>\n");
      out.write("                            <div style=\"font-size: 0; width: 100%; height: 30px;\">\n");
      out.write("                                <div class=\"like\">\n");
      out.write("                                    <form method=\"post\" action=\"check\" name=\"rentButton\" onsubmit=\"return checkVote()\">\n");
      out.write("                                        <input type=\"hidden\" name=\"action\" value=\"like\">\n");
      out.write("                                        <input type=\"hidden\" name=\"CarID\" value=\"");
      out.print(CarID);
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" value=\"Like\" class=\"likeButton button buttonBlack\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"dislike\">\n");
      out.write("                                    <form method=\"post\" action=\"check\" name=\"rentButton\" onsubmit=\"return checkVote()\">\n");
      out.write("                                        <input type=\"hidden\" name=\"action\" value=\"dislike\">\n");
      out.write("                                        <input type=\"hidden\" name=\"CarID\" value=\"");
      out.print(CarID);
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" value=\"Dislike\" class=\"dislikeButton button buttonBlack\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"formCarR\">\n");
      out.write("                            <div class=\"carInfo\">\n");
      out.write("                                <pHeader>");
      out.print(CarName);
      out.write("</pHeader>\n");
      out.write("                                <p>Type: ");
      out.print(CarType);
      out.write("</p>\n");
      out.write("                                <p>Seats: ");
      out.print(Seats);
      out.write("</p>\n");
      out.write("                                <p>Color: ");
      out.print(Color);
      out.write("</p>\n");
      out.write("                                <p>Introduce: ");
      out.print(Introduce);
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div style=\"font-size: 0; width: 100%; height: 30px;\">\n");
      out.write("                                <div class=\"carPrice\">\n");
      out.write("                                    $");
      out.print(Price);
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"carDiscount\">\n");
      out.write("                                    Sale ");
      out.print(Discount);
      out.write("%\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"rentButton\">\n");
      out.write("                                    <form method=\"post\" action=\"check\" name=\"rentButton\" onsubmit=\"return checkType()\">\n");
      out.write("                                        <input type=\"hidden\" name=\"action\" value=\"rentCar\">\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"ID\" value=\"");
      out.print(ID);
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"CarID\" value=\"");
      out.print(CarID);
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" value=\"Rent\" class=\"rentButtonn button buttonBlack\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    ");
 }
                        connection.close();
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>  \n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
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
