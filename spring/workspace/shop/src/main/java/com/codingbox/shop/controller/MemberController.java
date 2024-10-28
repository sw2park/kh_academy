package com.codingbox.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codingbox.shop.domain.Address;
import com.codingbox.shop.domain.Member;
import com.codingbox.shop.dto.MemberForm;
import com.codingbox.shop.repository.MemberRepository;
import com.codingbox.shop.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MemberController {
	@Autowired
	private final MemberService memberService;
	
	@GetMapping("members/new")
	public String createForm(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "members/createMemberForm.html";
	}
	
	/*
	 * validation 다음에 BindingResult이 있으면 error 발생 시, error를 Binding에 담아준다.
	 */
	@PostMapping("members/new")
	public String create(@Valid MemberForm form, BindingResult result) throws IllegalAccessException {
		// 에러가 있다면
		if(result.hasErrors()) {
			return "members/createMemberForm";
		}
		
		// 회원가입 기능 완성
		Member member = new Member();
		Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode()); 
		
		member.setName(form.getName());
		member.setAddress(address);
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	// 회원목록 조회
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		
		return "members/memberList";
	}
}