<%-- 
    Document   : Login
    Created on : Dec 7, 2016, 9:18:52 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body{
                margin: 0;
                padding: 0;
                background: #fff;

                color: #fff;
                font-family: Arial;
                font-size: 12px;
            }

            .body{
                position: absolute;
                top: -20px;
                left: -20px;
                right: -40px;
                bottom: -40px;
                width: auto;
                height: auto;
                background-image: url(background/car4.jpg);
                background-size: cover;
                -webkit-filter: blur(5px);
                z-index: 0;
            }

            .grad{
                position: absolute;
                top: -20px;
                left: -20px;
                right: -40px;
                bottom: -40px;
                width: auto;
                height: auto;
                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));
                z-index: 1;
                opacity: 0.7;
            }

            .header{
                position: absolute;
                top: calc(50% - 35px);
                left: calc(50% - 255px);
                z-index: 2;
            }

            .header div{
                float: left;
                color: #fff;
                font-family: 'Exo', sans-serif;
                font-size: 35px;
                font-weight: 200;
            }

            .header div span{
                color: #5379fa !important;
            }

            .login{
                position: absolute;
                top: calc(50% - 75px);
                left: calc(50% - 50px);
                height: 150px;
                width: 350px;
                padding: 10px;
                z-index: 2;
            }

            .login input[type=text]{
                width: 250px;
                height: 30px;
                background: transparent;
                border: 1px solid rgba(255,255,255,0.6);
                border-radius: 2px;
                color: #fff;
                font-family: 'Exo', sans-serif;
                font-size: 16px;
                font-weight: 400;
                padding: 4px;
            }

            .login input[type=password]{
                width: 250px;
                height: 30px;
                background: transparent;
                border: 1px solid rgba(255,255,255,0.6);
                border-radius: 2px;
                color: #fff;
                font-family: 'Exo', sans-serif;
                font-size: 16px;
                font-weight: 400;
                padding: 4px;
                margin-top: 10px;
            }

            .login input[type=submit]{
                width: 120px;
                height: 35px;
                background: #fff;
                border: 1px solid #fff;
                cursor: pointer;
                border-radius: 2px;
                color: #a18d6c;
                font-family: 'Exo', sans-serif;
                font-size: 16px;
                font-weight: 400;
                padding: 6px;
                margin-top: 10px;
                display: inline-block;
                vertical-align: middle;
            }

            .login input[type=submit]:hover{
                opacity: 0.8;
            }

            .login input[type=submit]:active{
                opacity: 0.6;
            }
            .xxx{

                background: #fff;
                border: 1px solid #fff;
                cursor: pointer;
                border-radius: 2px;
                color: #a18d6c;
                font-family: 'Exo', sans-serif;
                font-size: 16px;
                font-weight: 400;
                padding: 8px;
                margin-top: 10px;
                display: inline-block;
                vertical-align: middle;
                width: 100px;
                text-align: center;
                margin-left: 20px;
            }

            .xxx:hover{
                opacity: 0.8;
            }

            .xxx:active{
                opacity: 0.6;
            }
            .xxx:focus{
                outline: none;
            }

            .login input[type=text]:focus{
                outline: none;
                border: 1px solid rgba(255,255,255,0.9);
            }

            .login input[type=password]:focus{
                outline: none;
                border: 1px solid rgba(255,255,255,0.9);
            }

            .login input[type=submit]:focus{
                outline: none;
            }

            ::-webkit-input-placeholder{
                color: rgba(255,255,255,0.6);
            }

            ::-moz-input-placeholder{
                color: rgba(255,255,255,0.6);
            }
        </style>

        <script TYPE="text/javascript">
            function checkInput() {
                var ID = document.forms["myForm"]["username"].value;
                var pass = document.forms["myForm"]["password"].value;
                if (checkID(ID) == 0 || checkPass(pass) == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            function checkID(ID) {
                if (ID == "") {
                    alert("UserName not null");
                    return 0;
                }
            }
            function checkPass(pass) {
                if (pass == "") {
                    alert("Password not null");
                    return 0;
                }
            }
        </script>
    </head>
    <body>
        <jsp:useBean id="account" scope="session" class="storeAccount.Account" />

        <%
            if (account != null) {
                session.removeAttribute("account");
            }
        %>
        <%
            String check = (String) session.getAttribute("checkAccount");
        %>
        <div class="body" ></div>
        <div class="grad"></div>
        <div class="header">
            <div>Car<span>Rental</span></div>
        </div>
        <br>
        <form method="post" action="check" name="myForm" onsubmit="return checkInput()">
            <div class="login">
                <input type="text" placeholder="Username" name="username"><br>
                <input type="password" placeholder="Password" name="password"><br>
                <%  if (check == null || check.equals("")) {

                    } else if (check.equals("wrongUsername")) {
                        out.print("<input type='text' readonly value='Username not exist, Register for login' style='margin-top:5px; color: white; border: none;'><br>");
                    } else if (check.equals("wrongPass")) {
                        out.print("<input type='text' readonly value='Password incorrect!' style='margin-top:5px; color: white; border: none;'><br>");
                    }
                    session.setAttribute("checkAccount", "");
                %>
                <input type="hidden" value="login" name="action">
                <input type="submit" value="Login">
                <a href="Register.jsp"><div class="xxx">Register</div></a>
            </div>
        </form>
    </body>
</html>
