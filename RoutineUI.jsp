<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="exTwitter.RoutineBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.*"%>

<%
/*定期ツイート一覧受け取り*/
ArrayList<RoutineBean> tweetList = (ArrayList<RoutineBean>)session.getAttribute("tweetList");
/*フラグ受け取り*/
Integer flg = (Integer)(session.getAttribute("flg"));
session.setAttribute("flg",0);
%>


<html>

	<link rel="stylesheet" type="text/css" href="style.css">
	
	<head>
		<title>定期ツイート作成</title>
		
		<!--各入力フォームのスタイル記述-->
		<style type="text/css">
		
			/*ツイートのタイトルの設定*/
			.twt_title { width:200px;
				   height:30px;
				   font-size:20;
				 }
						
			/*ツイートの本文の設定*/
			.twt_text { width:400px;
					    height:200px;
					    resize:none;
					    font-size:22;
					  }
		
			/*４桁の数字を入力する部分用*/
			.inp_4num { width:70px;
					   height:30px;
					   font-size:20;}
			/*２桁の数字を入力する部分用*/ 
			.inp_2num { width:50px;
					    height:30px;
					    font-size:20;
				      }
				      
			/*ラジオボタン＆チェックボックス*/
			.rad_chk { width:20px;
					   height:20px;
					 }
					 
			/*ツイート一覧の設定*/
			.tbl { font-size:24;
				 }
				 
			/*ボタンの設定*/
			.btn { width:130px;
				   height:40px;
				   font-size:20;
				 }
			
		</style>
		<!--スタイル終わり-->
	</head>

	<body>
		<jsp:include page="header.jsp" />
		
		<!-- タイトル -->
		<div id="a">
			<div id="label">
				定期ツイート作成
			</div>
			
			<!-- 以下、フォームの配置 -->
			<!--<form action="test">-->
			<form action="Control" onsubmit="return errorCheck()" method="post">
				<center>
					
				<!-- ツイートのタイトルと本文の入力フォーム -->
					<input type="text" required class="twt_title" size="7" id="title" name="title" maxlength="10" require autofocusend placeholder="ツイートのタイトル">
						10文字まで<br><br>
					<textarea id="text" required name="text" class="twt_text" maxlength="140" placeholder="ツイートを入力してね"></textarea><br>
				<!-- ツイート終わり -->
					
					<br>
					
				<!--ツイートの期間と時刻の入力フォーム-->
					<div id="inputbox">
						期間　
						<input type="number" class="inp_4num" id="start_year" name="st_y" value=2015 max=2020 min=2015 step=1 >年</input>
						<input type="number" class="inp_2num" id="start_month" name="st_m" value=1 max=12 min=1 step=1 >月</input>
						<input type="number" class="inp_2num" id="start_day" name="st_d" value=1 max=31 min=1 step=1 >日</input>
						 ～ <input type="number" class="inp_4num" id="end_year" name="end_y" value=2015 max=2020 min=2015 step=1 >年</input>
						<input type="number" class="inp_2num" id="end_month" name="end_m" value=1 max=12 min=1 step=1 >月</input>
						<input type="number" class="inp_2num" id="end_day" name="end_d" value=1 max=31 min=1 step=1 >日</input>
					
						<br><br>
						ツイートする時刻　　
						<input type="number" class="inp_2num" id="tweet_hour" name="twt_h" value=0 max=23 min=0 step=1 >時</input>
						<input type="number" class="inp_2num" id="tweet_minute" name="twt_m" value=0 max=55 min=0 step=5 >分</input>
					</div>
				<!--期間と時刻終わり-->
					
					<br><br>
					
				<!--ツイート周期の入力フォーム-->
					ツイート周期　
					<!-- 曜日or日付 -->
					<input type="radio" class="rad_chk" id="weekday" name="entryPlan" value="hoge1" onclick="entryChange();" checked="checked" /><label for="weekday">曜日指定</label>　
					<input type="radio" class="rad_chk" id="day" name="entryPlan" value="hoge2" onclick="entryChange();" /><label for="day">日付指定</label>
					
					
					<!--曜日指定フォームの表示-->
					<div id="test1" name="weekly">
						<br>
						<input type="checkbox" class="rad_chk" name="chk" value=1 id="chk1"/><label for="chk1">月 </label>
						<input type="checkbox" class="rad_chk" name="chk" value=2 id="chk2"/><label for="chk2">火 </label>
						<input type="checkbox" class="rad_chk" name="chk" value=3 id="chk3"/><label for="chk3">水 </label>
						<input type="checkbox" class="rad_chk" name="chk" value=4 id="chk4"/><label for="chk4">木 </label>
						<input type="checkbox" class="rad_chk" name="chk" value=5 id="chk5"/><label for="chk5">金 </label>
						<input type="checkbox" class="rad_chk" name="chk" value=6 id="chk6"/><label for="chk6">土 </label>
						<input type="checkbox" class="rad_chk" name="chk" value=7 id="chk7"/><label for="chk7">日 </label>
						<input type="checkbox" class="rad_chk" id="chk8" onclick="chkWeek();" /><label for="chk8">平日</label>
					</div>

					<!--日付指定フォームの表示-->
					<div id="test2">
						<br>
						<table style="font-size:25">
							<tr>
								<td>
								<td><input type="number" class="inp_2num" name="days" id="num0" value=1  max=31 min=1 step=1 >日</input>
								<td><input type="checkbox" class="rad_chk" name="monthend" id="monthend"><label for="monthend">月末</label>
						</table>
						<input type="button" value="追加入力" onclick="addElement()"> 
					</div>

					<br><br>
					<input type="submit" name="定期登録" class="btn" value="ツイート登録">
					
					
				</center>
				
			</form>
			<!--</form>-->
			<!-- ここまでフォームの配置 -->
			
			<br>
			
			<%
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
			%>
			
			<!--定期ツイート一覧表示終わり-->
			
		</div><!--<div id="a">終わり-->
	
	
	
	<!-- 以下、javascript -->
	<script type="text/javascript">
		
		/* 日付を指定する入力フォームを追加する関数 */
		var i = 1; /* i-1 = 入力フォームを追加した回数 */
		function addElement() { 
			if(i<=31){
				Tr  = document.createElement("Tr");
				Td1  = document.createElement("Td");
				Td2  = document.createElement("Td");	
				Td3  = document.createElement("Td");
				Td1.innerHTML="<button onclick='removeElement("+i+")'>削除</button> "
				Td2.innerHTML="<input type=\"number\" class=\"inp_2num\" name=\"days\" id=\"num"+i+"\""+"value=1  max=31 min=1 step=1 >日</input>";

				Tr.appendChild(Td1);
				Tr.appendChild(Td2);
				Tr.appendChild(Td3); 
				Tr.id = i;
				var objTBL = document.getElementsByTagName("tbody").item(1); 
				objTBL.appendChild(Tr);
				i = i+1;
			}
		} 
	
	
		/*追加した要素を削除する関数*/
		function removeElement(id) { 
			var element = document.getElementById(id);
			var tbl = document.getElementsByTagName("tbody").item(1);
			tbl.removeChild(element); 	
		} 

		
		/*「曜日指定」と「日付指定」で表示切替する関数*/
		function entryChange(){
			radio = document.getElementsByName('entryPlan');
			if(radio[0].checked) {
				document.getElementById('test1').style.display = "";
				document.getElementById('test2').style.display = "none";

			}else if(radio[1].checked) {
				document.getElementById('test1').style.display = "none";
				document.getElementById('test2').style.display = "";

			}
		}
		
		
		/*入力情報確認ダイアログを表示する関数*/
		function tweet(){
			var days=[];
			radio = document.getElementsByName('entryPlan');
			
			/*ツイート周期の文字列を生成する。*/
			/*ラジオボタンによる表示切替に合わせてダイアログに表示する文字列を切り替える。*/
			if(radio[0].checked){
				
				/*-指定曜日の受け取り*/
				var strDays="指定した曜日\n";
				var dayList=["","月","火","水","木","金","土","日"];
				
				for(var j=1;j<=7;j++){
					if(document.getElementById("chk"+j).checked){
						days[days.length]=dayList[j];
					}
				}
			}else{	
				/*指定日付の受け取り*/
				var strDays="指定した日付\n";
				for(var j=0;j<i;j++){
					if(document.getElementById("num"+j)) {
						days[days.length]=document.getElementById("num"+j).value;
					}
				}
				if(document.getElementById("monthend").checked){
					days[days.length]="月末"
				}
			}
			/*データから文字列生成*/
			for(var j=0;j<days.length;j++){
				//<!--文字の間にコンマを挟むための処理-->
				if(j!=0){
					strDays=strDays+",";
				}
				strDays=strDays+days[j];
			}
			/*ツイート周期の文字列の生成終わり*/
			
			/*ダイアログに表示する文字列の生成*/
			var strDialog="ツイートの内容は以下でよろしいですか？\n\n\n"+
					"タイトル\n"+document.getElementById("title").value+"\n\n"+
					"本文\n"+document.getElementById("text").value+"\n\n"+
					"開始日\n"+document.getElementById("start_year").value+"年"+document.getElementById("start_month").value+"月"+document.getElementById("start_day").value+"日\n\n"+
					"終了日\n"+document.getElementById("end_year").value+"年"+document.getElementById("end_month").value+"月"+document.getElementById("end_day").value+"日\n\n"+
					"時刻\n"+document.getElementById("tweet_hour").value+"時"+document.getElementById("tweet_hour").value+"分\n\n"+
					strDays;
					
					return confirm(strDialog);
			}/*入力情報確認ダイアログ関数終わり*/
		
		
		/*「平日」にチェックが入った時の処理*/
		function chkWeek(){
			wd = document.getElementById("chk8");
			if(wd.checked){
				for(var j=1;j<=5;j++){
					document.getElementById("chk"+j).checked=true;
				}
			}else{
				for(var j=1;j<=5;j++){
					document.getElementById("chk"+j).checked=false;
				}
			}
		}
		
		
		/*エラーチェックし、エラーない時ツイート登録関数を呼び出す関数*/
		function errorCheck(){
		
			var err=1;
			
			/*ラジオボタンが「曜日指定」、かつ、チェックボックスに何もない時のチェック*/
			var radio = document.getElementsByName('entryPlan');
			if(radio[0].checked){
				for(var j=1;j<=7;j++){
					if(document.getElementById("chk"+j).checked){
						err=0;
					}
				}
			}else{
				err=0;
			}
			/*エラーあったらメッセージ表示、なかったらtweet登録関数呼び出し*/
			if(err==1){
				alert("曜日指定をしてください");
				return false;
			}else{
				return tweet();
			}
		}
		
		
		/*登録完了ダイアログ*/
		function doneDialog(){
			var flg=0;
			<% out.print("flg=" + flg + ";" );%>
			if(flg==1){
				alert("登録完了しました！");
			}
		}
		
		
		/*関数登録*/
		addOnloadEvent(entryChange);
		addOnloadEvent(doneDialog);
		
		/*画面開いたときに行う関数の登録をする関数*/
		function addOnloadEvent(fnc){  
			if ( typeof window.addEventListener != "undefined" ){
				window.addEventListener( "load", fnc, false );  
			}else if ( typeof window.attachEvent != "undefined" ){  
			    window.attachEvent( "onload", fnc );  
			}
		}
		
	</script>
	<!-- ここまでjavascript -->
	
	</body>
</html>