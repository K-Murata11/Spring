
package jp_co.good_works.lesson.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*-------------DB接続処理----------------*/
public class OrignalDao {

	Connection cnct = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public OrignalDao(){
		
		String url ="jdbc:mysql://localhost/lesson2018";
		String id ="root";
		String pass ="password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct= DriverManager.getConnection(url,id,pass);
			System.out.println("----------------接続完了----------------");
			//st = cnct.createStatement();


		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("クラスが見つかりません");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("接続失敗");
		}


	}

/*-------------DB切断処理----------------*/
	public void close() throws SQLException {
		if(cnct!=null) cnct.close();
		if(rs!=null)rs.close();
		if(pst!=null)pst.close();
		if(st!=null)st.close();
		System.out.println("----------------接続終了----------------");
	}
}

