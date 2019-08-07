package jp_co.good_works.lesson.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// コントローラーとして使用することを宣言
// MVCモデルで作成しているので今回は記載必須
@Controller
public class HelloController {

	// helloとアクセスされたら下記メソッドが実行される（大文字小文字は区別される）
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
		public String hello(Model model) {
		// modelっという箱にmessageという名前で Hello Spring! という文字列を格納している
		model.addAttribute("message", "Hello Spring!" );
		// hello.jspへ遷移する（大文字小文字は区別される）
		return "hello";
	}

}
