package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.springmvc.form.UserInfoForm;

@Controller
@Scope("session")
public class UserInfoController {
	List<UserInfoForm> userInfoFormList = new ArrayList<UserInfoForm>();
	@RequestMapping(value="/userinfo", method = RequestMethod.GET)
	public String userInfo(Model model) {

		UserInfoForm form = new UserInfoForm();
		List<String> genders = new ArrayList<String>();
		List<String> birthplace = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		model.addAttribute("userInfoFormList",userInfoFormList);
		
		genders.add("íj");
		genders.add("èó");
		model.addAttribute("genders",genders);

		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		model.addAttribute("favoriteLang",favoriteLangs);

		birthplace.add("");
		birthplace.add("ñkäCìπ");
		birthplace.add("ìåñk");
		birthplace.add("ä÷ìå");
		birthplace.add("íÜïî");
		birthplace.add("ãﬂãE");
		birthplace.add("íÜçë");
		birthplace.add("élçë");
		birthplace.add("ã„èB");
		model.addAttribute("birthplace",birthplace);

		model.addAttribute("massage","ì¸óÕÇµÇƒÇ≠ÇæÇ≥Ç¢");
		model.addAttribute("userInfoForm",form);
		return "userinfo";
	}

	@RequestMapping(value ="/userinfo" , method = RequestMethod.POST)
	public String userInfo(Model model ,@Validated @ModelAttribute UserInfoForm form , BindingResult result) {
		List<String> genders = new ArrayList<String>();
		List<String> birthplace = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		genders.add("íj");
		genders.add("èó");
		model.addAttribute("genders",genders);

		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		model.addAttribute("favoriteLang",favoriteLangs);

		birthplace.add("");
		birthplace.add("ñkäCìπ");
		birthplace.add("ìåñk");
		birthplace.add("ä÷ìå");
		birthplace.add("íÜïî");
		birthplace.add("ãﬂãE");
		birthplace.add("íÜçë");
		birthplace.add("élçë");
		birthplace.add("ã„èB");
		model.addAttribute("birthplace",birthplace);
		if(result.hasErrors()) {
			System.out.println("----------------");
			System.out.println(result.getObjectName());
			System.out.println("----------------");
			
		}else {
			model.addAttribute("massage","ì¸óÕÇ≥ÇÍÇ‹ÇµÇΩ");
			userInfoFormList.add(form);
		}

		model.addAttribute("userInfoFormList",userInfoFormList);
		model.addAttribute("userInfoForm",form);
		return "userinfo";

	}
}
