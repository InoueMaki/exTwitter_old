package exTwitter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 	単発ツイートを削除するサーブレット
 */
public class OnceDel extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	//シリアルID
	private String qry;	//クエリ格納用
	
	/**
	 * postメソッド
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		System.out.println("onceDelが呼ばれた");	//デバッグ用
		HttpSession session = request.getSession(false);	//セッション取得
		if(session == null){	//セッション切れの場合、Controlサーブレットに遷移
			RequestDispatcher dispatch = request.getRequestDispatcher("Control");
			dispatch.forward(request , response);
			return;
		}
		
		request.setCharacterEncoding("UTF-8");	//エンコード:UTF-8
		request.setAttribute("単発削除",1);	//Nameが単発削除の要素をリクエスト属性に追加（数値の1に意味はない、単発削除画面から遷移したことを遷移先に知らせる）
		Enumeration<?> names = request.getParameterNames();	//リクエスト属性のNameを一気に取得（JSPのテーブルのname（=once_id）が１つ来るはず）
		String once_id = new String();	//once_id格納用
		
		while (names.hasMoreElements()){
		      once_id = (String)names.nextElement();	//once_idを取得
		}
		qry = "update once set posted = 1 where once_id = " + once_id + ";" ;	//取得したonce_idでクエリ作成
		System.out.println(qry);	//デバッグ用
		if(updateDB(qry))	session.setAttribute("delflg", 1);	//TBL更新に成功した場合　フラグを成功に
		else	session.setAttribute("delflg", -1);	//失敗した場合　フラグを失敗に
		RequestDispatcher rdisp = request.getRequestDispatcher("Control");
		rdisp.forward(request, response);	//Controlサーブレットに遷移
	}
	
	/**
	 * DBに接続してTBLを更新する
	 * @param qry（TBLを更新するためのクエリ）
	 * @return boolean
	 */
	private boolean updateDB(String qry){
		DBManager DBM = new DBManager();	//DB接続クラス
		int inCount = DBM.exeUpdate(qry);	//DBにUPDATE文を送る（戻り値はUPDATEした行数）
		if(inCount == 0){	//なにもUPDATEしてない
			return false;
		}
		else{
			return true;
		}
	}
}
