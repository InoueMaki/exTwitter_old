package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menuUI_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("\t<HEAD>\r\n");
      out.write("\t\t<TITLE>メニュー画面</TITLE>\r\n");
      out.write("\t\t<LINK rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t</HEAD>\r\n");
      out.write("\t\r\n");
      out.write("\t<BODY>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<CENTER ID=\"a\">\r\n");
      out.write("\t\t\t<div id=\"label\">メニュー画面</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 各画面への遷移(必要性検討中<-ヘッダで十分？) -->\r\n");
      out.write("\t\t\t<FORM METHOD=\"POST\" ACTION=\"Control\">\r\n");
      out.write("\t\t\t\t<TABLE class=\"center\">\r\n");
      out.write("\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t<TD ><INPUT type=\"submit\" class=\"menuButton\" value=\"単発ツイート\" name=\"単発\">\r\n");
      out.write("\t\t\t\t\t\t<TD><DIV class=\"box\">飲み会のリマインドや<BR>面白ページや小ネタの投稿</DIV>\r\n");
      out.write("\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t<TD ><INPUT type=\"submit\" class=\"menuButton\" value=\"定期ツイート\" name=\"定期\">\r\n");
      out.write("\t\t\t\t\t\t<TD><DIV class=\"box\">週報や業務報告書など<BR>定期的な連絡用</DIV>\r\n");
      out.write("\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t</FORM>\r\n");
      out.write("\t\t</CENTER>\t\r\n");
      out.write("\t\r\n");
      out.write("\t</BODY>\r\n");
      out.write("\r\n");
      out.write("</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
