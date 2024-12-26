package com.codingbox.core2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.core2.dto.Member;
import com.codingbox.core2.dto.MemberFormDTO;
import com.codingbox.core2.service.MemberService;

@Controller
public class MemberController {
	// Controller가 Service를 의존한다라고 표현
	// service는 controller에서 가져다 쓸 수 있기 때문에 Spring Container에 등록을 한다. 
	// MemberService mService = new MemberService();
	
	// 스프링 답게 작업하기
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping(value="/members/new")
	public String create(MemberFormDTO form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		// 홈 화면으로 돌린다.
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		
		return "members/memberList.html";
	}
}