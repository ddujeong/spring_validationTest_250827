package com.ddu.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private String id;
	private String password;
	private String confirmPassword;
	private String name;
	private String email;
	private int age;
	
}
