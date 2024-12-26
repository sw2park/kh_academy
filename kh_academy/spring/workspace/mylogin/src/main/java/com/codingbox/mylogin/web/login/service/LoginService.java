package com.codingbox.mylogin.web.login.service;

import org.springframework.stereotype.Service;

import com.codingbox.mylogin.web.member.dto.Member;
import com.codingbox.mylogin.web.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final MemberRepository memberRepository;
	
	public Member login(String loginId, String password) {
		Member member = memberRepository.findByLoginId(loginId);
		
		if(member != null && member.getLoginId().equals(loginId) && member.getPassword().equals(password)) { // 로그인 성공
			return member;
		} else { // 로그인 실패
			return null;
		}
	}
}
