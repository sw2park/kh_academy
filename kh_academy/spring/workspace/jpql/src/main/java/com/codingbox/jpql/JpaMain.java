package com.codingbox.jpql;

import java.util.List;

import com.codingbox.jpql.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import oracle.net.aso.m;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업단위
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
		Member member = new Member();
		member.setUsername("member1");
		member.setAge(10);
		em.persist(member);
		
		// 타입 정보가 명확할 때
		TypedQuery<Member> query =
		em.createQuery("select m from Member m",Member.class);
		
		// 타입정보가 String.class로 반환타입이 명확할 때
		TypedQuery<String> query2 =
		em.createQuery("select m.username from Member m"
											,String.class);
		
		// m.username(String), m.age(int)
		// 이렇게 반환타입이 명확하지 않을 때 사용
		Query query3 = 
		em.createQuery("select m.username, m.age from Member m");
		
		TypedQuery<Member> query4
		= em.createQuery("select m from Member m", Member.class);
		
		List<Member> resultList = query4.getResultList();
		for(Member m : resultList) {
			System.out.println("member1 = " + m);
		}
		
		// 결과값이 하나일 경우
		TypedQuery<Member> query5
		= em.createQuery("select m from Member m where m.id = 10", Member.class);
		Member result = query5.getSingleResult();
		System.out.println("result : " + result);	
		
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
	}

}





