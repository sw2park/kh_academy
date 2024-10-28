package com.codingbox.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // Logger log = LoggerFactory.getLogger(getClass());를 대신하는 중, lombok 제공
public class HomeController {
	
	// @Slf4j와 동일
//	Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/")
	public String home() {
		log.info("home Controller!!!");
		return "home";
	}
}