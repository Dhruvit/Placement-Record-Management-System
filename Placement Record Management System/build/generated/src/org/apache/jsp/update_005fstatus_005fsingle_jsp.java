package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class update_005fstatus_005fsingle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table width=\"1112\" height=\"307\" align=\"center\"  border=\"4\" bgcolor=\"#CCFFFF\">\r\n");
      out.write("\t\t\t<tr >\r\n");
      out.write("\t\t\t\t<td height=\"38\" colspan=\"3\">Welcome \r\n");
      out.write("\t\t\t\t&quot;Write Name of Student&quot; </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"211\" height=\"307\" rowspan=\"3\"></td>\r\n");
      out.write("\t\t\t\t<td width=\"657\" rowspan=\"3\"  bgcolor=\"#9999FF\">\r\n");
      out.write("\t\t\t\t<form action=\"tpo_update\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<table width=\"657\" height=\"169\" bgcolor=\"lemonchiffon\">\r\n");
      out.write("\t\t\t\t\t\t<thead BGCOLOR=\"lightskyblue\">\r\n");
      out.write("\t\t  \t\t  \t  <tbody BGCOLOR=\"lemonchiffon\">\r\n");
      out.write("\t\t\t\t\t  \t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td height=\"33\"><div align=\"center\">Enter StudentId</div></td><td><input type=\"text\" name=\"userid\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t  <td width=\"97\" height=\"31\"><div align=\"center\">Activity</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t  <td width=\"498\">\r\n");
      out.write("\t\t\t\t\t\t\t  \t<input name=\"activity\" type=\"text\" size=\"50\" />\t\t\t\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t  \t<td height=\"32\"><div align=\"center\">Status</div></td><td><input name=\"status\" type=\"text\" size=\"50\" /></td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t  <td height=\"30\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t  <td><input type=\"submit\" value=\"Update\" /><input type=\"reset\" value=\"Reset\" /></td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t  </tbody>\r\n");
      out.write("\t\t\t\t\t\t<tfoot BGCOLOR=\"lightskyblue\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tPRMS Status Update Application </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</tfoot>\r\n");
      out.write("\t\t\t\t  </table>\r\n");
      out.write("\t\t\t\t  </form>\t\t\t  </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td height=\"31\" align=\"center\"><button onClick=\"windows.location.href='student_record.jsp'\">Choose Multiple</button></td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td height=\"188\">&nbsp;</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"31\" colspan=\"3\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t</table>        \r\n");
      out.write("    \r\n");
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
