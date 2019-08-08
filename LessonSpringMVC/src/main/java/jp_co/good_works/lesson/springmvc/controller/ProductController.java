package jp_co.good_works.lesson.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.springmvc.form.ProductForm;

@Controller
public class ProductController {

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		ProductForm form = new ProductForm();
		model.addAttribute("message", "è§ïiÇì¸óÕÇµÇƒÇ≠ÇæÇ≥Ç¢");
		model.addAttribute("productForm", form);

		return "product";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product(Model model, @ModelAttribute ProductForm form) {
		model.addAttribute("message", "è§ïiÇ™ì¸óÕÇ≥ÇÍÇ‹ÇµÇΩ");
		model.addAttribute("productForm", form);

		return "productResult";
	}

}
