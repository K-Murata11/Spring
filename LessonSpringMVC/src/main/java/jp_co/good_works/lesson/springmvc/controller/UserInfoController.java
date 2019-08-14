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

@Scope("session")
@Controller
public class UserInfoController {

	UserInfoForm form = new UserInfoForm();
	private ArrayList<UserInfoForm> userInfoList = new ArrayList<UserInfoForm>();

	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public String userInfo(Model model) {

		// 選択肢に必要な情報を定義する

		List<String> genders = new ArrayList<String>();
		genders.add("男");
		genders.add("女");
		model.addAttribute("genders", genders);

		List<String> birthpraces = new ArrayList<String>();
		birthpraces.add("");
		birthpraces.add("北海道");
		birthpraces.add("東北");
		birthpraces.add("関東");
		birthpraces.add("中部");
		birthpraces.add("近畿");
		birthpraces.add("中国");
		birthpraces.add("四国");
		birthpraces.add("九州");
		model.addAttribute("birthpraces", birthpraces);

		List<String> langs = new ArrayList<String>();
		langs.add("Java");
		langs.add("C#");
		langs.add("C/C++");
		langs.add("PHP");
		langs.add("Perl");
		langs.add("Ruby");
		langs.add("Python");
		langs.add("Swift");
		model.addAttribute("langs", langs);

		model.addAttribute("message", "情報を入力してください");
		model.addAttribute("userInfoForm", form);

		// 定義ここまで

		return "userInfo";
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public String userInfo(Model model, @Validated @ModelAttribute UserInfoForm form, BindingResult result) {

		// ★自画面に再遷移する際の初期表示情報を再定義する★

		/*  
		 * ※これがないと遷移後のラジオボタン、プルダウンリストなどの選択肢がnullになる
		 * 特にラジオボタンなどは「must not be null」とエラーとなるので注意が必要
		 */

		List<String> genders = new ArrayList<String>();
		genders.add("男");
		genders.add("女");
		model.addAttribute("genders", genders);

		List<String> birthpraces = new ArrayList<String>();
		birthpraces.add("");
		birthpraces.add("北海道");
		birthpraces.add("東北");
		birthpraces.add("関東");
		birthpraces.add("中部");
		birthpraces.add("近畿");
		birthpraces.add("中国");
		birthpraces.add("四国");
		birthpraces.add("九州");
		model.addAttribute("birthpraces", birthpraces);

		List<String> langs = new ArrayList<String>();
		langs.add("Java");
		langs.add("C#");
		langs.add("C/C++");
		langs.add("PHP");
		langs.add("Perl");
		langs.add("Ruby");
		langs.add("Python");
		langs.add("Swift");
		model.addAttribute("langs", langs);

		// 定義ここまで

		// エラーがあればメッセージを表示

		/*
		 * バリデーションのファイルは全プロジェクト共通の設定となってしまうので、
		 * 取り扱う変数名などには気を付けること
		 * JSPでバリデーションが検出された場合、コントローラーにはいかない
		 * という認識でOK
		 */

		if (result.hasErrors()) {
			System.out.println("えらぽよ");
			model.addAttribute("message", "エラーを検出しました");
		} else {
			model.addAttribute("message", "情報が入力されました");

			// 今回入力された一件を全件リストに追加する
			userInfoList.add(form);
		}

		// これいらなかった
		//　model.addAttribute("userInfoForm", form);

		// 全件を含んだuserInfoListを送信する
		model.addAttribute("userInfoList", userInfoList);
		return "userInfo";
	}
}
