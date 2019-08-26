package jp_co.good_works.lesson.transit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailController {
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model) {
		return "detail";
	}
}
