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
	
	// controller �z���̑S�Ẵt�@�C���ɃA�N�Z�X�������A�{�������s�����iAOP�̓K�p�j
	// Around ���w�肷��ɂ́AProceedingJoinPoint �������Ɏw�肷��K�v������
	@Around("execution(* jp_co.good_works.lesson.transit.controller.*.*(..))")
	public String checkAuthenticated(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// ApplicationContext �̐ݒ�������� LoginController �̃C���X�^���X����
		// ��LoginController ��AOP�Ƃ��Ďw�肵�Ă���iAOP�̓N���X�t�@�C�����w�肵�Ȃ���΂Ȃ�Ȃ��j
		LoginController loginControl = getApplicationContext().getBean(LoginController.class);
		
		// LoginController �N���X�� isLive ���\�b�h���Ăяo���A���O�C����Ԃ̗L���iboolean�^�j�̌��ʂ��擾
		if (loginControl.isLive()) {
			return (String)joinPoint.proceed();
		}
		// login.jsp �ɑJ��
		return "redirect:/login";
	}
}
