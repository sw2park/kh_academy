package com.codingbox.core2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingbox.core2.dto.Member;
import com.codingbox.core2.repository.MemberRepository;
import com.codingbox.core2.repository.MemoryMemberRepository;

import jakarta.transaction.Transactional;

@Service
@org.springframework.transaction.annotation.Transactional
public class MemberService {
//	MemberRepository memberRepository = new MemoryMemberRepository();
	
	// spring 답게 작업
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
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