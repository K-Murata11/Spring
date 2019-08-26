package jp_co.good_works.lesson.transit.dao;

import java.sql.*;

public class TransitDao {
	public static ResultSet connection(String sqlStr) {
		String url = "jdbc:mysql://localhost/transitSpring";
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
