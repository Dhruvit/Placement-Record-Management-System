package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class messageBox_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("         function noBack() \r\n");
      out.write("            {\r\n");
      out.write("                window.history.forward(0);\r\n");
      out.write("            }\r\n");
      out.write("    </script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>Feedback | Placement Record Management System</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style1 {font-size: 18px}\r\n");
      out.write(".style2 {\r\n");
      out.write("\tfont-size: 24px;\r\n");
      out.write("\tfont-family: \"Courier New\", Courier, monospace;\r\n");
      out.write("\tcolor: #6600FF;\r\n");
      out.write("}\r\n");
      out.write(".style3 {font-size: 10px}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headerStudent.html", out, false);
      out.write("\r\n");
      out.write("\t<form  method=\"post\" name=\"messageBox\"  action=\"setRead\">\r\n");
      out.write("        <table width=\"1112\" height=\"152\" align=\"center\"  border=\"4\" bgcolor=\"#CCFFFF\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td bgcolor=\"#00CCFF\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"482\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t  <th>Inbox(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.totalmsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</th><th>Unread(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.totalunread}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</th>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t  </table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("                    \r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"107\" colspan=\"2\" >\r\n");
      out.write("\t\t\t\t<table width=\"1095\" height=\"109\"  align=\"center\">\r\n");
      out.write("\t\t\t\t\t<thead  BGCOLOR=\"lightskyblue\">\r\n");
      out.write("\t\t\t\t  <th>No.</th><th>Subject</th><th>From</th><th>Date</th><th>See</th>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tbody BGCOLOR=\"lemonchiffon\">\r\n");
      out.write("                  \r\n");
      out.write("            \t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t<tfoot BGCOLOR=\"lightskyblue\">\r\n");
      out.write("  \t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t<td height=\"21\" colspan=\"5\" >read Message... </td>\r\n");
      out.write("  \t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tfoot>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t  </td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t  </table>\r\n");
      out.write("</form>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("listElement");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${messagebox}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            \t\t\t<tr>\r\n");
          out.write("                    \t\r\n");
          out.write("                    \t\t<td width=\"117\" align=\"center\" bgcolor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[4]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        \t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\t\t\t        \t\t</td>\r\n");
          out.write("                    \t\t<td width=\"360\" align=\"center\" bgcolor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[4]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        \t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[1]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("                    \t\t<td width=\"240\" align=\"center\" bgcolor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[4]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        \t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[2]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\t\t\t\t\t\t</td> \r\n");
          out.write("                    \t\t<td width=\"240\" align=\"center\" bgcolor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[4]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        \t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[3]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("                    \t\r\n");
          out.write("                    \t\t<td width=\"114\" align=\"center\" bgcolor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listElement[4]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                    <input type=\"submit\" value=\"read\" onClick=\"\r\n");
          out.write("                                    ");
          foo.setMessageno mgno = null;
          synchronized (session) {
            mgno = (foo.setMessageno) _jspx_page_context.getAttribute("mgno", PageContext.SESSION_SCOPE);
            if (mgno == null){
              mgno = new foo.setMessageno();
              _jspx_page_context.setAttribute("mgno", mgno, PageContext.SESSION_SCOPE);
              out.write("\r\n");
              out.write("                                        ");
              org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("mgno"), "mno", "${listElement[0]}", _jspx_page_context, null);
              out.write("\r\n");
              out.write("                                    ");
            }
          }
          out.write("\" \r\n");
          out.write("                                           />\r\n");
          out.write("                                </td>\r\n");
          out.write("             \t\t\t</tr>\r\n");
          out.write("            \t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
