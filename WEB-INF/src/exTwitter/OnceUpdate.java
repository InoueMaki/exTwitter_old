package exTwitter;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * onceTBL更新用サーブレット
 **/
public class OnceUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	//シリアルID
	private String qry;	//onceTBLを更新するためのクエリ格納用
	private final String qry1 = "select once_id from numbering;" ;		//採番TBLから値とってくるためのクエリ
	private final String qry2 = "update numbering set once_id = once_id + 1" ;	//採番TBLの更新クエリ
	
	/**
	 * postメソッド
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		System.out.println("onceUpdateが呼ばれた");	//デバッグ用
		HttpSession session = request.getSession(false);	//セッション取得
		request.setCharacterEncoding("UTF-8");	//エンコード:UTF-8
		RequestDispatcher dispatch = request.getRequestDispatcher("Control");	//必ずControlに遷移する

		if(session == null){	//セッション切れ
			dispatch.forward(request , response);	//そのままControlに遷移
			return;
		}

		DBManager DBM = new DBManager();
		String check[] = request.getParameterValues("chk1");	//JSPのチェックボックスのチェック状況を取得
		int once_id = selectDB(qry1,DBM);	//採番TBLから次のonce_idの取得
		request.setAttribute("単発",1);	//Nameが単発削除の要素をリクエスト属性に追加（数値の1に意味はない、単発ツイート画面から遷移したことを遷移先に知らせる）
		
		if(once_id == -1){	//採番TBLからonce_idの取得に失敗
			session.setAttribute("onceflg", -1);	//失敗した情報をセッションに追加（ダイアログ表示用の値）
			dispatch.forward(request , response);	//遷移
			return;
		}else{
			if(updateDB(qry2,DBM) == false){	//採番TBL更新に失敗
				session.setAttribute("onceflg", -1);	//失敗した情報をセッションに追加（ダイアログ表示用の値）
				dispatch.forward(request , response);	//遷移
				return;
			}
		}
		
		qry = createQry(request , check, once_id);	//クエリを作成する
		
		if(updateDB(qry,DBM)){
			DBM.closeConnection();	//コネクション切断
			session.setAttribute("onceflg", 1);	//onceTBL更新に成功した場合、成功した情報をセッションに追加（ダイアログ表示用の値）
		}
		else	session.setAttribute("onceflg", -1);	//失敗した場合、失敗した情報をセッションに追加
		dispatch.forward(request, response);	//遷移
	}
	
	private boolean updateDB(String qry,DBManager DBM){
		int inCount = DBM.exeUpdate(qry);	//DBにUPDATE文を送る（戻り値はUPDATEした行数);
		if(inCount == 0){	//なにもUPDATEしてない
			DBM.closeConnection();	//コネクション切断
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * セレクト文をDBに送信し結果を受け取る
	 * @param qry：DBに問い合わせるためのクエリ
	 * @return once_id：DBから問い合わせたonce_id
	 */
	private int selectDB(String qry,DBManager DBM){
		
		ResultSet rs = DBM.getResultSet(qry);	//クエリ	
		int once_id = -1;	//失敗したときに-1を返すようにする
		
		try{
			while(rs.next()){
					once_id = rs.getInt("once_id");	//once_idを取得
			}
			System.out.println("id:"+once_id);	//デバッグ用
		}
		catch(Exception e){
			System.err.println("select_error");	//例外をキャッチした場合出力
		}
		if(once_id == -1)	DBM.closeConnection();	//コネクション切断
		return once_id;	//取得したonce_idを返す
	}
	
	/**
	 * DBに問い合わせるクエリを作成するメソッド
	 * @param request
	 * @param check
	 * @param once_id
	 * @return qry：DBに問い合わせするために作成したクエリ
	 */
	private String createQry(HttpServletRequest request,String[] check, int once_id){
		String qry;
		String text = request.getParameter("text");	//text（ツイートする文）は必ず使用するため取得
		if(check!=null){	//チェックがあった場合（時間指定する）
			//時間指定した年月日、時刻を取得
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String hour = request.getParameter("hour");
			String minute = request.getParameter("minute");
			//ここまで
			
			String reserve_time = year + "-" + month + "-" + day +" " + hour + ":" + minute + ":00";
			qry = new String("insert into once values (" + once_id + ", '" + text + "', '" + reserve_time + "', " + 0 + " ); ");
			System.out.println(qry);	//デバッグ用
		}
		else{	//時間指定しない場合、現在時刻を時間指定しDBにデータを登録
	        Date date = new Date();
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    System.out.println(sdf1.format(date));
			qry = new String("insert into once values (" + once_id + ", '" + text + "' , '" + sdf1.format(date) + "' , " + 0 + " ); ");
			System.out.println(qry);
		}
		return qry;
	}
}
