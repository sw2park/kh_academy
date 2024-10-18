package com.codingbox.mylogin.web.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
	private long id;
	private String loginId;
	private String name;
	private String password;
}
