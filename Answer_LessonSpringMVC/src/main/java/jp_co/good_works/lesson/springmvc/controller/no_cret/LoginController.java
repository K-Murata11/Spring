package jp_co.good_works.lesson.springmvc.controller.no_cret;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.lesson.springmvc.form.LoginForm;
import jp_co.good_works.lesson.springmvc.logic.LoginLogic;

//private String userID;
//private String password;

@Controller
@Scope("session")
public class LoginController {

	private LoginLogic loginLogic = new LoginLogic();


	public boolean isLive() {
		return loginLogic.isLive();
	}



	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String initializeLogin(Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("message","入力してください");
		model.addAttribute("loginForm",form);
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String executeLogin(Model model , @Validated @ModelAttribute LoginForm form,
			BindingResult result,RedirectAttributes redirectAttr) throws SQLException {
		if(!result.hasErrors()) {
			try {
				loginLogic.login(form.getUserID(),form.getPassword());
				return "redirect:/hello";
				
			} catch (LoginException e) {
				model.addAttribute("message",e.getLocalizedMessage());
			}
		}else{
			System.out.println("確認");
			model.addAttribute("message","ユーザID、パスワードを入力してください。");
		}
		
		return "login";
	}
	
	
	
	
}