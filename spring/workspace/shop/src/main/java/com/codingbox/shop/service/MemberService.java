package com.codingbox.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.shop.domain.Member;
import com.codingbox.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
	@Autowired
	private final MemberRepository memberRepository;
	
	// 회원가입
	@Transactional
	public Long join(Member member) throws IllegalAccessException {
		// 중복회원 검증 로직 추가
		validateMemberCheck(member);
		memberRepository.save(member);
		
		return member.getId();
	}
	
	//@Transactional(readOnly = true)
	public void validateMemberCheck(Member member) throws IllegalAccessException {
		List<Member> findMembers = memberRepository.findByName(member.getName());
		
		if(!findMembers.isEmpty()) {
			throw new IllegalAccessException("이미 존재하는 회원입니다.");
		}
	}
	
	// 전체 회원 조회
	//@Transactional(readOnly = true)
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	// 회원 단건 조회
	//@Transactional(readOnly = true)
	public Member findOne(Long memberId) {
		return memberRepository.findOne(memberId);
	}
}