package exTwitter;

import java.io.*;
//import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * 	単発ツイート画面または削除画面に遷移する前に単発ツイート情報を格納するためのサーブレット
 */
public class Once extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	//シリアルID
	private static final String qry = "select * from once where posted = 0 order by reserve_time;";	//MySQLのクエリ、
	public static ArrayList<OnceBean> onceList;	//DB情報格納クラスを格納するリスト
	
	@Override
	/**
	 *	postメソッド 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("onceが呼ばれた");	//デバッグ用コメント
		HttpSession session = request.getSession(false);	//セッション取得
		if(session == null ){ //セッション切れ
			response.sendRedirect("Control");	//Controlサーブレットに遷移
			return;
		}
		else{	//セッション有り
			addOnceList();	//onceList更新
			String URL = (String) request.getAttribute("onceURL");	//遷移先URLを取得
			if(URL == null){	//遷移先がrequestにない場合（初回アクセス時）
				response.sendRedirect("OnceUI.jsp");	//OnceUIに遷移
				return;
			}
			else{	//遷移先URLを取得できた場合
				System.out.println(URL);	//デバッグ用コメント
				response.sendRedirect(URL);	//指定のURLに画面遷移
				return;
			}
		}
	}
	
	/**
	 * onceList（DB情報格納クラスを格納するリスト）にDB情報を格納するメソッド
	 */
	static void addOnceList(){
		try {
			onceList = new ArrayList<OnceBean>();	//onceListを初期化
			DBManager DBM = new DBManager();	//DB接続クラスのインスタンス
			ResultSet rs = DBM.getResultSet(qry);	//クエリを投げた結果のResultSet取得
			
			while(rs.next()){	//resultSetの最後まで繰り返す
				OnceBean data = new OnceBean();	//DB情報格納クラス
				data.setOnceId(rs.getInt("once_id"));	//once_idの取得
				data.setReserveTime(rs.getTimestamp("reserve_time"));	//reserve_timeの取得
				data.setPosted(rs.getInt("posted"));	//postedの取得
				String text = rs.getString("text");
				data.setText(text);	//textの取得
				onceList.add(data);	//Listに要素追加
			}
			DBM.closeConnection();
	
		}catch(Exception e){
			System.err.println("failure");
		}
	}
	
}
