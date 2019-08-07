package jp_co.good_works.lesson.Controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp_co.good_works.lesson.Dao.UpdateDao;
import jp_co.good_works.lesson.Form.SearchForm;
import jp_co.good_works.lesson.Form.UpdateForm;

@Controller
public class UpdateController {

	/*---------------search.jspの更新ボタンから遷移-------------------*/
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	/*---------------@RequestParamを利用し、必要なパラメータを取得-------------------*/
	public String update(Model model , SearchForm searchForm,
			@RequestParam("updateId") int userId ,/*@RequestParam("updateadmin")int admin,*/ @RequestParam("updateName")String userName,
			@RequestParam("updatePass")String pass,@RequestParam("updateMail")String mail) {

		UpdateForm updateForm = new UpdateForm();
		updateForm.setUser_name(userName);
		updateForm.setUser_pass(pass);
		updateForm.setUser_mail(mail);
		model.addAttribute("userId", userId);   //update文を実行する際にuser_idが必要になるため、update.jspを経由しUpdateControllerのPOSTへ
		/*model.addAttribute("admin", admin);*/ //セッションにadmin情報格納する
		model.addAttribute("userName",userName);
		model.addAttribute("pass",pass);
		model.addAttribute("mail",mail);
		/*model.addAttribute("adminRadioButtun","");*/    //一般ユーザだった場合、ラジオボタンは表示させない
		model.addAttribute("updateForm",updateForm);
		model.addAttribute("searchForm",searchForm);
		/*
		if(admin==1) {
			//今操作しているユーザ管理者権限にすることが出来るラジオボタン
			model.addAttribute("adminRadioButtun");

		}
		 */
		return "update";
	}

	/*---------------更新ボタン実行-------------------*/
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String searchInfo(Model model ,@Validated @ModelAttribute UpdateForm updateForm, BindingResult result,
			@RequestParam("userId") int userId) throws SQLException {
		if(result.hasErrors()) {
			model.addAttribute("message","正しく入力してください");
		}else {
			UpdateDao ud = new UpdateDao();
		    ud.update(userId,updateForm.getUser_name(),updateForm.getUser_mail(),updateForm.getUser_pass());
			model.addAttribute("message","ユーザ情報を更新しました");
		}
		model.addAttribute("userId",userId);
		return "update";
	}
}

