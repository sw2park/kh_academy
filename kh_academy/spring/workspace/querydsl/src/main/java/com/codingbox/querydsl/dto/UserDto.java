package com.codingbox.querydsl.dto;

import lombok.Data;

// 실무에서 절대 X, 절대 권장하지 않는 방식
@Data
public class UserDto {
	private String name;
	private int age;
	
	public UserDto() {}
	
	public UserDto(String name, int age) {
		this.name = name;
		this.age = age;
	}
}