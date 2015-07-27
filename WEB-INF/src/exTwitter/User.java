package exTwitter;

import java.sql.ResultSet;

public class User {
	public Boolean checkUser(String user_name, String password) {
		Boolean bool = false;
		// セレクト文クエリ生成
		String qry = "SELECT * from user where " + "(user_name = '" + user_name
				+ "' " + "&& password = '" + password + "')";
		try {
			// DB接続
			DBManager DBM = new DBManager();
			DBM.getConnection();
			ResultSet rs = DBM.getResultSet(qry);
			// 該当ユーザ存在
			if (rs.next()) {
				bool = Boolean.TRUE;
			}
			// コネクション切断
			rs.close();
			DBM.closeConnection();
		} catch (Exception e) {
			System.err.println("User Check Error");
		}
		return bool;
	}

	// 以下サンプル
	public static void main(String[] args) {
		User us = new User();
		if (us.checkUser("root", "root")) {
			System.out.println("いたぞ！やつだ！！");
		} else {
			System.err.println("...なかにだれもいませんよ");
		}

	}

}
