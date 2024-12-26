package com.codingbox.jpql;

import java.util.List;

import com.codingbox.jpql.entity.Address;
import com.codingbox.jpql.entity.Member;
import com.codingbox.jpql.entity.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import oracle.net.aso.m;

public class JpaMain7 {

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
			
			// 스칼라 타입 프로젝션
			// 반환타입이 명확하지 않기 때문에, 2번째 param값 삭제
			em.createQuery("select m.username, m.age from Member m")
			  .getResultList();
			
			
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





