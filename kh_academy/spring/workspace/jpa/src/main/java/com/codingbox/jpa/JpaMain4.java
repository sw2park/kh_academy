package com.codingbox.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Member2 member1 = new Member2();
			// member2.setId("ID_A");
			member1.setUsername("JPAUser");
			em.persist(member1);
			
			Member2 member2 = new Member2();
			// member2.setId("ID_A");
			member2.setUsername("JPAUser");
			em.persist(member2);
			
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
