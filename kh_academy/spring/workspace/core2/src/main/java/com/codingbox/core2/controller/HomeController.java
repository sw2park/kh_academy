package com.codingbox.core2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// 우선순위는 Spring Container이다.
	// 기본 localhost:9090 으로 들어오면 이곳을 호출
	@GetMapping("/")
	public String home() {
		return "home";
	}
}