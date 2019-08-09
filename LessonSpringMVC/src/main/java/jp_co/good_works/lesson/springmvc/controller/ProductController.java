package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

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
	public String product(Model model, @Validated @ModelAttribute ProductForm form, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("message", "エラーを検出しました");
		} else {
			model.addAttribute("message", "商品が入力されました");
			productList.add(form);
		}
		model.addAttribute("productForm", form);
		model.addAttribute("productList", productList);
		return "product";
	}
}
