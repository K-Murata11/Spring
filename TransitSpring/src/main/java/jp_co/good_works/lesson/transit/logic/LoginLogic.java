package jp_co.good_works.lesson.transit.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import jp_co.good_works.lesson.transit.dao.TransitDao;
import jp_co.good_works.lesson.transit.exception.SearchException;
import jp_co.good_works.lesson.transit.form.LoginForm;
import jp_co.good_works.lesson.transit.form.SearchForm;

public class LoginLogic {

	private LoginForm loginInfo = null;
	public LoginForm login(String userId, String password) throws LoginException {

		String sql ="SELECT * FROM userInfo;";
		ResultSet rs =TransitDao.connection(sql);

		//jspName��DB�Ō������āADB�ł�login_pw���擾����
		try {
			while(rs.next()) {
				String dbName = rs.getString("userId");
				String dbPw = rs.getString("password");

				if (dbName.equals(userId) && dbPw.equals(password)) {
					loginInfo = new LoginForm();
					loginInfo.setUserId(userId);
					loginInfo.setPassword(password);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		if(loginInfo != null) {
			return loginInfo;
		} else {
			loginInfo = null;
			throw new LoginException("���[�U�[ID�A�܂��̓p�X���[�h���Ⴂ�܂�");
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
