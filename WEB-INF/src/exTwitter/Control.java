package exTwitter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Control extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException,IOException{
		System.out.println("controlが呼ばれた");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		
		//セッションチェック
		HttpSession session = request.getSession(false);

		//ページ内のname属性をArrayListに格納
		Enumeration<String> em = request.getParameterNames();
		ArrayList<String> lst = new ArrayList<String>();	
		while(em.hasMoreElements()){
			String name = em.nextElement();
			lst.add(name);
		}
			
		PrintWriter out = response.getWriter();
		
		//ログイン
		if(lst.contains("login")){
			User user = new User();
			Boolean auth = false;
			//ユーザ名・パスワード照合
			try{
				String user_name = request.getParameterValues("user_name")[0];
				String password  = request.getParameterValues("password" )[0];
				
				auth = user.checkUser(user_name, password);
			}catch (Exception e){
				System.err.println("ログイン照合できません");
			}
			//ユーザ名とパスワードが一致
			if(auth){
				session = request.getSession(true);
				session.setAttribute("user", "user");
				response.sendRedirect("menuUI.jsp");
			}
			//一致しない
			else{
				request.setAttribute("err","ユーザ名とパスワードが一致しません");
				RequestDispatcher rdisp = request.getRequestDispatcher("loginUI.jsp");
				rdisp.forward(request, response);
			}
		}
		//ログアウト
		else if (lst.contains("ログアウト")){
			response.sendRedirect("Logout");
		}
		//jsp画面からのセッション切れ
		else if (null==session || null==session.getAttribute("user")){
			RequestDispatcher rdisp = request.getRequestDispatcher("redirect.jsp");
			rdisp.forward(request, response);
		}
		//画面遷移
		else{
	
			if (lst.contains("メニュー")){
				response.sendRedirect("menuUI.jsp");
			}
			else if (lst.contains("単発")||request.getAttribute("単発")!=null){
				request.setAttribute("onceURL", "OnceUI.jsp");
				RequestDispatcher rdisp = request.getRequestDispatcher("Once");
				rdisp.forward(request, response);
			}
			else if (lst.contains("定期")){
				RequestDispatcher dispatcher = 	request.getRequestDispatcher("Routine");
				dispatcher.forward(request, response);
			}
			else if (lst.contains("定期登録")){
				RequestDispatcher dispatcher = 	request.getRequestDispatcher("RoutineUpdate");
				dispatcher.forward(request, response);
			}
			else if (lst.contains("単発削除")||request.getAttribute("単発削除")!=null){
				request.setAttribute("onceURL", "OnceDelUI.jsp");
				RequestDispatcher rdisp = request.getRequestDispatcher("Once");
				rdisp.forward(request, response);
			}
			else if (lst.contains("定期削除")){
				RequestDispatcher rdisp = request.getRequestDispatcher("RoutinedelUI.jsp");
				rdisp.forward(request, response);
			}
			else if(lst.contains("定期削除servlet")){
				RequestDispatcher rdisp = request.getRequestDispatcher("Routinedel");
				rdisp.forward(request, response);
			}
			else{
				out.println("正常処理が行われませんでした。\nブラウザバックによりもどったのちログアウトしてください");
			}
		
			
		}
	}
	
	//Servlet,JSP(METHOD:GET)
	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		
		//セッションチェック
		HttpSession session = request.getSession(false);

		Enumeration<String> em = request.getParameterNames();
		ArrayList<String> lst = new ArrayList<String>();
			
		//ページ内のname属性をArrayListに格納
		while(em.hasMoreElements()){
			String name = em.nextElement();
			lst.add(name);
			//System.err.println(name);
		}
			
		PrintWriter out = response.getWriter();
		
		//Servletからのセッション切れ（Logout.java）
		if (null==session || null==session.getAttribute("user")){
			response.sendRedirect("loginUI.jsp");
		}
		//画面遷移
		else{
	
			if (lst.contains("メニュー")){
				response.sendRedirect("menuUI.jsp");
			}
			else if (lst.contains("単発")){
				out.println("単発");
			}
			else if (lst.contains("定期")){
				out.println("定期");
			}
		
			
		}
	}
	
}
