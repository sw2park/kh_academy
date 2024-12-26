package com.codingbox.shop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingbox.shop.domain.Member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
//import jakarta.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	// jpa가 지원해 주는 표준으로 의존성 주입
	// spring이 entityManager를 만들어서 em에다가 주입
//	@PersistenceContext
	/*
	 * @PersistenceContext이 있어야 표준 injection(주입)이 된다.
	 * spring boot의 @Autowired가 injection이 되도록 이러한 지원을 해준다. 
	 */
	@Autowired
	private final EntityManager em;
	
	// 생성자 주입
//	private MemberRepository(EntityManager em) {
//		this.em = em;
//	}
	
	// 저장
	public void save(Member member) {
		em.persist(member);
	}
	
	// 조회
	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}
	
	// 전체 조회
	public List<Member> findAll(){
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
	
	// 이름으로 조회
	public List<Member> findByName(String name){	// JPQL 사용한 부분
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name)
				.getResultList();
	}
}