package jp_co.good_works.lesson.Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import jp_co.good_works.lesson.Form.SearchForm;

public class SearchDao extends OrignalDao{
	/*--------------------全ユーザ表示メソッド--------------------------*/
	public ArrayList<SearchForm> allSearch() throws SQLException {
		ArrayList<SearchForm> searchList = new ArrayList<SearchForm>();
		String quary = "select * from user_table";
		st = cnct.createStatement();
		rs = st.executeQuery(quary);

		while(rs.next()) {
			SearchForm searchForm = new SearchForm();
			int userid = rs.getInt("user_id");
			searchForm.setUser_id(userid);
			System.out.println(userid);
			String name = rs.getString("user_name");
			searchForm.setUser_name(name); 
			System.out.println(name);
			String Email = rs.getString("user_mail");
			searchForm.setUser_mail(Email); 
			System.out.println(Email);
			String password = rs.getString("user_pass");
			System.out.println(password);
			searchForm.setUser_pass(password); 
			Time createdate = rs.getTime("created_date");
			System.out.println(createdate);
			searchForm.setCreate_date(createdate); 
			String lastupdate = rs.getString("last_updated");
			System.out.println(lastupdate);
			searchForm.setLast_update(lastupdate);
			int admin = rs.getInt("admin");
			searchForm.setAdmin(admin);
			System.out.println(admin);
			searchList.add(searchForm);
		}
		super.close();
		return searchList;
	}
	/*--------------------ユーザ検索メソッド--------------------------*/
	public ArrayList<SearchForm> search(String sqlLike) throws SQLException {
		//searchListがnullのままの場合、該当ユーザなし
		ArrayList<SearchForm> searchList = new ArrayList<SearchForm>();
		boolean flg = false ;
		//正しく検索or正しく検索空欄のまま検索
		if(!(sqlLike.equals(""))) {
			//Like文 実行用String変数
			String sql = "%"+sqlLike+"%";
			String quary = "select * from user_table where user_name like ?";
			pst = cnct.prepareStatement(quary);
			pst.setString(1,sql);
			rs = pst.executeQuery();
				while(rs.next()) {
					SearchForm searchForm = new SearchForm();
					int userid = rs.getInt("user_id");
					searchForm.setUser_id(userid); 
					String name = rs.getString("user_name");
					searchForm.setUser_name(name); 
					String Email = rs.getString("user_mail");
					searchForm.setUser_mail(Email); 
					String password = rs.getString("user_pass");
					searchForm.setUser_pass(password); 
					Time createdate = rs.getTime("created_date");
					searchForm.setCreate_date(createdate); 
					String lastupdate = rs.getString("last_updated");
					searchForm.setLast_update(lastupdate); 
					searchList.add(searchForm);
					flg = true;
				}
		}
		/*---flg=falseだった場合、該当ユーザなし---*/
		if(flg==false) searchList = null;
		super.close();
		return searchList;
	}
}

