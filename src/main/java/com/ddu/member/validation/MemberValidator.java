package com.ddu.member.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ddu.member.dto.MemberDto;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberDto memberDto =(MemberDto) target;
		String id = memberDto.getId();
		String pw = memberDto.getPassword();
		String cpw = memberDto.getConfirmPassword();
		String name = memberDto.getName();
		int age = memberDto.getAge();
		String email = memberDto.getEmail();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty","아이디는 필수 입력사항입니다.");
		if(id != null && id.length() <= 5) { // 참이면 error -> 아이디가 5자 미만이면 error
			errors.rejectValue("id", "id.short", "아이디는 5자 이상이어야 합니다.");
		}
		if (pw != null && !pw.equals(cpw)) {
			errors.rejectValue("confirmPassword", "pw.mismatch", "비밀번호 확인이 일치하지 않습니다.");
		}
	}

}
