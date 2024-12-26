package com.codingbox.thymeleaf_basic.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingbox.thymeleaf_basic.data.User;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/basic")
public class BasicController {
	@GetMapping("text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "Hello Spring!!");
		
		return "basic/test-basic";
	}
	
	@GetMapping("variable")
	public String variable(Model model) {
		User userA = new User("userA", 10);
		User userB = new User("userB", 10);
		
		List<User> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		
		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		
		return "basic/variable";
	}
	
	@GetMapping("link")
	public String link(Model model) {
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		
		return "basic/link";
	}
	
	@GetMapping("literal")
	public String literal(Model model) {
		model.addAttribute("data", "Spring");
		
		return "basic/literal";
	}
	
	@GetMapping("operation")
	public String operation(Model model) {
		model.addAttribute("nullData", null);
		model.addAttribute("data", "spring");
		
		return "basic/operation";
	}
	
	@GetMapping("each")
	public String each(Model model) {
		addUsers(model);
		
		return "basic/each";
	}
	
	@GetMapping("condition")
	public String condition(Model model) {
		addUsers(model);
		
		return "basic/condition";
	}
	
	@GetMapping("comments")
	public String comments(Model model) {
		model.addAttribute("data", "Spring");
		
		return "basic/comments";
	}
	
	@GetMapping("block")
	public String block(Model model) {
		addUsers(model);
		
		return "basic/block";
	}
	
	private void addUsers(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User("userA", 10));
		list.add(new User("userB", 20));
		list.add(new User("userC", 30));
		
		model.addAttribute("users", list);
	}
}