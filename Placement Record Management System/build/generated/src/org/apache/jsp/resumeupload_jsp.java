package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resumeupload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function checkFile()\r\n");
      out.write("            {\r\n");
      out.write("                re=/[^\\s]+(\\.(?i)(docx|txt)$/;\r\n");
      out.write("                if(!re.test(uploadForm.file.value)) {\r\n");
      out.write("        \t\talert(\"Only upload resume type of document\");\r\n");
      out.write("        \t\tuploadForm.file.focus();\r\n");
      out.write("        \t\treturn false;\r\n");
      out.write("      \t\t\t}\r\n");
      out.write("            }\r\n");
      out.write("            function noBack() \r\n");
      out.write("            {\r\n");
      out.write("                window.history.forward(0);\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body onLoad=\"noBack();\" onpageshow=\"if (event.persisted) noBack();\" onUnload=\"\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headerStudent.html", out, false);
      out.write("\r\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.alert}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("    <table width=\"1112\" height=\"500\" align=\"center\" border=\"4\" bgcolor=\"#CCFFFF\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"center\">\r\n");
      out.write("                <form method=\"post\"  action=\"UploadResume\" enctype=\"multipart/form-data\" name=\"uploadForm\" onSubmit=\"return checkForm(this);\">\r\n");
      out.write("                    <table width=\"382\" height=\"67\" border=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <p align=\"center\"><strong><font size=\"5\">Upload Resume</font></strong></p>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td><p>Upload a Resume:</p></td>\r\n");
      out.write("                            <td><input  type=\"file\" name=\"file\" align=\"right\" size=\"50\"/></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td><input type=\"submit\" value=\"Upload\" /></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </form>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\t\r\n");
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
