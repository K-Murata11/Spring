package jp_co.good_works.lesson.springmvc.dao;

import java.sql.*;

public class LoginDao {
	public static ResultSet connection(String sqlStr) {
		String url = "jdbc:mysql://localhost/lesson20xx?useSSL=false";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			rs = st.executeQuery(sqlStr);
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
