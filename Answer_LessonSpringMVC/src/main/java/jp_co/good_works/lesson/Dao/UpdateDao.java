
package jp_co.good_works.lesson.Dao;

import java.sql.SQLException;

public class UpdateDao extends OrignalDao{

	public void update(int userId,String name ,String userMail,String userPass ) throws SQLException {
		String quary = "update user_table set user_name = ?,user_pass = ?,user_mail = ? where user_id = ?";
		pst = cnct.prepareStatement(quary);
		pst.setString(1,name);
		pst.setString(2,userPass);
		pst.setString(3,userMail); 
		pst.setInt(4,userId); 
		pst.executeUpdate();
		super.close();
		}
	/*----------------ユーザ登録の際、管理者権限にする事が出来るメソッド(セッションンにあるadmin情報を引数として受取)----------------*/
	public void update(int userId,int admin,String name ,String userMail,String userPass ) throws SQLException {
			String quary = "update user_table set user_name = ?,user_pass = ?,user_mail = ? admin = ? where user_id = ?";
			pst = cnct.prepareStatement(quary);
			pst.setString(1,name);
			pst.setString(2,userPass);
			pst.setString(3,userMail); 
			pst.setInt(4,userId); 
			pst.executeUpdate();
			super.close();
	}
}

