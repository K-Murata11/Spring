package jp_co.good_works.lesson.springmvc.form;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.util.List;

public class UserInfoForm {

	@NotEmpty
	private String name;

	@NotNull
	@Min(value = 20)
	private Integer age;

	private String gender;

	// @Emailで「xxxxx@xxxxx」の書き方のバリデーションを定義できる
	@Email
	private String email;

	private String birthplace;

	private List<String> favoriteLangs;

	private String texts;
	
	
	
	/* 
	 * Getter/Setterメソッドはprivate変数を定義してから、
	 * 「Source」→「Generate Getters and Setters」
	 * の機能を利用すると間違いなく定義することが出来る！！！
	 * （御茶ノ水案件で必死にDTOを作り直していた苦労を返せ）
     */ 
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public List<String> getFavoriteLangs() {
		return favoriteLangs;
	}

	public void setFavoriteLangs(List<String> favoriteLangs) {
		this.favoriteLangs = favoriteLangs;
	}


	public String getTexts() {
		return texts;
	}

	public void setTexts(String texts) {
		this.texts = texts;
	}

}
