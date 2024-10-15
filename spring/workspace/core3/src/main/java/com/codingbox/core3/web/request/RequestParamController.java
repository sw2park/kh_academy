package com.codingbox.core3.web.request;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RequestParamController {
	// 반환 타입이 없으면서, 응답에 값을 직접 넣으면 view 조회 X
	@RequestMapping("/request-param-v1")
	public void requestParam1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		response.getWriter().write("ok");
	}
	
	// @RequestParam	: 스프링이 제공하는 어노테이션
	//  - 파라미터 이름으로 바인딩
	// @ResponseBody
	//  - view 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParam2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge){
		
		System.out.println("username : " + memberName);
		System.out.println("age : " + memberAge);
		
		return "ok";
	}
	
	/*
	 * @RequestParams 사용
	 *  - HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name=XXX) 생략 가능 
	 */
	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParam3(@RequestParam String username, @RequestParam int age){
		
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		
		return "ok";
	}
	
	/*
	 * @RequestParam 사용 시
	 * String, int 등의 단순한 타입이면
	 * @RequestParam도 생략 가능  
	 */
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParam4(String username, int age){
		
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		
		return "ok";
	}
}