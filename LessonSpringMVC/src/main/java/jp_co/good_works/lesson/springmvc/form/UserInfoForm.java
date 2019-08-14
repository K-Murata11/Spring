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

	// @Email�Łuxxxxx@xxxxx�v�̏������̃o���f�[�V�������`�ł���
	@Email
	private String email;

	private String birthplace;

	private List<String> favoriteLangs;

	private String texts;
	
	
	
	/* 
	 * Getter/Setter���\�b�h��private�ϐ����`���Ă���A
	 * �uSource�v���uGenerate Getters and Setters�v
	 * �̋@�\�𗘗p����ƊԈႢ�Ȃ���`���邱�Ƃ��o����I�I�I
	 * �i�䒃�m���Č��ŕK����DTO����蒼���Ă�����J��Ԃ��j
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
