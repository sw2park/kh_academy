package com.codingbox.mylogin.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingbox.mylogin.web.member.dto.Member;
import com.codingbox.mylogin.web.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
	private final MemberRepository memberRepository;
	
	// @ModelAttribute("member") Member member
	// -> model.addAttribute("member", new Member());
	@GetMapping("/add")
	public String addForm(@ModelAttribute("member") Member member) {
		return "members/addMemberForm";
	}

}