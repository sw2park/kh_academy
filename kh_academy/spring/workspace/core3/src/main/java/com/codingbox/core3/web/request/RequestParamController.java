package com.codingbox.core3.web.request;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codingbox.core3.dto.HelloData;

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
	
	/*
	 *  @RequestParam
	 *   - Required = true		: 반드시 파라미터 값이 들어와야 한다. 기본값
	 *   : 9090/request-param-required				-> 예외
	 *   : 9090/request-param-required?username=	-> 빈문자열 통과		 
	 *   : 9090/request-param-required
	 *   	-> null을 int에 입력하는 것은 불가능, 따라서 Integer로 변경해야 한다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age){
		
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		
		return "ok";
	}
	
	/*
	 * @RequestParam
	 *  - defaultValue
	 */
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username, @RequestParam(required = false, defaultValue = "-1") Integer age){
		
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		
		return "ok";
	}
	
	/*
	 * @RequestParam
	 *  - Map(key=value)
	 */
	@ResponseBody
	@RequestMapping("/request-param-Map")
	public String requestParamMap(@RequestParam Map<String, Object> paramMap){
		
		System.out.println("username : " + paramMap.get("username"));
		System.out.println("age : " + paramMap.get("age"));
		
		return "ok";
	}
	
	/*
	 * @ModelAttribute
	 *  - 파라미터를 받아서 필요한 객체를 만들고 그 객체에 값을 넣어주어야 한다.
	 *    스프링은 이를 완전히 자동화해주는 기능을 제공한다.
	 *  - HelloData 객체 생성
	 *  - 요청 파라미터의 이름으로 HelloData 객체의 프로퍼티를 찾아서 setter 호출 후 파라미터의 값을 바인딩한다.  
	 */
	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
		HelloData helloData = new HelloData();
		helloData.setUsername(username);
		helloData.setAge(age);
		
		System.out.println("username : " + helloData.getUsername());
		System.out.println("age : " + helloData.getAge());
				
		return "ok";
	}
	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttributeV2(@ModelAttribute HelloData helloData) {
		System.out.println("username : " + helloData.getUsername());
		System.out.println("age : " + helloData.getAge());
				
		return "ok";
	}
	
	/*
	 * @ModelAttribute 생략 가능 
	 *  - String, int 와 같은 단순 타입	= @RequestParam 생략
	 *  - 객체타입 					= @ModelAttribute 생략
	 */
	@ResponseBody
	@RequestMapping("/model-attribute-v3")
	public String modelAttributeV3(HelloData helloData) {
		System.out.println("username : " + helloData.getUsername());
		System.out.println("age : " + helloData.getAge());
				
		return "ok";
	}
}