package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exTwitter.OnceBean;
import exTwitter.Once;
import java.util.Calendar;
import java.lang.Integer;
import java.util.ArrayList;

public final class OnceUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t");
	
		//現在時刻の取得
		Calendar cal = Calendar.getInstance();
		int now_minute = cal.get(Calendar.MINUTE);
		cal.add(Calendar.MINUTE,+5-(now_minute%5));
		int now_year = cal.get(Calendar.YEAR);
  		int now_month = cal.get(Calendar.MONTH)+1;
  		int now_day = cal.get(Calendar.DATE);
  		int now_hour = cal.get(Calendar.HOUR_OF_DAY);
  		now_minute = cal.get(Calendar.MINUTE);
  		//ここまで
  		
  		Integer cont = (Integer)session.getAttribute("contribution");	//ツイート登録後かどうかのフラグを取得
  		session.setAttribute("contribution",0);	//セッションの値を0にしておく
  		int contInt;	//フラグの値を代入する（JavaScriptで使う）
  		if(cont == null){	//フラグがnullの場合
  			contInt = 0;	//フラグの値を0とする
  		}
  		else{
  			contInt = cont.intValue();	//フラグの値を代入
  		}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>単発ツイート作成</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t<!-- タイトル -->\r\n");
      out.write("\t\t<div id=\"a\">\r\n");
      out.write("\t\t\t<div id=\"label\">\r\n");
      out.write("\t\t\t\t単発ツイート作成\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 以下、フォームの配置 -->\r\n");
      out.write("\t\t\t<form method=\"post\" action=\"OnceUpdate\" onSubmit=\"return twbtn()\">\r\n");
      out.write("\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- ツイートのタイトルと本文の入力フォーム -->\r\n");
      out.write("\t\t\t\t\t<textarea name=\"text\" style=\"width:400px;height:200px;resize:none;font-size:22\" maxlength=\"140\" placeholder=\"ツイートを入力してね\" required></textarea><br>\r\n");
      out.write("\t\t\t\t<!-- ツイート終わり -->\r\n");
      out.write("\t\t\t\t<!-- 日付指定チェックボックス -->\r\n");
      out.write("\t\t\t\t\t<dev id=\"check\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" id=\"chk1\" name=\"chk1\" onclick='chkdisp(this)' /><label for=\"chk1\">日付指定する</label>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t</dev>\r\n");
      out.write("\t\t\t\t<!--ツイート日時の入力フォーム-->\r\n");
      out.write("\t\t\t\t\t<div id=\"select_t\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t日付指定\r\n");
      out.write("\t\t\t\t\t\t");
 out.println("<input type=\"number\" style=\"width:70px;height:30;font-size:20\" name=\"year\" require max=2020 min=2015 value="+ now_year +" step=1>年</input>"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
 out.println("<input type=\"number\" style=\"width:50px;height:30;font-size:20\" name=\"month\" require max=12 min=1 value="+ now_month +" step=1>月</input>"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
 out.println("<input type=\"number\" style=\"width:50px;height:30;font-size:20\" name=\"day\" require max=31 min=1 value="+ now_day +" step=1>日</input>"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\t\t時刻指定\r\n");
      out.write("\t\t\t\t\t\t");
 out.println("<input type=\"number\" style=\"width:50px;height:30;font-size:20\" name=\"hour\" require max=23 min=0 value="+ now_hour +" step=1>時</input>"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
 out.println("<input type=\"number\" style=\"width:50px;height:30;font-size:20\" name=\"minute\" require max=59 min=0 value="+ now_minute +" step=5>分</input>"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!--日時ここまで-->\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div id=\"botton\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" style=\"width:100px;height:40px;font-size:20\" value=\"ツイート\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<div Align=\"left\">登録されている時間指定ツイート一覧</div>\r\n");
      out.write("\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"Control\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" style=\"width:120px;height:40px;font-size:20\" name=\"単発削除\" value=\"削除画面へ\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<center>\r\n");
      out.write("\t\t\t\t<!--テーブル-->\r\n");
      out.write("\t\t\t\t<table border=\"2\" style=\"font-size:20\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>　ツイート　</th>\r\n");
      out.write("\t\t\t\t\t\t<th>　予約日　</th>\r\n");
      out.write("\t\t\t\t\t\t<th>　予約時間　</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");

						if(Once.onceList != null){
							for(int i=0;i<Once.onceList.size();i++){
								out.print("<tr>");
								out.print("<td align=\"center\">" + Once.onceList.get(i).getText() + "</td>");
								out.print("<td align=\"center\">" + Once.onceList.get(i).getDate() + "</td>");
								out.print("<td align=\"center\">" + Once.onceList.get(i).getTime() + "</td>");
								out.print("</tr>");
							}
						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</table><!--テーブル終わり-->\r\n");
      out.write("\t\t\t</center>\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 以下、javascript -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t//チェックボックスの状態によって表示を切り替える\r\n");
      out.write("\t \tfunction chkdisp(obj) {\r\n");
      out.write(" \t\t\tif( obj.checked ){\t//チェックされている\r\n");
      out.write(" \t\t \t\tdocument.getElementById('select_t').style.display = \"block\";\t//表示\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t\telse {\t//されていない\r\n");
      out.write("  \t\t\t\tdocument.getElementById('select_t').style.display = \"none\";\t//非表示\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//画面遷移後最初に読み込まれる関数\r\n");
      out.write("\t\tfunction disp(){\r\n");
      out.write("\t\t\t");
 out.print( "var contInt = " + contInt + ";" ); 
      out.write("\t//Javaで処理した値を挿入\r\n");
      out.write("\t\t\tdocument.getElementById('select_t').style.display = \"none\";\t//日付指定は初期状態で非表示\r\n");
      out.write("\t\t\tvar checkbox = document.getElementById(\"chk1\");\r\n");
      out.write("\t\t\tcheckbox.checked = false;\t//チェックボックスは初期状態ではチェックしない\r\n");
      out.write("\t\t\tif(contInt == 1)\twindow.alert('ツイート登録完了');\t//フラグが投稿成功状態の場合ダイアログを表示\r\n");
      out.write("\t\t\telse if(contInt == -1) window.alert('ツイート登録失敗');\t//失敗の場合のダイアログ\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//ツイート登録確認ダイアログを表示\r\n");
      out.write("\t\tfunction twbtn(){\r\n");
      out.write("\t\t\tif(window.confirm('ツイート登録しますか？')){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\twindow.alert('キャンセルしました');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\twindow.onload = disp;\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- ここまでjavascript -->\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
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
