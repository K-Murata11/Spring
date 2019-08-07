package jp_co.good_works.lesson.Form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateForm {
	private int user_id;
	@NotEmpty
	@Size(min = 1,max = 20)
	private String user_name;
	@NotEmpty
	private String user_mail;
	@NotEmpty
	@Size(min = 1,max = 20)
	private String user_pass;
	private int admin;
	
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
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}


}
