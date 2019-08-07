package jp_co.good_works.lesson.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// �R���g���[���[�Ƃ��Ďg�p���邱�Ƃ�錾
// MVC���f���ō쐬���Ă���̂ō���͋L�ڕK�{
@Controller
public class HelloController {

	// hello�ƃA�N�Z�X���ꂽ�牺�L���\�b�h�����s�����i�啶���������͋�ʂ����j
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
		public String hello(Model model) {
		// model���Ƃ�������message�Ƃ������O�� Hello Spring! �Ƃ�����������i�[���Ă���
		model.addAttribute("message", "Hello Spring!" );
		// hello.jsp�֑J�ڂ���i�啶���������͋�ʂ����j
		return "hello";
	}

}
