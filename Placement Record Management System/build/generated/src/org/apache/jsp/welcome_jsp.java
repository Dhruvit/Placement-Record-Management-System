package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import foo.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Welcome | Placement Record Management System</title>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction giveMesg()\r\n");
      out.write("                        {   \r\n");
      out.write("                            loginForm.userid.value = null;\r\n");
      out.write("                            loginForm.userid.password = null;\r\n");
      out.write("                            alert(\"User not have account..Please create acoount\");\r\n");
      out.write("                            return true;\r\n");
      out.write("                        }\r\n");
      out.write("           \r\n");
      out.write("\t\t\tfunction checkForm(loginForm)\r\n");
      out.write("  \t\t\t{\t\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t\tif(loginForm.userid.value == \"\") {\r\n");
      out.write("      \t\t\t\talert(\"Please enter UserID\");\r\n");
      out.write("      \t\t\t\tloginForm.userid.focus();\r\n");
      out.write("      \t\t\t\treturn false;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tif(loginForm.password.value == \"\") {\r\n");
      out.write("      \t\t\t\talert(\"Please enter Password\");\r\n");
      out.write("      \t\t\t\tloginForm.password.focus();\r\n");
      out.write("      \t\t\t\treturn false;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("                        \r\n");
      out.write("                                if(loginForm.type.value == null) {\r\n");
      out.write("      \t\t\t\talert(\"Please select type\");\r\n");
      out.write("      \t\t\t\tloginForm.password.focus();\r\n");
      out.write("      \t\t\t\treturn false;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("    \t\t\tif(loginForm.userid.value != \"\" ) {\r\n");
      out.write("      \t\t\t\r\n");
      out.write("\t\t\t\t\tif(loginForm.userid.value.length > 6 || loginForm.userid.value.length < 6) {\r\n");
      out.write("        \t\t\t\talert(\"Only allow six digit UserID\");\r\n");
      out.write("        \t\t\t\tloginForm.userid.value = null;\r\n");
      out.write("\t\t\t\t\t\tloginForm.userid.focus();\r\n");
      out.write("        \t\t\t\treturn false;\r\n");
      out.write("      \t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tre = /^[0-9]{6,7}$/;\r\n");
      out.write("\t\t\t\t\tif(!re.test(loginForm.userid.value) )\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"Only allow numeric UserID \");\r\n");
      out.write("\t\t\t\t\t\tloginForm.userid.value = null; \r\n");
      out.write("      \t\t\t\t\tloginForm.userid.focus();\r\n");
      out.write("      \t\t\t\t\treturn false;\r\n");
      out.write("    \t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tif(loginForm.password.value != \"\" && loginForm.password.value == loginForm.password.value) {\r\n");
      out.write("      \t\t\t\tif(loginForm.password.value.length <= 4) {\r\n");
      out.write("        \t\t\t\talert(\"Password must contain at least four characters!\");\r\n");
      out.write("        \t\t\t\tloginForm.password.value = null;\r\n");
      out.write("\t\t\t\t\t\tloginForm.password.focus();\r\n");
      out.write("        \t\t\t\treturn false;\r\n");
      out.write("      \t\t\t\t}\r\n");
      out.write("     \t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(loginForm.password.value == loginForm.id.value) {\r\n");
      out.write("        \t\t\t\talert(\"Password must be different from Username!\");\r\n");
      out.write("        \t\t\t\tloginForm.password.value = null;\r\n");
      out.write("\t\t\t\t\t\tloginForm.userid.value = null;\r\n");
      out.write("\t\t\t\t\t\tloginForm.userid.focus();\r\n");
      out.write("        \t\t\t\treturn false;\r\n");
      out.write("      \t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("      \t\t\treturn true;\r\n");
      out.write("  \t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("    <!--\r\n");
      out.write("    .style1 {\r\n");
      out.write("            font-family: \"Times New Roman\", Times, serif;\r\n");
      out.write("            font-size: 36px;\r\n");
      out.write("            color: #FF3300;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("    -->\r\n");
      out.write("    </style>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("            \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "welcomeHeader.html", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
  String url = "jdbc:mysql://localhost/prms";
        String user_id = "root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        
        ResultSet rs = null;
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String user_type = request.getParameter("user_type");
        
       // System.out.println("type :::"+type);
        String redirectURL = "http://localhost:8080/DDU_Placement_Cell/welcomeStudent.jsp";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
        
            try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                
                      
                   
                     //check is user haven't account then give message to create account
                
                    rs = stmt.executeQuery("select * from Login_Table ");
                
                    String user_id1 = null;
                    String user_pass1 = null;
                    String user_type1 = null;
                    while(rs.next())
                    {
                        user_id1 = rs.getString("userid");
                        user_pass1 = rs.getString("password");
                        user_type1 = rs.getString("user_type");
                        if((user_id1.equals(userid)) && (user_pass1.equals(password)) && (user_type1.equals(user_type)))
                        {
                            if(user_type.equals("Student"))
                            {
                              
      out.write("\r\n");
      out.write("                              ");
      foo.Student student = null;
      synchronized (request) {
        student = (foo.Student) _jspx_page_context.getAttribute("student", PageContext.REQUEST_SCOPE);
        if (student == null){
          student = new foo.Student();
          _jspx_page_context.setAttribute("student", student, PageContext.REQUEST_SCOPE);
          out.write("\r\n");
          out.write("                                 ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("student"), "userid", request.getParameter("userid"), request, "userid", false);
          out.write("\r\n");
          out.write("                              ");
        }
      }
      out.write("\r\n");
      out.write("                             ");
      if (true) {
        _jspx_page_context.forward("session_student");
        return;
      }
      out.write("\r\n");
      out.write("                               ");

                            }
                            else if(user_type.equals("TPO"))
                            {
                            
      out.write("\r\n");
      out.write("                             ");
      foo.TPO tpo = null;
      synchronized (request) {
        tpo = (foo.TPO) _jspx_page_context.getAttribute("tpo", PageContext.REQUEST_SCOPE);
        if (tpo == null){
          tpo = new foo.TPO();
          _jspx_page_context.setAttribute("tpo", tpo, PageContext.REQUEST_SCOPE);
          out.write("\r\n");
          out.write("                                 ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("tpo"), "userid", request.getParameter("userid"), request, "userid", false);
          out.write("\r\n");
          out.write("                             ");
        }
      }
      out.write("\r\n");
      out.write("                             ");
      if (true) {
        _jspx_page_context.forward("session_tpo");
        return;
      }
      out.write("\r\n");
      out.write("                               ");

                            }
                            else if(user_type.equals("Approver"))
                            {
                            
      out.write("\r\n");
      out.write("                             ");
      foo.Approver approver = null;
      synchronized (request) {
        approver = (foo.Approver) _jspx_page_context.getAttribute("approver", PageContext.REQUEST_SCOPE);
        if (approver == null){
          approver = new foo.Approver();
          _jspx_page_context.setAttribute("approver", approver, PageContext.REQUEST_SCOPE);
          out.write("\r\n");
          out.write("                                 ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("approver"), "userid", request.getParameter("userid"), request, "userid", false);
          out.write("\r\n");
          out.write("                             ");
        }
      }
      out.write("\r\n");
      out.write("                             ");
      if (true) {
        _jspx_page_context.forward("session_approver");
        return;
      }
      out.write("\r\n");
      out.write("                               ");

                            }
                                    
                        }
                        if((rs.isLast()) && (userid != null) && (password != null))
                        {
                          out.println("<html><body>");
                          out.println(" <script type = " + " text/javascript " + " > ");
                          out.println("window.onload = giveMesg");
                          out.println("</script></body></html>");  
                        }
                    }
                  
                 
                stmt.close();
                con.close();
            }catch(SQLException e){}
        
        
      out.write("\r\n");
      out.write("            <table width=\"1112\" height=\"500\" align=\"center\" border=\"4\" bgcolor=\"#CCFFFF\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("            <tr>\r\n");
      out.write("            <td height=\"135\" align=\"center\">\r\n");
      out.write("            <form action=\"welcome.jsp\" method=\"post\" name=\"loginForm\"  onSubmit=\"return checkForm(this);\">\r\n");
      out.write("              <table width=\"300\" height=\"84\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <p align=\"center\"><strong><font size=\"5\">User Login</font></strong></p>\r\n");
      out.write("                </tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><p>Type:</p></td>\r\n");
      out.write("                  \t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"user_type\" required x-moz-errormessage=\"Select User Type\" >\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\" \" >--Select One--</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Student\">Student</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"TPO\">TPO</option>\r\n");
      out.write("                                                        <option value=\"Approver\">Approver</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><p>UserID:</p></td>\r\n");
      out.write("                  <td><input type=\"text\" name=\"userid\" align=\"right\" required pattern=\"[0-9]+\"/></td>\r\n");
      out.write("                  \r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><p>Password:</p></td>\r\n");
      out.write("                  <td><input type=\"password\" name=\"password\"  align=\"right\" required pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}\"/></td>\r\n");
      out.write("                  \r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><input name=\"submit\" type=\"submit\" value=\"Login\"  onClick=\"return validateForm(this);\"/></td>\r\n");
      out.write("                  <td><a href=\"createAccount.jsp\" >Create Acoount</a></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("            </form>\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
