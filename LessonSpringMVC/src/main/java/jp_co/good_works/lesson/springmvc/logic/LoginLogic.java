package jp_co.good_works.lesson.springmvc.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import jp_co.good_works.lesson.springmvc.dao.LoginDao;

public class LoginLogic {

	private LoginInfo loginInfo = null;

	public LoginInfo login(String userId, String password) throws LoginException {

		String sql ="SELECT * FROM user_spring;";
		ResultSet rs =LoginDao.connection(sql);

		//jspNameをDBで検索して、DBでのlogin_pwを取得する
		try {
			while(rs.next()) {
				String dbName = rs.getString("USERID");
				String dbPw = rs.getString("PASSWORD");
				
				if (dbName.equals(userId) && dbPw.equals(password)) {
					loginInfo = new LoginInfo();
					loginInfo.setUserId(userId);
					loginInfo.setPassword(password);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(loginInfo != null) {
			return loginInfo;
		} else {
			loginInfo = null;
			throw new LoginException("ユーザ ID、またはパスワードが違います");
		}
	}

	public boolean isLive() {
		if(loginInfo != null) {
			return true;
		} else {
			return false;
		}
	}

}
