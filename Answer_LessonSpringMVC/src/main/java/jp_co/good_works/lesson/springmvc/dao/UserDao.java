package jp_co.good_works.lesson.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import jp_co.good_works.lesson.springmvc.form.LoginForm;
import jp_co.good_works.lesson.springmvc.logic.LoginInfo;

public class UserDao {


public LoginInfo select(String userID,String password) throws SQLException {
	LoginForm loginForm = new LoginForm();
	LoginInfo loginInfo = null;//new LoginInfo();
	String url ="jdbc:mysql://localhost/lesson2018";
	String id ="root";
	String pass ="password";
	java.sql.Connection cnct = null;
	java.sql.Statement st = null;
	java.sql.ResultSet rs = null;
	java.sql.PreparedStatement pst = null;

	
	try {
		

		
		Class.forName("com.mysql.jdbc.Driver");
		cnct= DriverManager.getConnection(url,id,pass);
		System.out.println("接続完了");
		//st = cnct.createStatement();
		
		String quary = "select * from user where userID = ? and password = ?";
		pst = cnct.prepareStatement(quary);
		pst.setString(1,userID);
		pst.setString (2,password);
		rs = pst.executeQuery();
		//rs = st.executeQuery("SELECT * from user where userID="+userID);
		if(rs.next()) {
			loginInfo = new LoginInfo();
			loginInfo.setUserID(userID);
			loginInfo.setUserID(password);
//			String user = rs.getString("userID");
//			
//			String passWord = rs.getString("password");
//			loginInfo.setUserID(passWord);
//			System.out.println("ID:"+user+"PW:"+passWord);
//			if(user.equals(userID)&&password.equals(password)) {
			}else {
	
			}
		
	} catch (ClassNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
		System.out.println("クラスが見つかりません");
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
		System.out.println("接続失敗");
	}finally {
		if(cnct!=null) cnct.close();
		if(rs!=null)rs.close();
		if(pst!=null)pst.close();
		if(st!=null)st.close();
	}
	return loginInfo;
}
}


