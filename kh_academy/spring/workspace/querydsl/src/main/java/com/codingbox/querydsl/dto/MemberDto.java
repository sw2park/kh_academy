package com.codingbox.querydsl.dto;

import lombok.Data;

// 실무에서 절대 X, 절대 권장하지 않는 방식
@Data
public class MemberDto {
	private String username;
	private int age;
	
	public MemberDto() {}
	
	public MemberDto(String username, int age) {
		this.username = username;
		this.age = age;
	}
}