package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exTwitter.OnceBean;
import exTwitter.Once;
import java.util.ArrayList;

public final class OnceDelUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>単発ツイート削除</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- タイトル -->\r\n");
      out.write("\t\t<div id=\"a\">\r\n");
      out.write("\t\t\t<div id=\"label\">\r\n");
      out.write("\t\t\t\t単発ツイート削除\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t<!-- フォームの配置（delBtnは後で作成する） -->\r\n");
      out.write("\t\t\t<form method=\"post\" action=\"OnceDel\" onSubmit=\"return delBtn()\">\r\n");
      out.write("\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t<!-- テーブル -->\r\n");
      out.write("\t\t\t\t\t<table border=\"2\" style=\"font-size:20\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>　　　</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>　ツイート　</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>　予約日　</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>　予約時間　</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");

							if(Once.onceList != null){
								for(int i=0;i<Once.onceList.size();i++){
									out.println("<tr>");
									out.println("<td align=\"center\">　<input type=\"submit\" style=\"width:50px;height:30px;font-size:15\" value=\"削除\" name=\"" + Once.onceList.get(i).getOnceId() + "\">　</td>");
									out.println("<td align=\"center\">" + Once.onceList.get(i).getText() + "</td>");
									out.println("<td align=\"center\">" + Once.onceList.get(i).getDate() + "</td>");
									out.println("<td align=\"center\">" + Once.onceList.get(i).getTime() + "</td>");
									out.print("</tr>");
								}
							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<!-- こここまでTBL -->\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"Control\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" style=\"width:100px;height:40px;font-size:20\" name=\"単発\" value=\"戻る\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</center>\r\n");
      out.write("\t\t</div>\r\n");
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
