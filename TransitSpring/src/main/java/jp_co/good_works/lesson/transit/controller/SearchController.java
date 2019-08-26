package jp_co.good_works.lesson.transit.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.transit.dao.TransitDao;
import jp_co.good_works.lesson.transit.exception.SearchException;
import jp_co.good_works.lesson.transit.form.LoginForm;
import jp_co.good_works.lesson.transit.form.SearchForm;
import jp_co.good_works.lesson.transit.form.UserInfoForm;
import jp_co.good_works.lesson.transit.logic.SearchLogic;

@Scope("session")
@Controller
public class SearchController {
	
	@Autowired
	protected UserInfoForm userInfoForm;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, Locale locale) {
		SearchForm form = new SearchForm();

		List<String> startEnd = new ArrayList<String>();
		startEnd.add("出発");
		startEnd.add("到着");
		model.addAttribute("startEnd", startEnd);

		model.addAttribute("searchForm", form);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String nowDateTime = dateFormat.format(date);
		String nowDate = nowDateTime.substring(0, 10).replaceAll("/", "-");
		String nowTime = nowDateTime.substring(11, 16);
		
		model.addAttribute("nowDateTime", nowDateTime);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("nowTime", nowTime);
		
		model.addAttribute("message", "ようこそ、" + userInfoForm.getUserName() + " 様");
		
		return "search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, @Validated @ModelAttribute SearchForm form, BindingResult result, Locale locale) {
		ArrayList<SearchForm> searchInfoList = new ArrayList<SearchForm>();

		if (!result.hasErrors()) {
			model.addAttribute("message", "情報が入力されました");
			try {
				SearchLogic sqlLogic = new SearchLogic();
				searchInfoList = sqlLogic.search(form);
				model.addAttribute("searchInfoList", searchInfoList);
				return "result";
			} catch (SearchException e) {
				model.addAttribute("message", e.getLocalizedMessage());
				
			}
		} else {
		}
		model.addAttribute("searchInfoList", searchInfoList);

		List<String> startEnd = new ArrayList<String>();
		startEnd.add("出発");
		startEnd.add("到着");
		model.addAttribute("startEnd", startEnd);

		model.addAttribute("searchForm", form);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String nowDateTime = dateFormat.format(date);
		String nowDate = nowDateTime.substring(0, 10).replaceAll("/", "-");
		String nowTime = nowDateTime.substring(11, 16);
		
		model.addAttribute("nowDateTime", nowDateTime);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("nowTime", nowTime);
		
		model.addAttribute("message", "ようこそ、" + userInfoForm.getUserName() + " 様");
		
		return "search";
		}
	

	@RequestMapping(value = "/search", params="back", method = RequestMethod.POST)
	public String back(Model model) {
		ArrayList<SearchForm> searchInfoList = new ArrayList<SearchForm>();
		model.addAttribute("searchInfoList", searchInfoList);
		return "redirect:/search";
	}

	@RequestMapping(value = "/search", params="logout", method = RequestMethod.POST)
	public String logout(Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("loginForm", form);
		return "redirect:/login";
	}
}
