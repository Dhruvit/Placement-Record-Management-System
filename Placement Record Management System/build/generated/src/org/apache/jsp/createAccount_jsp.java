package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class createAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Create Account | Placement Record Management System</title>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            \r\n");
      out.write("            window.history.forward(0);\r\n");
      out.write("            function giveMesg()\r\n");
      out.write("            {   \r\n");
      out.write("                            createAccountFor.userid.value = null;\r\n");
      out.write("                            //createAccountFor.userid.password = null;\r\n");
      out.write("                            alert(\"User already have account\");\r\n");
      out.write("                            return true;\r\n");
      out.write("            }\r\n");
      out.write("            function noBack() \r\n");
      out.write("            {\r\n");
      out.write("                window.history.forward(0);\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*function validateForm(createAccountForm)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(createAccountForm.name.value == \"\") {\r\n");
      out.write("\t\t\t\t\t//document.getElementById(\"errorName\").innerHTML=\"Fill FirstName\";\r\n");
      out.write("      \t\t\t\talert(\"Please enter UserID\");\r\n");
      out.write("      \t\t\t\tloginForm.name.focus();\r\n");
      out.write("      \t\t\t\treturn false;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("\t\t\t}*/\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\t\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("\t\t<!--\r\n");
      out.write("\t\t.style1 {\r\n");
      out.write("\t\t\tfont-family: \"Courier New\", Courier, monospace;\r\n");
      out.write("\t\t\tfont-size: 24px;\r\n");
      out.write("\t\t\tcolor: #FF3300;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.style2 {color: #990000}\r\n");
      out.write("\t\t.style4 {color: #CC0000}\r\n");
      out.write("\t\t-->\r\n");
      out.write("        </style>\r\n");
      out.write("</head>\r\n");
      out.write("    \r\n");
      out.write("<body onLoad=\"noBack();\" onpageshow=\"if (event.persisted) noBack();\" onUnload=\"\">\r\n");
      out.write("            \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "welcomeHeader.html", out, false);
      out.write("\r\n");
      out.write("    ");
  String url = "jdbc:mysql://localhost/prms";
        String user_id = "root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        
        ResultSet rs = null;
        String userid = request.getParameter("userid");
        
        String redirectURL = "http://localhost:8080/DDU_Placement_Cell/welcomeStudent.jsp";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
        
            try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                
                      
               
                //check is user already have account then give message
                
                rs = stmt.executeQuery("select * from Login_Table ");
                
                String user_id1 = null;
                
                while(rs.next())
                {
                    user_id1 = rs.getString("userid");
                    
                    if(user_id1.equals(userid))
                    {
                        
                        out.println("<html><body>");
                        out.println(" <script type = " + " text/javascript " + " > ");
                        //out.println("window.onload = giveMesg");
                        out.println("alert('User alredy have account')");
                        out.println("</script></body></html>"); 
                        //response.sendRedirect("http://localhost:8080/DDU_Placement_Cell/welcomeStudent.jsp");
                        break;
                    }
                    if((rs.isLast()) && (userid != null))
                    {   
                        
      out.write("\r\n");
      out.write("                        ");
      if (true) {
        _jspx_page_context.forward("loginTable");
        return;
      }
      out.write("\r\n");
      out.write("                        ");

                      
                    }
                }
                stmt.close();
                con.close();
            }catch(SQLException e){}
        
        
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <table width=\"1112\" height=\"500\" align=\"center\" border=\"4\" bgcolor=\"#CCCCFF\" >\r\n");
      out.write("    \t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"1112\" align=\"center\">\r\n");
      out.write("\t\t\t\t<p align=\"center\" class=\"style6 style5 style1 style2\"><strong>Create Account</strong></p> \r\n");
      out.write("\t\t\t\t<form name=\"createAccountForm\" method=\"post\" action=\"createAccount.jsp\" id=\"myForm\" onSubmit=\"return validateForm(this);\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write(" \t\t \r\n");
      out.write("  \t\t\t\t\t<tr>\r\n");
      out.write("  \t\t\t\t\t  <td width=\"156\" height=\"147\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("   \t\t\t\t\t\t\t<table width=\"93%\" border=\"0\" >\r\n");
      out.write("   \t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td width=\"20%\">Name</td>\r\n");
      out.write("\t  \t  \t  \t\t\t\t  \t  \t<td width=\"80%\"><input name=\"name\" type=\"text\"  id=\"name\" size=\"40\" ></td>\r\n");
      out.write("\t\t  \t\t\t\t  \t  \t</tr>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t   \t\t\t\t\t<tr>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td>UserID</td>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td><input name=\"userid\" type=\"text\" size=\"40\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr> \r\n");
      out.write("  \t \r\n");
      out.write("  \t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td>Password</td>\r\n");
      out.write("        \t\t\t\t\t\t\t<td><input name=\"password\" type=\"password\" size=\"40\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr> \r\n");
      out.write("   \r\n");
      out.write(" \r\n");
      out.write("  \t\t\t \t\t\t\t\t<tr>\r\n");
      out.write("  \t\t\t \t\t\t\t\t  <td height=\"24\">Branch</td>\r\n");
      out.write("  \t\t\t \t\t\t\t\t  <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <select name=\"branch\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\" \" >  </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ce\">CE</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ec\">EC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"it\">IT</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ic\">IC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ch\">CH</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"mc\">MC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"cl\">CL</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t        </select>\t\t\t\t\t\t\t\t  </td>\r\n");
      out.write("\t\t \t\t\t\t\t  </tr>\r\n");
      out.write("  \t\t\t \t\t\t\t\t<tr>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td height=\"24\">User Type </td>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"user_type\" >\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t  \t<option value=\"na\"></option>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t  \t<option value=\"Student\">Student</option>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t  \t<option value=\"TPO\">TPO</option>\r\n");
      out.write("\t\t\t\t\t\t\t          </select>\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t  </table>\t\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t  <td></td>\r\n");
      out.write("\t\t\t\t\t  <td width=\"108\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t    <td width=\"505\"><table align=\"left\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td align=\"center\"><input name=\"submit\" type=\"submit\" value=\"Submit\">\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td  align=\"left\"><input name=\"reset\" type=\"reset\"  value=\"Clear\"></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </table></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\t\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("    </table>\t  \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
