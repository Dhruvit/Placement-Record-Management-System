package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fplacement_005fstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headerAdmin.html", out, false);
      out.write("\r\n");
      out.write("    <table width=\"1112\" height=\"451\" align=\"center\"  border=\"4\" bgcolor=\"#CCFFFF\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td  height=\"43\" colspan=\"3\"><div align=\"center\"><span class=\"style1\">Add Student Who are Placed in company </span></div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    \r\n");
      out.write("    <tr>\r\n");
      out.write("     <td width=\"371\">&nbsp;</td>\r\n");
      out.write("      <td width=\"369\">\r\n");
      out.write("\t\t<form method=\"post\" action=\"blackListRecordAdd\">\r\n");
      out.write("\t\t\t<table width=\"345\" height=\"170\" align=\"center\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"49%\" height=\"24\" >Company Name </td>\r\n");
      out.write("\t  \t  \t  \t\t<td colspan=\"2\" title=\"UserID\">\r\n");
      out.write("\t\t\t\t\t\t<select name=\"compant_name\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\" \" >Select Company</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"TCS\">TCS</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Infibeam\">Infibeam</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"NeoDigital\">NeoDigital</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Zeus\">Zeus</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Cybage\">Cybage</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Meditab\">Meditab</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Infostratch\">Infostratch</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Matrix\">Matrix</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Cybridge\">Cybridge</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Tatvic\">Tatvic</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Maruti Technology\">Maruti Technology</option>\r\n");
      out.write("\t\t\t          </select>\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("  \t  \t  \t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"24\">Branch</td>\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t\t\t\t\t<td width=\"51%\"><select name=\"branch\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\" \" >  </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ce\">CE</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ec\">EC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"it\">IT</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ic\">IC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"ch\">CH</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"mc\">MC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"cl\">CL</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t        </select>\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t  <td height=\"26\">Subject</td>\r\n");
      out.write("\t\t\t\t  <td colspan=\"2\">\r\n");
      out.write("\t\t\t\t  \t<select name=\"subject\" required  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${studentdatarecord[15]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" id=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\" \" >Select Subject</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Java/J2EE\">Java/J2EE</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\".Net\">.Net</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Perl\">Perl</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"C++\">C++</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Embedded\">Embedded</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Wireless\">Wireless</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"VlSI\">VlSI</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Power\">Power</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Structure\">Structure</option>\r\n");
      out.write("\t\t\t        </select>\r\n");
      out.write("\t\t\t\t  </td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t  <td height=\"26\">Year</td>\r\n");
      out.write("\t\t\t\t  <td colspan=\"2\">\r\n");
      out.write("\t\t\t\t  \t<select name=\"year\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"na\">Year</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1980\" selected=\"selected\">1980</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1981\">1981</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1982\">1982</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1983\">1983</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1984\">1984</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1985\">1985</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1986\">1986</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1987\">1987</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1988\">1988</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1989\">1989</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1990\">1990</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1991\">1991</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1992\">1992</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1993\">1993</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1994\">1994</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1995\">1995</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1996\">1996</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1997\">1997</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1998\">1998</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1991\">1999</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2000\">2000</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2001\">2001</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2002\">2002</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2003\">2003</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2004\">2004</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2005\">2005</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2006\">2006</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2007\">2007</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2008\">2008</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2009\">2009</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2010\">2010</option>\r\n");
      out.write("\t\t\t\t    </select>\r\n");
      out.write("\t\t\t\t  </td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t  <td height=\"26\"><input type=\"submit\" value=\"Add\"/></td>\r\n");
      out.write("\t\t\t\t  <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("\t\t\t  \t</tr>\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<td height=\"28\" colspan=\"2\"><a href=\"blacklist_record_calculate_new\"  title=\"See all Blacklist Student\" name=\"blacklistrecord\" />See all Placed Student </td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t  </table>\r\n");
      out.write("\t  </form>\t\t</td>\r\n");
      out.write("      <td width=\"344\" height=\"180\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td height=\"212\" colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
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
