package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <script TYPE=\"text/javascript\">\n");
      out.write("            function checkInput() {\n");
      out.write("                var ID = document.forms[\"myForm\"][\"CName\"].value;\n");
      out.write("                var name = document.forms[\"myForm\"][\"CFName\"].value;\n");
      out.write("                var pass = document.forms[\"myForm\"][\"CPass\"].value;\n");
      out.write("                var repass = document.forms[\"myForm\"][\"Re-CPass\"].value;\n");
      out.write("                var address = document.forms[\"myForm\"][\"CAddress\"].value;\n");
      out.write("                var phone = document.forms[\"myForm\"][\"CPhone\"].value;\n");
      out.write("                var cinumber = document.forms[\"myForm\"][\"CINumber\"].value;\n");
      out.write("                if (checkID(ID) == 0 || checkPassword(pass, repass) == 0 || checkName(name) == 0 || checkPhone(phone) == 0 || checkAddress(address) == 0 || checkIN(cinumber) == 0) {\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkID(ID) {\n");
      out.write("                if (ID == \"\") {\n");
      out.write("                    alert(\"ID not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (ID.length > 20) {\n");
      out.write("                    alert(\"ID must less than 20 characters\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkName(name) {\n");
      out.write("                if (name == \"\") {\n");
      out.write("                    alert(\"Full Name not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (name.length > 20) {\n");
      out.write("                    alert(\"Full Name must less than 20 characters\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkPassword(pass, repass) {\n");
      out.write("                if (pass == \"\" || repass == \"\") {\n");
      out.write("                    alert(\"Password and re-Password not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (pass != repass) {\n");
      out.write("                    alert(\"Password not equals to Re-Password\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (pass.length > 20 || pass.length < 6) {\n");
      out.write("                    alert(\"Password must less than 20 characters and greater than 6 characters\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkPhone(phone) {\n");
      out.write("                if (phone == \"\") {\n");
      out.write("                    alert(\"Phone Number not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (phone.length > 11 || phone.length < 10) {\n");
      out.write("                    alert(\"Phone number have 10 or 11 numbers\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkAddress(address) {\n");
      out.write("                if (address == \"\") {\n");
      out.write("                    alert(\"Address Number not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (address.length > 50) {\n");
      out.write("                    alert(\"Address have a lot of characters\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkIN(IN) {\n");
      out.write("                if (IN == \"\") {\n");
      out.write("                    alert(\"Identity Number not null\");\n");
      out.write("                    return 0;\n");
      out.write("                } else if (IN.length != 9) {\n");
      out.write("                    alert(\"Identity number have 9 numbers\");\n");
      out.write("                    return 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function validate() {\n");
      out.write("                var password1 = document.getElementById(\"pass\");\n");
      out.write("                var password2 = document.getElementById(\"repass\");\n");
      out.write("                var msg = document.getElementById(\"message\");\n");
      out.write("\n");
      out.write("                if (password1.value == password2.value) {\n");
      out.write("                    password2.style.backgroundColor = greenColor;\n");
      out.write("                    msg.style.color = greenColor;\n");
      out.write("                    msg.innerHTML = \"Password is Matched!\";\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    password2.style.backgroundColor = redColor;\n");
      out.write("                    msg.style.color = redColor;\n");
      out.write("                    msg.innerHTML = \"Password do not match! Please try again.\";\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String check = (String) session.getAttribute("checkAccount");
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"formRegister\">\n");
      out.write("            <div class=\"editHeader\">Register Form</div>\n");
      out.write("            <form method=\"post\" action=\"check\" name=\"myForm\" onsubmit=\"return checkInput();\">\n");
      out.write("                <div class=\"rowEdit removeSpace\">\n");
      out.write("                    <div class=\"col1Register\">\n");
      out.write("                        <div class=\"headerEdit\">ID</div>\n");
      out.write("                        <div class=\"headerEdit\">Password</div>\n");
      out.write("                        <div class=\"headerEdit\">re-Password</div>\n");
      out.write("                        <div class=\"headerEdit\">Full Name</div>\n");
      out.write("                        <div class=\"headerEdit\">Phone</div>\n");
      out.write("                        <div class=\"headerEdit\">Address</div>\n");
      out.write("                        <div class=\"headerEdit\">Identity Number</div>\n");
      out.write("\n");
      out.write("                        ");
if (check == null) {
                            } else if (check.equals("exist")) {
                                out.print("<div class='sameAccount'>Account or IN already exist</div>");
                            }
                            session.setAttribute("checkAccount", "");
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col2Register\">\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"CName\"></div>\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"password\" id=\"pass\" class=\"editCarBlank\" name=\"CPass\"></div>\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"password\" id=\"repass\" class=\"editCarBlank\" name=\"Re-CPass\"></div>\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"CFName\"></div>\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" name=\"CPhone\"></div>\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"text\" class=\"editCarBlank\" name=\"CAddress\"></div>\n");
      out.write("                        <div class=\"valueEdit\"><input type=\"number\" class=\"editCarBlank\" name=\"CINumber\"></div>\n");
      out.write("                        <input type=\"hidden\" value=\"Register\" name=\"action\">\n");
      out.write("                        <div class=\"buttonEdit2\"><input type=\"submit\" class=\"button buttonBlack\" value=\"Register\" style=\"font-size: 20px;\"></div>\n");
      out.write("                        <a href=\"homePage.jsp\"><div class=\"buttonEdit2\"><input type=\"button\" class=\"button buttonBlack\" value=\"Cancel\" style=\"font-size: 20px;\"></div></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>     \n");
      out.write("            </form>\n");
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
