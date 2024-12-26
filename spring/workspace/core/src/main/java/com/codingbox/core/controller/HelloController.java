package com.codingbox.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		System.out.println("hello");
		model.addAttribute("data", "spring!!");
		
		return "hello";
	}
	
	/*
	 * @RequestParam 	: param 값을 받아온다.
	 *  - required		: 파라미터값 필수 여부, true-필수(default), false-필수 아님
	 *  - defaultValue	: 파라미터 값이 없을 경우 기본으로 들어갈 값
	 */
	// @RequestMapping();
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "name", required = false, defaultValue = "default Spring") String name, Model model) {
		System.out.println(name);
		model.addAttribute("name", name);
		
		return "hello-template";
	}
}