package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background: #fff;\n");
      out.write("\n");
      out.write("                color: #fff;\n");
      out.write("                font-family: Arial;\n");
      out.write("                font-size: 12px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .body{\n");
      out.write("                position: absolute;\n");
      out.write("                top: -20px;\n");
      out.write("                left: -20px;\n");
      out.write("                right: -40px;\n");
      out.write("                bottom: -40px;\n");
      out.write("                width: auto;\n");
      out.write("                height: auto;\n");
      out.write("                background-image: url(background/car4.jpg);\n");
      out.write("                background-size: cover;\n");
      out.write("                -webkit-filter: blur(5px);\n");
      out.write("                z-index: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .grad{\n");
      out.write("                position: absolute;\n");
      out.write("                top: -20px;\n");
      out.write("                left: -20px;\n");
      out.write("                right: -40px;\n");
      out.write("                bottom: -40px;\n");
      out.write("                width: auto;\n");
      out.write("                height: auto;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));\n");
      out.write("                z-index: 1;\n");
      out.write("                opacity: 0.7;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header{\n");
      out.write("                position: absolute;\n");
      out.write("                top: calc(50% - 35px);\n");
      out.write("                left: calc(50% - 255px);\n");
      out.write("                z-index: 2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header div{\n");
      out.write("                float: left;\n");
      out.write("                color: #fff;\n");
      out.write("                font-family: 'Exo', sans-serif;\n");
      out.write("                font-size: 35px;\n");
      out.write("                font-weight: 200;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header div span{\n");
      out.write("                color: #5379fa !important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login{\n");
      out.write("                position: absolute;\n");
      out.write("                top: calc(50% - 75px);\n");
      out.write("                left: calc(50% - 50px);\n");
      out.write("                height: 150px;\n");
      out.write("                width: 350px;\n");
      out.write("                padding: 10px;\n");
      out.write("                z-index: 2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=text]{\n");
      out.write("                width: 250px;\n");
      out.write("                height: 30px;\n");
      out.write("                background: transparent;\n");
      out.write("                border: 1px solid rgba(255,255,255,0.6);\n");
      out.write("                border-radius: 2px;\n");
      out.write("                color: #fff;\n");
      out.write("                font-family: 'Exo', sans-serif;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                padding: 4px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=password]{\n");
      out.write("                width: 250px;\n");
      out.write("                height: 30px;\n");
      out.write("                background: transparent;\n");
      out.write("                border: 1px solid rgba(255,255,255,0.6);\n");
      out.write("                border-radius: 2px;\n");
      out.write("                color: #fff;\n");
      out.write("                font-family: 'Exo', sans-serif;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                padding: 4px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=submit]{\n");
      out.write("                width: 120px;\n");
      out.write("                height: 35px;\n");
      out.write("                background: #fff;\n");
      out.write("                border: 1px solid #fff;\n");
      out.write("                cursor: pointer;\n");
      out.write("                border-radius: 2px;\n");
      out.write("                color: #a18d6c;\n");
      out.write("                font-family: 'Exo', sans-serif;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                padding: 6px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                display: inline-block;\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=submit]:hover{\n");
      out.write("                opacity: 0.8;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=submit]:active{\n");
      out.write("                opacity: 0.6;\n");
      out.write("            }\n");
      out.write("            .xxx{\n");
      out.write("\n");
      out.write("                background: #fff;\n");
      out.write("                border: 1px solid #fff;\n");
      out.write("                cursor: pointer;\n");
      out.write("                border-radius: 2px;\n");
      out.write("                color: #a18d6c;\n");
      out.write("                font-family: 'Exo', sans-serif;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                padding: 8px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                display: inline-block;\n");
      out.write("                vertical-align: middle;\n");
      out.write("                width: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("                margin-left: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .xxx:hover{\n");
      out.write("                opacity: 0.8;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .xxx:active{\n");
      out.write("                opacity: 0.6;\n");
      out.write("            }\n");
      out.write("            .xxx:focus{\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=text]:focus{\n");
      out.write("                outline: none;\n");
      out.write("                border: 1px solid rgba(255,255,255,0.9);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=password]:focus{\n");
      out.write("                outline: none;\n");
      out.write("                border: 1px solid rgba(255,255,255,0.9);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login input[type=submit]:focus{\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ::-webkit-input-placeholder{\n");
      out.write("                color: rgba(255,255,255,0.6);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ::-moz-input-placeholder{\n");
      out.write("                color: rgba(255,255,255,0.6);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <script TYPE=\"text/javascript\">\n");
      out.write("            function checkInput() {\n");
      out.write("                var ID = document.forms[\"myForm\"][\"username\"].value;\n");
      out.write("                var pass = document.forms[\"myForm\"][\"password\"].value;\n");
      out.write("                if (checkID(ID) == 0 || checkPass(pass) == 0) {\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkID(ID) {\n");
      out.write("                if (ID == \"\") {\n");
      out.write("                    alert(\"UserName not null\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkPass(pass) {\n");
      out.write("                if (pass == \"\") {\n");
      out.write("                    alert(\"Password not null\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("\n");
      out.write("        ");

            if (account != null) {
                session.removeAttribute("account");
            }
        
      out.write("\n");
      out.write("        ");

            String check = (String) session.getAttribute("checkAccount");
        
      out.write("\n");
      out.write("\n");
      out.write("        <!--<div style=\"text-align: center; width: 300px; margin: auto;\">\n");
      out.write("            <div>Login page</div>\n");
      out.write("            <form method=\"post\" action=\"check\" name=\"myForm\" onsubmit=\"return checkInput()\">\n");
      out.write("                <table>\n");
      out.write("                    <tr><td>UserName<td><input type=\"text\" name=\"username\" value=\"lythanhhuy\">\n");
      out.write("                    <tr><td>PassWord<td><input type=\"password\" name=\"password\" value=\"123456\">\n");
      out.write("        ");
 /* if (check == null || check.equals("")) {

            } else if (check.equals("wrongUsername")) {
                out.print("<tr><td>Username not exist, Register for login<td>");
            } else if (check.equals("wrongPass")) {
                out.print("<tr><td>Password incorrect!<td>");
            }
            session.setAttribute("checkAccount", "");*/
        
      out.write("\n");
      out.write("<tr><td><input type=\"hidden\" value=\"login\" name=\"action\"><td><input type=\"submit\" class=\"button buttonBlack\" value=\"Login\">\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("        <div class=\"body\" ></div>\n");
      out.write("        <div class=\"grad\"></div>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div>Car<span>Rental</span></div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <form method=\"post\" action=\"check\" name=\"myForm\" onsubmit=\"return checkInput()\">\n");
      out.write("            <div class=\"login\">\n");
      out.write("                <input type=\"text\" placeholder=\"Username\" name=\"username\"><br>\n");
      out.write("                <input type=\"password\" placeholder=\"Password\" name=\"password\"><br>\n");
      out.write("                ");
  if (check == null || check.equals("")) {

                    } else if (check.equals("wrongUsername")) {
                        out.print("<input type='text' readonly value='Username not exist, Register for login' style='margin-top:5px; color: white; border: none;'><br>");
                    } else if (check.equals("wrongPass")) {
                        out.print("<input type='text' readonly value='Password incorrect!' style='margin-top:5px; color: white; border: none;'><br>");
                    }
                    session.setAttribute("checkAccount", "");
                
      out.write("\n");
      out.write("                <input type=\"hidden\" value=\"login\" name=\"action\">\n");
      out.write("                <input type=\"submit\" value=\"Login\">\n");
      out.write("                <a href=\"Register.jsp\"><div class=\"xxx\">Register</div></a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
