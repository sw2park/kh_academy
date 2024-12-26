package com.codingbox.jpql.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {

	private String username;
	private int age;
	
	public MemberDTO(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}
	
}






