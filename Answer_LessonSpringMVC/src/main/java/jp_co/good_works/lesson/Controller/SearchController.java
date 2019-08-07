package jp_co.good_works.lesson.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp_co.good_works.lesson.Dao.DeleteDao;
import jp_co.good_works.lesson.Dao.SearchDao;
import jp_co.good_works.lesson.Form.SearchForm;

@Controller
@Scope("session")
/*--------------------ユーザ一覧表示--------------------------*/
public class SearchController {
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchInfo(Model model) throws SQLException {
		SearchForm searchForm = new SearchForm();
		SearchDao sd = new SearchDao();
		
		ArrayList<SearchForm> searchList = sd.allSearch();
		model.addAttribute("count","ユーザが"+searchList.size()+"件見つかりました");
		model.addAttribute("searchList",searchList);
		model.addAttribute("searchForm",searchForm);
		model.addAttribute("message","");
		return "search";
	}
	/*--------------------ユーザ一覧からユーザを検索--------------------------*/
	@RequestMapping(value = "/search",params = "sqlLike", method = RequestMethod.POST)
	public String searchInfo(Model model , SearchForm searchForm) throws SQLException {
		System.out.println("---------------------------"+searchForm.getSqlLike());
		SearchDao sd = new SearchDao();
		ArrayList<SearchForm> searchList = sd.search(searchForm.getSqlLike());
		//該当ユーザ ありorなし判定
		if(searchList!=null ) {
			//該当ユーザあり
			model.addAttribute("message","");
			model.addAttribute("count","ユーザが"+searchList.size()+"件見つかりました");
			model.addAttribute("searchList",searchList);
			//何も入力せずに検索
		}else if(searchForm.getSqlLike().equals("")) {
			//一覧ユーザを再度表示
			sd = new SearchDao();
			searchList = sd.allSearch();
			model.addAttribute("count", "");
			model.addAttribute("message","正しく入力してください");
			model.addAttribute("searchList",searchList);	
		}else if(searchList==null){
			//検索したユーザが見つからなかった場合、一覧ユーザを表示
			sd = new SearchDao();
			searchList = sd.allSearch();
			model.addAttribute("count", "");
			model.addAttribute("message","該当するユーザが見つかりませんでした");
			model.addAttribute("searchList",searchList);
		}
		model.addAttribute("searchForm",searchForm);
		return "search";
	}
	/*--------------------削除ボタン実行後--------------------------*/
	@RequestMapping(value = "/search",params = "delete",method = RequestMethod.POST)
	public String searchInfo2(Model model , SearchForm searchForm , @RequestParam("delete") int userid) throws SQLException {
		DeleteDao dd = new DeleteDao();
		dd.darete(userid);
		SearchDao sd = new SearchDao();
		ArrayList<SearchForm> searchList = sd.allSearch();
		model.addAttribute("message","ユーザを削除しました");
		model.addAttribute("searchList",searchList);
		model.addAttribute("searchForm",searchForm);
		return "search";
	}
}
