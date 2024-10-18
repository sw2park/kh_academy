package com.codingbox.mylogin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codingbox.mylogin.web.member.dto.Member;
import com.codingbox.mylogin.web.member.repository.MemberRepository;
import com.codingbox.mylogin.web.session.SessionConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final MemberRepository memberRepository;
	
	// @GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 로그인까지 처리되는 home 화면
	// required=false 로그인 안한 사용자도 이용할 수 있게해야 한다.
	// @GetMapping("/")
	public String homeV2(@CookieValue(name="memberId", required=false) Long memberId, Model model) {
		// 로그인한 사용자가 아니라면 home으로 보낸다.
		if(memberId == null) {
			return "home";
		}
		// db 조회 한 후, 사용자가 없으면 다시 home화면 이동 
		Member loginMember = memberRepository.findById(memberId);
		
		if(loginMember == null) {
			return "home";
		}
		
		// 로그인 성공
		model.addAttribute("member", loginMember);
		
		return "loginHome";
	}
	
	// @GetMapping("/")
	public String homeV3(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		// 로그인한 사용자가 아니라면 home으로 보낸다.
		if(session == null) {
			return "home";
		}
		// session 조회 한 후, 
		Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
		// 사용자가 없으면 다시 home화면 이동
		if(loginMember == null) {
			return "home";
		}
		// 로그인 성공
		model.addAttribute("member", loginMember);
		
		return "loginHome";
	}
	
	@GetMapping("/")
	public String homeV4(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
		if(loginMember == null) {
			return "home";
		}
		
		// 로그인 성공
		model.addAttribute("member", loginMember);
		
		return "loginHome";
	}
}