package com.codingbox.jpa;

import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업 단위
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			/*
			Member member = new Member();
			member.setId(2L);
			member.setName("UserA");
			em.persist(member);
			
			Member member2 = new Member();
			member2.setId(3L);
			member2.setName("UserB");
			em.persist(member2);
			*/
			
			// JPQL
			// JPQL로 쿼리를 짤때, Table을 대상으로 쿼리를 짜지 않고 Member 객체를 대상으로 쿼리를 짠다고 생각하면 된다.
			List<Member> result = em.createQuery("select m from Member as m", Member.class)
					.setFirstResult(5)	// 5번부터
					.setMaxResults(10)	// 10개를 가지고와
					.getResultList();
			
			for(Member m : result) {
				System.out.println("member.name = " + m.getName());
			}
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
		em.close();
		emf.close();
	}
}