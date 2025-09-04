package com.ddu.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddu.member.dto.MemberDto;
import com.ddu.member.validation.MemberValidator;

@Controller
public class MemberController {
	@RequestMapping(value = "/memberJoin")
	public String memberJoin(){
		return"memberJoin";
	}
	@RequestMapping(value = "/memberJoinOk")
	public String memberJoinOk(@ModelAttribute("memberDto") MemberDto memberDto,BindingResult result, Model model){
		
		MemberValidator memberValidator = new MemberValidator();
		memberValidator.validate(memberDto, result);
		
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<String> errorMsg = new ArrayList<String>();
			
			for (ObjectError objectError : allErrors) {
				errorMsg.add(objectError.getDefaultMessage());
			}
			model.addAttribute("signupError", "회원가입에 실패 하였습니다.");
			model.addAttribute("errorMsg",errorMsg );
			
			model.addAttribute("memberDto", memberDto);
			return"memberJoin";
		}
		model.addAttribute("memberDto", memberDto);
		return"memberJoinOk";
	}
}
