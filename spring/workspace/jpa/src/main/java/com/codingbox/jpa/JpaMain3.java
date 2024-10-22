package com.codingbox.jpa;

import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업 단위
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// 비영속 상태
			Member member = new Member();
			member.setId(100L);
			member.setName("JPA");
			// 여기서부터 영속 상태
			// EntityManager안에있는 영속성 컨텍스트에 관리가 된다는 뜻이다.
			// before, after 위치 사이에 쿼리문이 실행되지 않는다. 그 뒤에 insert 쿼리가 날아갔다.
			// 쿼리는 tx.commit(); 이 시점에 날아간다.
			System.out.println("===before====");
			em.persist(member);
			System.out.println("===after====");
			
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