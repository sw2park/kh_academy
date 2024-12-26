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

public class JpaMain3 {

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
		
		// 파라미터 바인딩 - 위치기반(쓰기 말것)
		Member result 
		= em.createQuery("select m from Member m where m.username = ?1", Member.class)
			.setParameter(1, "member1")
			.getSingleResult();
		
		System.out.println("result : " + result.getUsername());	
		
		
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





