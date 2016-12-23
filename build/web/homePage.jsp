<%-- 
    Document   : Customer
    Created on : Dec 9, 2016, 11:53:49 PM
    Author     : Administrator
--%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CarHome</title>
        <link rel="stylesheet" href="style.css">
        <script TYPE="text/javascript">
            function checkType() {
                var type = document.forms["rentButton"]["type"].value;
                if (type == -1) {
                    alert("You must login first");
                    return false;
                } else if (type == 0) {
                    alert("You don't need to rent what you own");
                    return false;
                } else {
                    alert("Rented");
                    return true;
                }
            }
            function checkVote() {

                var type = document.forms["rentButton"]["type"].value;
                if (type == -1) {
                    alert("You must login first");
                    return false;
                } else if (type == 0) {
                    alert("Admin can't vote");
                    return false;
                } else {
                    alert("Thanks for voting");
                    return true;
                }
            }
            function checkPassword() {
                var pass = document.forms["EditForm"]["CPass"].value;
                var repass = document.forms["EditForm"]["Re-CPass"].value;
                if (pass != repass) {
                    alert("Password not equals to Re-Password");
                    return false;
                } else {
                    alert("Edit profile successful!");
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <%
            String connectionURL = "jdbc:mysql://localhost:3306/carrental?user=root;password=";
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            Statement statement2 = null;
            ResultSet rs2 = null;

        %>
        <%            String option = null;
            option = request.getParameter("option");
            if (option == null) {
                option = "allCars";
            }
        %>
        <jsp:useBean id="account" scope="session" class="storeAccount.Account" />
        <div class="topHome">
            <%
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
            %>


            <%
                if (account.getID().equals("-1")) {
            %>

            <div class='topHomeR'>
                <a href='Login.jsp'><div class="buttonLogin buttonColor">Login</div></a>
                <a href='Register.jsp'><div class="buttonLogin buttonColor">Register</div></a>
            </div>
            <%
            } else if (account.getID().equals("0")) {%>
            <div class='topHomeR'>
                <a href='Admin.jsp'><div class="buttonLogin buttonColor">Admin</div></a>
                <a href='Login.jsp'><div class="buttonLogin buttonColor">Logout</div></a>
            </div>
            <%} else {
            %>

            <div class='topHomeR'>
                <div class="buttonLogin buttonColor ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="editCustomer">
                        <input type="submit" class="buttonLogin buttonColor" value="Edit" >
                    </form>
                </div>
                <div class="buttonLogin buttonColor ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="Rent">
                        <input type="submit" class="buttonLogin buttonColor" value="Rent" >
                    </form>
                </div>
                <a href='Login.jsp'><div class="buttonLogin buttonColor">Logout</div></a>
            </div>

            <%
                }
            %>
        </div>
        <div class="optionHome"><%///////////%>

            <div class="optionL">
                <div class="optionLHeader ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="allCars">
                        <input type="submit" class="buttonHome" value="All Cars" >
                    </form>
                </div>
                <div class="optionLHeader ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="Discount">
                        <input type="submit" class="buttonHome" value="Discount" >
                    </form>
                </div>
                <div class="optionLHeader ">Car Type</div>
                <div class="optionLHeader ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="travel">
                        <input type="submit" class="buttonHome" value="o Travel" >
                    </form>
                </div>
                <div class="optionLHeader ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="family">
                        <input type="submit" class="buttonHome" value="o Family" >
                    </form>
                </div>
                <div class="optionLHeader ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="sport">
                        <input type="submit" class="buttonHome" value="o Sport" >
                    </form>
                </div>
                <div class="optionLHeader ">
                    <form method="post" action="homePage.jsp">
                        <input type="hidden" name="option" value="pony">
                        <input type="submit" class="buttonHome" value="o Pony" >
                    </form>
                </div>
                <form method="post" action="homePage.jsp">
                    <input type="hidden" name="option" value="search">
                    <div class="optionLHeaderBlank "><input  type="text" name="searchValue" class="searchBlank" ></div>
                    <div class="optionLHeaderSearch "><input type="submit" class="buttonHome" value="Search" ></div>
                </form>
            </div>
            <%//Contact
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
%>

            <div style="width: 1300px; margin: auto;">
                <div class="contact">
                    <div style="font-family: font3; font-size: 33px; color: palevioletred;">
                        Best Cars - Best Trips - Best Moments
                    </div>
                    <div class="divContactR">
                        <p>Address</p>
                        <p>Hotline</p>
                    </div>
                    <div class="divContactL">
                        <p>: <%=AdAddress%></p>
                        <p>: 0<%=AdPhone%></p>
                    </div>
                </div>
                <div class="optionR">
                    <%
                        if (option.equals("editCustomer")) {
                    %>
                    <div class="formEditCustomer">
                        <div class="editHeader">Edit Customer Profile</div>
                        <form method="post" action="check" name="EditForm" onsubmit="return checkPassword();">
                            <div class="rowEdit removeSpace">
                                <div class="col1">
                                    <div class="headerEdit">Pass</div>
                                    <div class="headerEdit">re-Pass</div>
                                    <div class="headerEdit">Full Name</div>
                                    <div class="headerEdit">Phone</div>
                                    <div class="headerEdit">Address</div>
                                    <div class="buttonEdit1"><input type="reset" class="button buttonBlack" value="Cancel" style="font-size: 20px;"></div>
                                </div>
                                <div class="col2">
                                    <div class="valueEdit"><input type="password" class="editCarBlank" name="CPass"></div>
                                    <div class="valueEdit"><input type="password" class="editCarBlank" name="Re-CPass"></div>
                                    <div class="valueEdit"><input type="text" class="editCarBlank" name="CFName"></div>
                                    <div class="valueEdit"><input type="text" class="editCarBlank" name="CPhone"></div>
                                    <div class="valueEdit"><input type="text" class="editCarBlank" name="CAddress"></div>
                                    <div class="buttonEdit2"><input type="submit" class="button buttonBlack" value="Change" style="font-size: 20px;"></div>
                                </div>
                            </div>    

                            <input type="hidden" value="Customer_Edit_Profile" name="action">
                            <input type="hidden" value="<%=ID%>" name="CID">


                        </form>
                    </div>

                    <%
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

                    %>
                    <div class="formCar">
                        <div class="formCarL">
                            <div class="stars">
                                <%                                float x;
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
                                %>
                                <div style=" width: 20%; font-size: 0; height: 30px; display: inline-block;"><img src="background/star.png" height="30" width="30"></div>
                                    <%
                                        }
                                    } else {
                                    %><div style=" width: 20%; font-size: 0; height: 30px; display: inline-block;"></div><%
                                        }


                                %>
                            </div>
                            <div class="carImg">
                                <img src="<%=Img%>" class="imgCar">
                            </div>
                            <div style="font-size: 0; width: 100%; height: 30px;">
                                <div class="like">
                                    <form method="post" action="check" name="rentButton" onsubmit="return checkVote()">
                                        <input type="hidden" name="action" value="like">
                                        <input type="hidden" name="CarID" value="<%=CarID%>">
                                        <input type="hidden" name="type" value="<%=type%>">
                                        <input type="submit" value="Like" class="likeButton button buttonBlack">
                                    </form>
                                </div>
                                <div class="dislike">
                                    <form method="post" action="check" name="rentButton" onsubmit="return checkVote()">
                                        <input type="hidden" name="action" value="dislike">
                                        <input type="hidden" name="CarID" value="<%=CarID%>">
                                        <input type="hidden" name="type" value="<%=type%>">
                                        <input type="submit" value="Dislike" class="dislikeButton button buttonBlack">
                                    </form>
                                </div>
                            </div>

                        </div>
                        <div class="formCarR">
                            <div class="carInfo">
                                <pHeader><%=CarName%></pHeader>
                                <p>Type: <%=CarType%></p>
                                <p>Seats: <%=Seats%></p>
                                <p>Color: <%=Color%></p>
                                <p>Introduce: <%=Introduce%></p>
                            </div>
                            <div style="font-size: 0; width: 100%; height: 30px;">
                                <div class="carPrice">
                                    $<%=Price%>
                                </div>
                                <div class="carDiscount">
                                    Sale <%=Discount%>%
                                </div>
                                <div class="rentButton">
                                    <form method="post" action="check">
                                        <input type="hidden" name="action" value="cancelOrder">
                                        <input type="hidden" name="CarID" value="<%=CarID%>">
                                        <input type="submit" value="Cancel" class="rentButtonn button buttonBlack">
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <% }

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

                    %>
                    <div class="formCar">
                        <div class="formCarL">
                            <div class="stars">
                                <%                                float x;
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
                                %>
                                <div style=" width: 20%; font-size: 0; height: 30px; display: inline-block;"><img src="background/star.png" height="30" width="30"></div>
                                    <%
                                        }
                                    } else {
                                    %><div style=" width: 20%; font-size: 0; height: 30px; display: inline-block;"></div><%
                                        }


                                %>
                            </div>
                            <div class="carImg">
                                <img src="<%=Img%>" class="imgCar">
                            </div>
                            <div style="font-size: 0; width: 100%; height: 30px;">
                                <div class="like">
                                    <form method="post" action="check" name="rentButton" onsubmit="return checkVote()">
                                        <input type="hidden" name="action" value="like">
                                        <input type="hidden" name="CarID" value="<%=CarID%>">
                                        <input type="hidden" name="type" value="<%=type%>">
                                        <input type="submit" value="Like" class="likeButton button buttonBlack">
                                    </form>
                                </div>
                                <div class="dislike">
                                    <form method="post" action="check" name="rentButton" onsubmit="return checkVote()">
                                        <input type="hidden" name="action" value="dislike">
                                        <input type="hidden" name="CarID" value="<%=CarID%>">
                                        <input type="hidden" name="type" value="<%=type%>">
                                        <input type="submit" value="Dislike" class="dislikeButton button buttonBlack">
                                    </form>
                                </div>
                            </div>

                        </div>
                        <div class="formCarR">
                            <div class="carInfo">
                                <pHeader><%=CarName%></pHeader>
                                <p>Type: <%=CarType%></p>
                                <p>Seats: <%=Seats%></p>
                                <p>Color: <%=Color%></p>
                                <p>Introduce: <%=Introduce%></p>
                            </div>
                            <div style="font-size: 0; width: 100%; height: 30px;">
                                <div class="carPrice">
                                    $<%=Price%>
                                </div>
                                <div class="carDiscount">
                                    Sale <%=Discount%>%
                                </div>
                                <div class="rentButton">
                                    <form method="post" action="check" name="rentButton" onsubmit="return checkType()">
                                        <input type="hidden" name="action" value="rentCar">
                                        <input type="hidden" name="type" value="<%=type%>">
                                        <input type="hidden" name="ID" value="<%=ID%>">
                                        <input type="hidden" name="CarID" value="<%=CarID%>">
                                        <input type="submit" value="Rent" class="rentButtonn button buttonBlack">
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <% }
                        connection.close();
                    %>


                </div>
            </div>  
            <% }%>
        </div>

    </body>
</html>
