package exTwitter;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class RoutineUpdate extends HttpServlet{

	@Override
	protected void doPost( HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("RoutineUpdate開始");
		
		//入力エンコーディングの指定
		request.setCharacterEncoding("UTF-8");
		
		//セッションの取得
		HttpSession session = request.getSession();
	
		//入力情報を取得
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String startYear = request.getParameter("st_y");
		String startMonth = request.getParameter("st_m");
		String startDay = request.getParameter("st_d");
		String endYear = request.getParameter("end_y");		
		String endMonth = request.getParameter("end_m");
		String endDay = request.getParameter("end_d");
		String tweetHour = request.getParameter("twt_h");
		String tweetMinute = request.getParameter("twt_m");
		String entryPlan = request.getParameter("entryPlan");
		String monthEnd =request.getParameter("monthend");
		
		String[] daysStr;
		if(entryPlan.compareTo("hoge1")==0){//ラジオボタンのチェック状況によって受け取るものを変える。
			daysStr = request.getParameterValues("chk");
		}else{
			daysStr = request.getParameterValues("days");
			}

		//曜日や日付を数値で扱いたいので、変換してアレイリストへ
		ArrayList<Integer> days = new ArrayList<Integer>();
		for(int i=0; i<daysStr.length;i++){
			if(daysStr[i]!=null){
				days.add(Integer.parseInt(daysStr[i]));
			}
		}
		//「月末」にチェックが入っているときその情報追加
		if(monthEnd!=null && entryPlan.compareTo("hoge2")==0){
			days.add(0);
		}
		try{
			//DB操作に入るので準備
			DBManager DBM = new DBManager();
			DBM.getConnection();

			//numberingTBLからID取得
			int routineID = 0;
			ResultSet rs = DBM.getResultSet("SELECT * FROM numbering");
			
			while(rs.next()){
				routineID = rs.getInt("routine_id");
			}
			DBM.exeUpdate("UPDATE numbering SET routine_id="+(routineID+1));

			//routineTBLにデータ挿入するためのクエリ
			String qry = "INSERT INTO routine VALUES("+routineID+",'"+
									text+"',"+0+",'"+startYear+"-"+startMonth+"-"+startDay+
									"','"+endYear+"-"+endMonth+"-"+endDay+"','"+
									tweetHour+":"+tweetMinute+":00','"+title+"')";
			//クエリ実行
			int count = DBM.exeUpdate(qry);
			System.out.println(qry);
			System.out.println(count);
			
			//ラジオボタンの状況によってツイート周期の入れる情報が異なる。
			//情報の種類によって、操作するテーブルを決める。（monthlyTBL or weeklyTBL）
			if(entryPlan.compareTo("hoge1")==0){
				insertIntoWeekly(routineID,days);
			}else{
				insertIntoMonthly(routineID,days);
			}
			
			DBM.closeConnection();

			
			
		}catch(Exception e){
			System.err.println("error");
		}	//	DB操作終わり
	
		//ここから遷移したことを知らせるフラグ
		int flg=1;
		session.setAttribute("flg", flg);
		
		//画面遷移
		RequestDispatcher rdisp = request.getRequestDispatcher("Routine");
		rdisp.forward(request, response);
	}
	
	//monthlyTBLにデータ挿入するためのクエリを作って実行
	private void insertIntoMonthly(int routineID,ArrayList<Integer> days) {
	
			DBManager DBM = new DBManager();
			DBM.getConnection();
			String qry = "INSERT INTO monthly values";
			
			for(int i=0;i<days.size();i++){
				qry = qry+"("+routineID+","+days.get(i)+")";
				//最後のとき以外はコンマを入れる
				if(i!=days.size()-1){
					qry = qry+",";
				}else{
					qry+=";";
				}
			}
			System.out.println(qry);
			int count = DBM.exeUpdate(qry);
			System.out.println(count);
			
			DBM.closeConnection();
	}
	
	// weeklyTBLにデータ挿入するためのクエリを作って実行
	private void insertIntoWeekly(int routineID,ArrayList<Integer>  days) {

		DBManager DBM = new DBManager();
		DBM.getConnection();
		String qry = "INSERT INTO weekly values";
		
		for(int i=0;i<days.size();i++){
			qry = qry+"("+routineID+","+days.get(i)+")";
			//最後のとき以外はコンマを入れる
			if(i!=days.size()-1){
				qry = qry+",";
			}
		}
		
		System.out.println(qry);
		int count=DBM.exeUpdate(qry);
		System.out.println(count);
		
		DBM.closeConnection();
	}
}
