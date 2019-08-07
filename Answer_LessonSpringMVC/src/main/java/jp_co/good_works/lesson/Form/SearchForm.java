package jp_co.good_works.lesson.Form;
import java.sql.Time;

public class SearchForm {

	private int user_id;
	private String user_name;
	private String user_mail;
	private String user_pass;
	private int admin;
	private Time create_date;
	private String last_update;
	private String sqlLike;
	private int userCount;

	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public String getSqlLike() {
		return sqlLike;
	}
	public void setSqlLike(String sqlLike) {
		this.sqlLike = sqlLike;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public Time getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Time create_date) {
		this.create_date = create_date;
	}

}
