package exTwitter;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Routine extends HttpServlet{

	@Override
	protected void doPost( HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
	
		//入力エンコーディングの指定
		request.setCharacterEncoding("UTF-8");
		
		//セッションの取得
		HttpSession session = request.getSession();
	
		//定期ツイート一覧の情報取得
		ArrayList<RoutineBean> tweetList = new ArrayList<RoutineBean>();
		tweetList=getRoutineTweet();
				
		//セッション情報からフラグを取得
		Integer flg =(Integer)session.getAttribute("flg");
		if(flg==null){
			flg=0;
		}
		
		//beanをセッション情報に保存
		session.setAttribute("tweetList", tweetList);
		
		//フラグにより遷移先指定
		String url;
		if(flg==2){
			url = "RoutinedelUI.jsp";
		}else{
			url = "RoutineUI.jsp";
		}
		//フォワードの準備
		RequestDispatcher dispatcher = 	request.getRequestDispatcher(url);

		//フォワード実行
		dispatcher.forward(request, response);
		
	}
	
	
	//定期ツイート一覧の情報を取得するメソッド
	protected ArrayList<RoutineBean> getRoutineTweet() {
		
		//必要なインスタンスを生成
		ArrayList<RoutineBean> twt = new ArrayList<RoutineBean>();
		DBManager DBM = new DBManager();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		//データべースの操作開始
		try{
			
			String qry ="select * from routine where posted=0 && end_date>'"+sdf.format(date)+"'";

			//DBコネクションの確立
			DBM.getConnection();
		
			//定期ツイートのリザルトセットを取得
			ResultSet rs = DBM.getResultSet(qry);
			
			//リザルトセットをアレイリストに直す
			int i=0;
			while(rs.next()){
				//アレイリストにBeanのインスタンスをadd
				twt.add(new RoutineBean());
				//addされたインスタンスに検索結果の各要素を代入
				twt.get(i).setRoutine_id(rs.getInt("routine_id"));
				twt.get(i).setTitle(rs.getString("title"));
				twt.get(i).setText(rs.getString("text"));
				twt.get(i).setPosted(rs.getInt("posted"));
				twt.get(i).setStart_date(rs.getString("start_date"));
				twt.get(i).setEnd_date(rs.getString("end_date"));
				twt.get(i).setPost_time(rs.getString("post_time"));
				i++;
			}
				
			//DBコネクション切断
			DBM.closeConnection();
			
		}catch(Exception e){
			System.err.println("error");
		}
		
		return twt;
		
	}
	

}
