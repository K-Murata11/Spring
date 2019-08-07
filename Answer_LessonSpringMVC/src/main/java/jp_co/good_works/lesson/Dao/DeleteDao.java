package jp_co.good_works.lesson.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDao extends OrignalDao{
	/*------------削除メソッド---------------*/
	public void darete(int userID) throws SQLException{
		String quary = "delete from user_table where user_id = ?";
		pst = cnct.prepareStatement(quary);
		pst.setInt(1,userID);
		pst.executeUpdate();
		super.close();
		
	}
}
