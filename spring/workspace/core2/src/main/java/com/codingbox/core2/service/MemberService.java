package com.codingbox.core2.service;

import java.util.List;

import com.codingbox.core2.dto.Member;
import com.codingbox.core2.repository.MemberRepository;
import com.codingbox.core2.repository.MemoryMemberRepository;

public class MemberService {
	MemberRepository memberRepository = new MemoryMemberRepository();
	
	// 회원가입
	public int join(Member member) {
		memberRepository.save(member);
		
		return member.getId();
	}
	
	// 전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
}