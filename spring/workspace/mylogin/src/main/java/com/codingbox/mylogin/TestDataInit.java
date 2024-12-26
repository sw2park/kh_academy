package com.codingbox.mylogin;

import org.springframework.stereotype.Component;

import com.codingbox.mylogin.web.item.dto.Item;
import com.codingbox.mylogin.web.item.repository.ItemRepository;
import com.codingbox.mylogin.web.member.dto.Member;
import com.codingbox.mylogin.web.member.repository.MemberRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {
	
	private final MemberRepository memberRepository;
	private final ItemRepository itemRepository;
	
	// 테스트용 데이터 추가
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("testA", 10000, 10));
		itemRepository.save(new Item("testB", 20000, 20));
		
		Member member = new Member();
		
		member.setLoginId("test");
		member.setName("테스터");
		member.setPassword("test!");
		
		memberRepository.save(member);
	}
}