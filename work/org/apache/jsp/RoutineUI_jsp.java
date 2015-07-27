package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exTwitter.RoutineBean;
import java.util.ArrayList;
import java.lang.*;

public final class RoutineUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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

/*定期ツイート一覧受け取り*/
ArrayList<RoutineBean> tweetList = (ArrayList<RoutineBean>)session.getAttribute("tweetList");
/*フラグ受け取り*/
Integer flg = (Integer)(session.getAttribute("flg"));
session.setAttribute("flg",0);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>定期ツイート作成</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--各入力フォームのスタイル記述-->\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t/*ツイートのタイトルの設定*/\r\n");
      out.write("\t\t\t.twt_title { width:200px;\r\n");
      out.write("\t\t\t\t   height:30px;\r\n");
      out.write("\t\t\t\t   font-size:20;\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t/*ツイートの本文の設定*/\r\n");
      out.write("\t\t\t.twt_text { width:400px;\r\n");
      out.write("\t\t\t\t\t    height:200px;\r\n");
      out.write("\t\t\t\t\t    resize:none;\r\n");
      out.write("\t\t\t\t\t    font-size:22;\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t/*４桁の数字を入力する部分用*/\r\n");
      out.write("\t\t\t.inp_4num { width:70px;\r\n");
      out.write("\t\t\t\t\t   height:30px;\r\n");
      out.write("\t\t\t\t\t   font-size:20;}\r\n");
      out.write("\t\t\t/*２桁の数字を入力する部分用*/ \r\n");
      out.write("\t\t\t.inp_2num { width:50px;\r\n");
      out.write("\t\t\t\t\t    height:30px;\r\n");
      out.write("\t\t\t\t\t    font-size:20;\r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t\t      \r\n");
      out.write("\t\t\t/*ラジオボタン＆チェックボックス*/\r\n");
      out.write("\t\t\t.rad_chk { width:20px;\r\n");
      out.write("\t\t\t\t\t   height:20px;\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t/*ツイート一覧の設定*/\r\n");
      out.write("\t\t\t.tbl { font-size:24;\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t/*ボタンの設定*/\r\n");
      out.write("\t\t\t.btn { width:130px;\r\n");
      out.write("\t\t\t\t   height:40px;\r\n");
      out.write("\t\t\t\t   font-size:20;\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<!--スタイル終わり-->\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- タイトル -->\r\n");
      out.write("\t\t<div id=\"a\">\r\n");
      out.write("\t\t\t<div id=\"label\">\r\n");
      out.write("\t\t\t\t定期ツイート作成\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 以下、フォームの配置 -->\r\n");
      out.write("\t\t\t<!--<form action=\"test\">-->\r\n");
      out.write("\t\t\t<form action=\"Control\" onsubmit=\"return errorCheck()\" method=\"post\">\r\n");
      out.write("\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- ツイートのタイトルと本文の入力フォーム -->\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" required class=\"twt_title\" size=\"7\" id=\"title\" name=\"title\" maxlength=\"10\" require autofocusend placeholder=\"ツイートのタイトル\">\r\n");
      out.write("\t\t\t\t\t\t10文字まで<br><br>\r\n");
      out.write("\t\t\t\t\t<textarea id=\"text\" required name=\"text\" class=\"twt_text\" maxlength=\"140\" placeholder=\"ツイートを入力してね\"></textarea><br>\r\n");
      out.write("\t\t\t\t<!-- ツイート終わり -->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!--ツイートの期間と時刻の入力フォーム-->\r\n");
      out.write("\t\t\t\t\t<div id=\"inputbox\">\r\n");
      out.write("\t\t\t\t\t\t期間　\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_4num\" id=\"start_year\" name=\"st_y\" value=2015 max=2020 min=2015 step=1 >年</input>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_2num\" id=\"start_month\" name=\"st_m\" value=1 max=12 min=1 step=1 >月</input>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_2num\" id=\"start_day\" name=\"st_d\" value=1 max=31 min=1 step=1 >日</input>\r\n");
      out.write("\t\t\t\t\t\t ～ <input type=\"number\" class=\"inp_4num\" id=\"end_year\" name=\"end_y\" value=2015 max=2020 min=2015 step=1 >年</input>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_2num\" id=\"end_month\" name=\"end_m\" value=1 max=12 min=1 step=1 >月</input>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_2num\" id=\"end_day\" name=\"end_d\" value=1 max=31 min=1 step=1 >日</input>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\t\tツイートする時刻　　\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_2num\" id=\"tweet_hour\" name=\"twt_h\" value=0 max=23 min=0 step=1 >時</input>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"inp_2num\" id=\"tweet_minute\" name=\"twt_m\" value=0 max=55 min=0 step=5 >分</input>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--期間と時刻終わり-->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!--ツイート周期の入力フォーム-->\r\n");
      out.write("\t\t\t\t\tツイート周期　\r\n");
      out.write("\t\t\t\t\t<!-- 曜日or日付 -->\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" class=\"rad_chk\" id=\"weekday\" name=\"entryPlan\" value=\"hoge1\" onclick=\"entryChange();\" checked=\"checked\" /><label for=\"weekday\">曜日指定</label>　\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" class=\"rad_chk\" id=\"day\" name=\"entryPlan\" value=\"hoge2\" onclick=\"entryChange();\" /><label for=\"day\">日付指定</label>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!--曜日指定フォームの表示-->\r\n");
      out.write("\t\t\t\t\t<div id=\"test1\" name=\"weekly\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=1 id=\"chk1\"/><label for=\"chk1\">月 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=2 id=\"chk2\"/><label for=\"chk2\">火 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=3 id=\"chk3\"/><label for=\"chk3\">水 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=4 id=\"chk4\"/><label for=\"chk4\">木 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=5 id=\"chk5\"/><label for=\"chk5\">金 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=6 id=\"chk6\"/><label for=\"chk6\">土 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" name=\"chk\" value=7 id=\"chk7\"/><label for=\"chk7\">日 </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" class=\"rad_chk\" id=\"chk8\" onclick=\"chkWeek();\" /><label for=\"chk8\">平日</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!--日付指定フォームの表示-->\r\n");
      out.write("\t\t\t\t\t<div id=\"test2\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<table style=\"font-size:25\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"number\" class=\"inp_2num\" name=\"days\" id=\"num0\" value=1  max=31 min=1 step=1 >日</input>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"checkbox\" class=\"rad_chk\" name=\"monthend\" id=\"monthend\"><label for=\"monthend\">月末</label>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"追加入力\" onclick=\"addElement()\"> \r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"定期登録\" class=\"btn\" value=\"ツイート登録\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</center>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<!--</form>-->\r\n");
      out.write("\t\t\t<!-- ここまでフォームの配置 -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				if(tweetList.size()!=0){
					/*以下、定期ツイート一覧の表示*/
					out.print("登録されている定期ツイート一覧");
					out.print("<div align=\"right\"><font size=\"5\">");
					out.print("<form action=\"Control\" method=\"post\">");
						out.print("<input type=\"submit\" class=\"btn\" name=\"定期削除\" value=\"削除画面へ\">");
					out.print("</form>");
					out.print("</font></div>");
					
					out.print("<center>");
					/*テーブル*/
					out.print("<table border=\"2\" class=\"tbl\">");
						out.print("<tr>");
							out.print("<th>　タイトル　</th>");
							out.print("<th>　本文　</th>");
							out.print("<th>　ツイート時刻　</th>");
							out.print("<th>　開始日　</th>");
							out.print("<th>　終了日　</th>");
						out.print("</tr>");
					
					
						for(int i=0;i<tweetList.size();i++){
							out.print("<tr>");
							out.print("<td>" + tweetList.get(i).getTitle() + "</td>");
							out.print("<td>" + tweetList.get(i).getSnippet() + "</td>");
							out.print("<td>" + tweetList.get(i).getPost_time() + "</td>");
							out.print("<td>" + tweetList.get(i).getStart_date() + "</td>");
							out.print("<td>" + tweetList.get(i).getEnd_date() + "</td>");
							out.print("</tr>");
						}
					
				
					out.print("</table>");/*テーブル終わり*/
					out.print("</center>");
				}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!--定期ツイート一覧表示終わり-->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!--<div id=\"a\">終わり-->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 以下、javascript -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* 日付を指定する入力フォームを追加する関数 */\r\n");
      out.write("\t\tvar i = 1; /* i-1 = 入力フォームを追加した回数 */\r\n");
      out.write("\t\tfunction addElement() { \r\n");
      out.write("\t\t\tif(i<=31){\r\n");
      out.write("\t\t\t\tTr  = document.createElement(\"Tr\");\r\n");
      out.write("\t\t\t\tTd1  = document.createElement(\"Td\");\r\n");
      out.write("\t\t\t\tTd2  = document.createElement(\"Td\");\t\r\n");
      out.write("\t\t\t\tTd3  = document.createElement(\"Td\");\r\n");
      out.write("\t\t\t\tTd1.innerHTML=\"<button onclick='removeElement(\"+i+\")'>削除</button> \"\r\n");
      out.write("\t\t\t\tTd2.innerHTML=\"<input type=\\\"number\\\" class=\\\"inp_2num\\\" name=\\\"days\\\" id=\\\"num\"+i+\"\\\"\"+\"value=1  max=31 min=1 step=1 >日</input>\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tTr.appendChild(Td1);\r\n");
      out.write("\t\t\t\tTr.appendChild(Td2);\r\n");
      out.write("\t\t\t\tTr.appendChild(Td3); \r\n");
      out.write("\t\t\t\tTr.id = i;\r\n");
      out.write("\t\t\t\tvar objTBL = document.getElementsByTagName(\"tbody\").item(1); \r\n");
      out.write("\t\t\t\tobjTBL.appendChild(Tr);\r\n");
      out.write("\t\t\t\ti = i+1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t/*追加した要素を削除する関数*/\r\n");
      out.write("\t\tfunction removeElement(id) { \r\n");
      out.write("\t\t\tvar element = document.getElementById(id);\r\n");
      out.write("\t\t\tvar tbl = document.getElementsByTagName(\"tbody\").item(1);\r\n");
      out.write("\t\t\ttbl.removeChild(element); \t\r\n");
      out.write("\t\t} \r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*「曜日指定」と「日付指定」で表示切替する関数*/\r\n");
      out.write("\t\tfunction entryChange(){\r\n");
      out.write("\t\t\tradio = document.getElementsByName('entryPlan');\r\n");
      out.write("\t\t\tif(radio[0].checked) {\r\n");
      out.write("\t\t\t\tdocument.getElementById('test1').style.display = \"\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('test2').style.display = \"none\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t}else if(radio[1].checked) {\r\n");
      out.write("\t\t\t\tdocument.getElementById('test1').style.display = \"none\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('test2').style.display = \"\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*入力情報確認ダイアログを表示する関数*/\r\n");
      out.write("\t\tfunction tweet(){\r\n");
      out.write("\t\t\tvar days=[];\r\n");
      out.write("\t\t\tradio = document.getElementsByName('entryPlan');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*ツイート周期の文字列を生成する。*/\r\n");
      out.write("\t\t\t/*ラジオボタンによる表示切替に合わせてダイアログに表示する文字列を切り替える。*/\r\n");
      out.write("\t\t\tif(radio[0].checked){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/*-指定曜日の受け取り*/\r\n");
      out.write("\t\t\t\tvar strDays=\"指定した曜日\\n\";\r\n");
      out.write("\t\t\t\tvar dayList=[\"\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\",\"日\"];\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tfor(var j=1;j<=7;j++){\r\n");
      out.write("\t\t\t\t\tif(document.getElementById(\"chk\"+j).checked){\r\n");
      out.write("\t\t\t\t\t\tdays[days.length]=dayList[j];\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}else{\t\r\n");
      out.write("\t\t\t\t/*指定日付の受け取り*/\r\n");
      out.write("\t\t\t\tvar strDays=\"指定した日付\\n\";\r\n");
      out.write("\t\t\t\tfor(var j=0;j<i;j++){\r\n");
      out.write("\t\t\t\t\tif(document.getElementById(\"num\"+j)) {\r\n");
      out.write("\t\t\t\t\t\tdays[days.length]=document.getElementById(\"num\"+j).value;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"monthend\").checked){\r\n");
      out.write("\t\t\t\t\tdays[days.length]=\"月末\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t/*データから文字列生成*/\r\n");
      out.write("\t\t\tfor(var j=0;j<days.length;j++){\r\n");
      out.write("\t\t\t\t//<!--文字の間にコンマを挟むための処理-->\r\n");
      out.write("\t\t\t\tif(j!=0){\r\n");
      out.write("\t\t\t\t\tstrDays=strDays+\",\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tstrDays=strDays+days[j];\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t/*ツイート周期の文字列の生成終わり*/\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*ダイアログに表示する文字列の生成*/\r\n");
      out.write("\t\t\tvar strDialog=\"ツイートの内容は以下でよろしいですか？\\n\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"タイトル\\n\"+document.getElementById(\"title\").value+\"\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"本文\\n\"+document.getElementById(\"text\").value+\"\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"開始日\\n\"+document.getElementById(\"start_year\").value+\"年\"+document.getElementById(\"start_month\").value+\"月\"+document.getElementById(\"start_day\").value+\"日\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"終了日\\n\"+document.getElementById(\"end_year\").value+\"年\"+document.getElementById(\"end_month\").value+\"月\"+document.getElementById(\"end_day\").value+\"日\\n\\n\"+\r\n");
      out.write("\t\t\t\t\t\"時刻\\n\"+document.getElementById(\"tweet_hour\").value+\"時\"+document.getElementById(\"tweet_hour\").value+\"分\\n\\n\"+\r\n");
      out.write("\t\t\t\t\tstrDays;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\treturn confirm(strDialog);\r\n");
      out.write("\t\t\t}/*入力情報確認ダイアログ関数終わり*/\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*「平日」にチェックが入った時の処理*/\r\n");
      out.write("\t\tfunction chkWeek(){\r\n");
      out.write("\t\t\twd = document.getElementById(\"chk8\");\r\n");
      out.write("\t\t\tif(wd.checked){\r\n");
      out.write("\t\t\t\tfor(var j=1;j<=5;j++){\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"chk\"+j).checked=true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tfor(var j=1;j<=5;j++){\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"chk\"+j).checked=false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*エラーチェックし、エラーない時ツイート登録関数を呼び出す関数*/\r\n");
      out.write("\t\tfunction errorCheck(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tvar err=1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*ラジオボタンが「曜日指定」、かつ、チェックボックスに何もない時のチェック*/\r\n");
      out.write("\t\t\tvar radio = document.getElementsByName('entryPlan');\r\n");
      out.write("\t\t\tif(radio[0].checked){\r\n");
      out.write("\t\t\t\tfor(var j=1;j<=7;j++){\r\n");
      out.write("\t\t\t\t\tif(document.getElementById(\"chk\"+j).checked){\r\n");
      out.write("\t\t\t\t\t\terr=0;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\terr=0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t/*エラーあったらメッセージ表示、なかったらtweet登録関数呼び出し*/\r\n");
      out.write("\t\t\tif(err==1){\r\n");
      out.write("\t\t\t\talert(\"曜日指定をしてください\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\treturn tweet();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*登録完了ダイアログ*/\r\n");
      out.write("\t\tfunction doneDialog(){\r\n");
      out.write("\t\t\tvar flg=0;\r\n");
      out.write("\t\t\t");
 out.print("flg=" + flg + ";" );
      out.write("\r\n");
      out.write("\t\t\tif(flg==1){\r\n");
      out.write("\t\t\t\talert(\"登録完了しました！\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*関数登録*/\r\n");
      out.write("\t\taddOnloadEvent(entryChange);\r\n");
      out.write("\t\taddOnloadEvent(doneDialog);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*画面開いたときに行う関数の登録をする関数*/\r\n");
      out.write("\t\tfunction addOnloadEvent(fnc){  \r\n");
      out.write("\t\t\tif ( typeof window.addEventListener != \"undefined\" ){\r\n");
      out.write("\t\t\t\twindow.addEventListener( \"load\", fnc, false );  \r\n");
      out.write("\t\t\t}else if ( typeof window.attachEvent != \"undefined\" ){  \r\n");
      out.write("\t\t\t    window.attachEvent( \"onload\", fnc );  \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- ここまでjavascript -->\r\n");
      out.write("\t\r\n");
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
