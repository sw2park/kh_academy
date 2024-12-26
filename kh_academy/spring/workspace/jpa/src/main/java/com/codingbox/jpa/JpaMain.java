package com.codingbox.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업 단위
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// 회원 조회, select
			Member findMember = em.find(Member.class, 1L);
			System.out.println("findMember.id : "+findMember.getId());
			System.out.println("findMember.getName : "+findMember.getName());
			
			// 회원 수정, update
			findMember.setName("Hello");
			
			// 회원 수정, delete
			em.remove(findMember);
			
			Member member = new Member();
			
			// 추가 insert
//			member.setId(1L);
//			member.setName("UserA");
//			em.persist(member);
			
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