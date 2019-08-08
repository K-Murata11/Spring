package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.springmvc.form.ProductForm;

@Scope("session")
@Controller
public class ProductController {

	ProductForm form = new ProductForm();
	private ArrayList<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		model.addAttribute("message", "商品を入力してください");
		model.addAttribute("productForm", form);

		return "product";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product(Model model, @ModelAttribute ProductForm form) {
		if (form.getName () == null || form.getPrice () == null) {
			model.addAttribute("message", "商品情報が空です");
		} else {
			model.addAttribute("message", "商品が入力されました");
			productList.add(form);
		}
		model.addAttribute("productForm", form);
		model.addAttribute("productList", productList);
		return "product";
	}
}
