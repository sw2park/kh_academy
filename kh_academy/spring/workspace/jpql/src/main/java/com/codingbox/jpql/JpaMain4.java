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

public class JpaMain4 {

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
			
			em.flush();
			em.clear();
			
			// 엔티티 프로젝션
			List<Member> result
			= em.createQuery("select m from Member m", Member.class)
				.getResultList();
			
			System.out.println("result : " + result.get(0));
		
			// 이게 바뀐다 -> 영속성 컨텍스트에 관리중이다
			// 안바뀐다	 -> 영속성 컨텍스트에서 관리가 안된다.
			Member findMember = result.get(0);
			findMember.setAge(20);
		
		
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





