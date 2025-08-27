package com.ddu.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
	private String name;
	private String email;
	private int age;
}
