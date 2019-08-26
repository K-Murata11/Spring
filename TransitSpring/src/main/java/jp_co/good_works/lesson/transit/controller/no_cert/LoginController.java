package jp_co.good_works.lesson.transit.controller.no_cert;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.lesson.transit.form.LoginForm;
import jp_co.good_works.lesson.transit.form.UserInfoForm;
import jp_co.good_works.lesson.transit.logic.LoginLogic;

@Scope("session")
@Controller
public class LoginController {

	private LoginLogic sqlLogic = new LoginLogic();
	LoginForm form = new LoginForm();

	public boolean isLive() {
		return sqlLogic.isLive();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initializeLoigin(Model model) {
		model.addAttribute("message", "ユーザーID、パスワードを入力してください。");
		model.addAttribute("loginForm", form);
		return "login";
	}
	
	@Autowired
	protected UserInfoForm userInfoForm;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String exeuteLoigin(Model model, @Validated @ModelAttribute LoginForm form,
			BindingResult result, RedirectAttributes redirectAttribute) {
		if(!result.hasErrors()) {
			try {
				LoginForm loginInfo = sqlLogic.login(form.getUserId(), form.getPassword());
				// RedirectAttributes で redirect の遷移先を設定することができる
				userInfoForm.setUserName(loginInfo.getUserId());
				return "redirect:/search";
			} catch (LoginException e) {
				model.addAttribute("message", e.getLocalizedMessage());
			}
		} else {
			model.addAttribute("message", "ユーザーID、パスワードを入力してください。");
		}
		return "login";
	}


}
