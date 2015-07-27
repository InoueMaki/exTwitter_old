package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exTwitter.RoutineBean;
import java.util.ArrayList;

public final class RoutinedelUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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

/*定期ツイート一覧受け取り*/
ArrayList<RoutineBean> tweetList = (ArrayList<RoutineBean>)session.getAttribute("tweetList");
Integer flg = (Integer)(session.getAttribute("flg"));
session.setAttribute("flg",0);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>定期ツイート削除</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!--以下、定期ツイート一覧の表示-->\r\n");
      out.write("\t\t<div id=\"a\">\r\n");
      out.write("\t\t\t<div id=\"label\">定期ツイート削除</div>\r\n");
      out.write("\t\t\t");

				if(tweetList.size()!=0){
					/*以下、定期ツイート一覧の表示*/
					out.print("登録されている定期ツイート一覧");
					out.print("<form action='Control' onsubmit='return jump();' method='post'>");
					out.print("<center>");
					/*テーブル*/
					out.print("<table border=\"2\" style=\"font-size:24\">");
							out.print("<th></th>");
							out.print("<th>　タイトル　</th>");
							out.print("<th>　本文　</th>");
							out.print("<th>　ツイート時刻　</th>");
							out.print("<th>　開始日　</th>");
							out.print("<th>　終了日　</th>");
						out.print("</tr>");
						
						for(int i=0;i<tweetList.size();i++){
							out.print("<tr id=\""+i+"\">");
							out.print("<td><input type=\"submit\" name=\"定期削除servlet\" value=\"削除\" onclick=\"delComfirmDialog("+i+")\"></td>");
							out.print("<td>" + tweetList.get(i).getTitle() + "</td>");
							out.print("<td>" + tweetList.get(i).getSnippet() + "</td>");
							out.print("<td>" + tweetList.get(i).getPost_time() + "</td>");
							out.print("<td>" + tweetList.get(i).getStart_date() + "</td>");
							out.print("<td>" + tweetList.get(i).getEnd_date() + "</td>");
							out.print("<input type=\"hidden\" value=\""+tweetList.get(i).getText()+"\">");
							out.print("<input type=\"hidden\" value=\""+tweetList.get(i).getRoutine_id()+"\">");
							out.print("</tr>");
						}
						out.print("</table>");
						out.print("</center>");
						out.print("</form>");
						
				}else{
					out.print("<h3>"+"登録されているツイートはありません"+"<h3>");
				}
			
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar jmp=0;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//<!--削除の確認ダイアログ-->\r\n");
      out.write("\t\tfunction delComfirmDialog(i){\r\n");
      out.write("\t\t\tvar tr=document.getElementById(i);\r\n");
      out.write("\t\t\tvar child = tr.childNodes;\r\n");
      out.write("\t\t\tvar str=\"以下のツイートを削除してよろしいですか？\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"タイトル\\n\"+child[1].innerHTML+\"\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"本文\\n\"+child[6].value+\"\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"開始日\\n\"+child[3].innerHTML+\"\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"終了日\\n\"+child[4].innerHTML+\"\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"時刻\\n\"+child[5].innerHTML+\"\\n\\n\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(confirm(str)){\r\n");
      out.write("\t\t\t\t\t\tchild[7].name=\"del\";\r\n");
      out.write("\t\t\t\t\t\tjmp=1;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//<!--onsubmitで動く関数-->\r\n");
      out.write("\t\tfunction jump(){\r\n");
      out.write("\t\t\tif(jmp==1){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t//<!--削除完了ダイアログ-->\r\n");
      out.write("\t\tfunction doneDialog(){\r\n");
      out.write("\t\t\tvar flg=0;\r\n");
      out.write("\t\t\t");
 out.print("flg=" + flg + ";" );
      out.write("\r\n");
      out.write("\t\t\tif(flg==2){\r\n");
      out.write("\t\t\t\talert(\"削除完了しました！\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//<!--画面ロード時に実行する関数設定-->\r\n");
      out.write("\t\twindow.onload = doneDialog;\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
