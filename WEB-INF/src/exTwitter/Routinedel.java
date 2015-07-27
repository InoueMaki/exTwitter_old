package exTwitter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Routinedel extends HttpServlet{

	@Override
	protected void doPost( HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
	
		//入力エンコーディングの指定
		request.setCharacterEncoding("UTF-8");
		
		//セッションの取得
		HttpSession session = request.getSession();
		
		//入力情報を取得
		int routineID = Integer.parseInt(request.getParameter("del"));
		
		//DB接続の準備
		DBManager DBM = new DBManager();
		DBM.getConnection();
		
		//postedを1に変更(検索にひっかからなくするため)
		String qry = "UPDATE routine SET posted = 1 where routine_id = "+ routineID;
		int count = DBM.exeUpdate(qry);
		
		System.out.println(count);
		
		//接続クローズ
		DBM.closeConnection();
		
		//ここから遷移したことを知らせるフラグ
		int flg=2;
		session.setAttribute("flg", flg);
		
		//画面遷移
		RequestDispatcher rdisp = request.getRequestDispatcher("Routine");
		rdisp.forward(request, response);
	}
}
