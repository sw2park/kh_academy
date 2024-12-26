package com.codingbox.core3.web.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
	
	/*
	 *  ModelAndView는 data와 view를 같이 return
	 */
	@RequestMapping("/response-view-v1")
	public ModelAndView responseViewV1() {
		ModelAndView mav= new ModelAndView("response/hello").addObject("data", "hello!!!");
		
		return mav;
	}
	
	/*
	 * @Controller에서 return이 String이면 view의 논리적 이름이 된다. 
	 */
	//@ResponseBody
	@RequestMapping("/response-view-v2")
	public String responseViewV2(Model model) {
		model.addAttribute("data", "model data!!!");
		
		return "response/hello";
	}
}