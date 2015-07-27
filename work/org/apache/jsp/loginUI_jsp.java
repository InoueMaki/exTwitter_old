package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- ログイン画面 -->\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("\r\n");
      out.write("\t<HEAD>\r\n");
      out.write("\t\t<TITLE>ログイン画面</TITLE>\r\n");
      out.write("\t\t<LINK rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t</HEAD>\r\n");
      out.write("\t\r\n");
      out.write("\t<BODY>\r\n");
      out.write("\t\t<BR><BR>\r\n");
      out.write("\t\t<CENTER ID=\"a\">\r\n");
      out.write("\t\t\t<H1>ログイン画面</H1>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- ユーザ名・パスワード入力 -->\r\n");
      out.write("\t\t\t<FORM METHOD=\"POST\" ACTION=\"../exTwitter/Control\">\r\n");
      out.write("\t\t\t\t<TABLE class=\"login\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t<TR><TD><INPUT type=\"text\" name=\"user_name\" name=\"user_name\" style=\"font-size:30px;\" required size=50 minlength=1 maxlength=16 pattern=\"^[0-9a-zA-Z]+$\" placeholder=\"ユーザ名\" autocomplete=\"off\" autofocus>\r\n");
      out.write("\t\t\t\t\t<TR><TD><INPUT type=\"password\" name=\"password\" style=\"font-size:30px;\"required size=50 minlength=4 maxlength=16 autocomplete=\"off\" pattern=\"^[0-9a-zA-Z]+$\" placeholder=\"パスワード\" >\r\n");
      out.write("\t\t\t\t\t<TR><TD><INPUT type=\"submit\" value=\"ログイン\" name=\"login\" style=\"font-size:40px;color:black\">\r\n");
      out.write("\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t</FORM>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 入力ミス等で戻ってきたときの処理 -->\r\n");
      out.write("\t\t\t");

			String error =(String)request.getAttribute("err");
			if (error!=null){
      out.write("\r\n");
      out.write("\t\t\t\t<H3><font color=red>");
      out.print(error);
      out.write("</font></H3>\r\n");
      out.write("\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t\t<H3><br></H3>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
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
