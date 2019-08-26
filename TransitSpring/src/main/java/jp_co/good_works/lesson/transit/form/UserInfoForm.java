package jp_co.good_works.lesson.transit.form;

import java.io.Serializable;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfoForm implements Serializable {

      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
      
}