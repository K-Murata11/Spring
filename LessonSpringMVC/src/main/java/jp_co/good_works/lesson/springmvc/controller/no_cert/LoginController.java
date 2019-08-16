package jp_co.good_works.lesson.springmvc.controller.no_cert;

import java.util.ArrayList;
import java.util.List;

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

@Scope("session")
@Controller
public class LoginController {

	private LoginLogic loginLogic = new LoginLogic();
	LoginForm form = new LoginForm();

	public boolean isLive() {
		return loginLogic.isLive();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initializeLoigin(Model model) {
		model.addAttribute("loginForm", form);
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String exeuteLoigin(Model model, @Validated @ModelAttribute LoginForm form,
			BindingResult result, RedirectAttributes redirectAttribute) {
		// バリデーションの結果エラーにならなかったとき
		if(!result.hasErrors()) {
			try {
				loginLogic.login(form.getUserId(), form.getPassword());
				// RedirectAttributes で redirect の遷移先を設定することができる
				return "redirect:/hello";
			} catch (LoginException ex) {
				model.addAttribute("message", ex.getLocalizedMessage());
			}
		} else {
			model.addAttribute("message", "ユーザーID、パスワードを入力してください。");
		}
		return "login";
	}


}
