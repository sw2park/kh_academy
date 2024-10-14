package com.codingbox.core2.controller;

import org.springframework.stereotype.Controller;

import com.codingbox.core2.service.MemberService;

@Controller
public class MemberController {
	// Controller가 Service를 의존한다라고 표현
	// service는 controller에서 가져다 쓸 수 있기 때문에 Spring Container에 등록을 한다. 
	// MemberService mService = new MemberService();
	
}