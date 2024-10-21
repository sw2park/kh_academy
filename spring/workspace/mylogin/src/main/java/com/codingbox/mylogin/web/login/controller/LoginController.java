package com.codingbox.mylogin.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.mylogin.web.login.dto.LoginForm;
import com.codingbox.mylogin.web.login.service.LoginService;
import com.codingbox.mylogin.web.member.dto.Member;
import com.codingbox.mylogin.web.session.SessionConst;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final LoginService loginService;

	@GetMapping("/login")
	private String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "login/loginForm";
	}

	// @PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model,
			RedirectAttributes redirectAttr) {

		Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

		if (loginMember == null) {
			// 로그인 실패
			model.addAttribute("msg", "로그인 실패");
			return "login/loginForm";
		}
		// 로그인 성공
		redirectAttr.addFlashAttribute("msg", "로그인 성공");
		return "redirect:/";
	}

	// @PostMapping("/login")
	public String loginV2(@ModelAttribute("loginForm") LoginForm loginForm, Model model,
			RedirectAttributes redirectAttr, HttpServletResponse response) {

		Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

		if (loginMember == null) {
			// 로그인 실패
			model.addAttribute("msg", "로그인 실패");
			return "login/loginForm";
		}
		// 로그인 성공
		// 쿠키에다가 값 저장
		Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));

		response.addCookie(idCookie);
		redirectAttr.addFlashAttribute("msg", "로그인 성공");

		return "redirect:/";
	}

	//@PostMapping("/login")
	public String loginV3(@ModelAttribute LoginForm form, Model model, HttpServletRequest request) {
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

		if (loginMember == null) {
			// 로그인 실패
			model.addAttribute("msg", "로그인 실패");
			return "login/loginForm";
		}

		// 로그인 성공
		// 세션에다가 로그인 정보 저장
		// 세션이 있었으면 세션 반환, 없으면 신규 세션 생성
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

		return "redirect:/";
	}
	
	// /login?redirectURL=items
	@PostMapping("/login")
	public String loginV4(@ModelAttribute LoginForm form, Model model, HttpServletRequest request, @RequestParam(defaultValue = "/")String redirectURL) {
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

		if (loginMember == null) {
			// 로그인 실패
			model.addAttribute("msg", "로그인 실패");
			return "login/loginForm";
		}

		// 로그인 성공
		// 세션에다가 로그인 정보 저장
		// 세션이 있었으면 세션 반환, 없으면 신규 세션 생성
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
		
		return "redirect:" + redirectURL;
	}

	// 로그아웃
	// @PostMapping("/logout")
	public String logout(HttpServletResponse response) {
		// 쿠키 만료, max-age = 0, 해당 쿠키는 즉시 종료
		Cookie cookie = new Cookie("memberId", null);

		cookie.setMaxAge(0);
		response.addCookie(cookie);

		return "redirect:/";
	}
	
	@PostMapping("/logout")
	public String logoutV2(HttpServletRequest request) {
		// 세션을 삭제
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/";
	}
}