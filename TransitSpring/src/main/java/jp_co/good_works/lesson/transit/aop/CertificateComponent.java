package jp_co.good_works.lesson.transit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.WebContentGenerator;

import jp_co.good_works.lesson.transit.controller.no_cert.LoginController;

@Aspect
@Component
public class CertificateComponent extends WebContentGenerator {
	
	// controller 配下の全てのファイルにアクセスした時、本件が実行される（AOPの適用）
	// Around を指定するには、ProceedingJoinPoint を引数に指定する必要がある
	@Around("execution(* jp_co.good_works.lesson.transit.controller.*.*(..))")
	public String checkAuthenticated(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// ApplicationContext の設定を加えた LoginController のインスタンス生成
		// ※LoginController をAOPとして指定している（AOPはクラスファイルを指定しなければならない）
		LoginController loginControl = getApplicationContext().getBean(LoginController.class);
		
		// LoginController クラスの isLive メソッドを呼び出し、ログイン状態の有無（boolean型）の結果を取得
		if (loginControl.isLive()) {
			return (String)joinPoint.proceed();
		}
		// login.jsp に遷移
		return "redirect:/login";
	}
}
