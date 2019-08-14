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

		// �I�����ɕK�v�ȏ����`����

		List<String> genders = new ArrayList<String>();
		genders.add("�j");
		genders.add("��");
		model.addAttribute("genders", genders);

		List<String> birthpraces = new ArrayList<String>();
		birthpraces.add("");
		birthpraces.add("�k�C��");
		birthpraces.add("���k");
		birthpraces.add("�֓�");
		birthpraces.add("����");
		birthpraces.add("�ߋE");
		birthpraces.add("����");
		birthpraces.add("�l��");
		birthpraces.add("��B");
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

		model.addAttribute("message", "������͂��Ă�������");
		model.addAttribute("userInfoForm", form);

		// ��`�����܂�

		return "userInfo";
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public String userInfo(Model model, @Validated @ModelAttribute UserInfoForm form, BindingResult result) {

		// ������ʂɍđJ�ڂ���ۂ̏����\�������Ē�`���遚

		/*  
		 * �����ꂪ�Ȃ��ƑJ�ڌ�̃��W�I�{�^���A�v���_�E�����X�g�Ȃǂ̑I������null�ɂȂ�
		 * ���Ƀ��W�I�{�^���Ȃǂ́umust not be null�v�ƃG���[�ƂȂ�̂Œ��ӂ��K�v
		 */

		List<String> genders = new ArrayList<String>();
		genders.add("�j");
		genders.add("��");
		model.addAttribute("genders", genders);

		List<String> birthpraces = new ArrayList<String>();
		birthpraces.add("");
		birthpraces.add("�k�C��");
		birthpraces.add("���k");
		birthpraces.add("�֓�");
		birthpraces.add("����");
		birthpraces.add("�ߋE");
		birthpraces.add("����");
		birthpraces.add("�l��");
		birthpraces.add("��B");
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

		// ��`�����܂�

		// �G���[������΃��b�Z�[�W��\��

		/*
		 * �o���f�[�V�����̃t�@�C���͑S�v���W�F�N�g���ʂ̐ݒ�ƂȂ��Ă��܂��̂ŁA
		 * ��舵���ϐ����Ȃǂɂ͋C��t���邱��
		 * JSP�Ńo���f�[�V���������o���ꂽ�ꍇ�A�R���g���[���[�ɂ͂����Ȃ�
		 * �Ƃ����F����OK
		 */

		if (result.hasErrors()) {
			System.out.println("����ۂ�");
			model.addAttribute("message", "�G���[�����o���܂���");
		} else {
			model.addAttribute("message", "��񂪓��͂���܂���");

			// ������͂��ꂽ�ꌏ��S�����X�g�ɒǉ�����
			userInfoList.add(form);
		}

		// ���ꂢ��Ȃ�����
		//�@model.addAttribute("userInfoForm", form);

		// �S�����܂�userInfoList�𑗐M����
		model.addAttribute("userInfoList", userInfoList);
		return "userInfo";
	}
}
