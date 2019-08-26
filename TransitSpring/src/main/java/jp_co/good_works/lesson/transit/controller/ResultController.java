package jp_co.good_works.lesson.transit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.transit.form.LoginForm;
import jp_co.good_works.lesson.transit.form.ResultForm;
import jp_co.good_works.lesson.transit.form.SearchForm;

@Controller
public class ResultController {
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(Model model) {
		ResultForm form = new ResultForm();
		model.addAttribute("resultForm", form);
		return "result";
	}
	
}
