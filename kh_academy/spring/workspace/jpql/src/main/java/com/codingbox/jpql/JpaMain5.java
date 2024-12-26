package com.codingbox.jpql;

import java.util.List;

import com.codingbox.jpql.entity.Member;
import com.codingbox.jpql.entity.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import oracle.net.aso.m;

public class JpaMain5 {

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
			
			/*
			 * jpql입장에선 select문이 나가지만, 
			 * 실제 sql입장에서 member와 team을 조인해서 결과를 찾아야한다.
			 * 그래서 join이 발생
			 *
			 * 근데 join은 성능에 영향을 많이 주는 요소이기 때문에
			 * 실제로는 sql문과 비슷하게 작성을 해주셔야 한다.
			 */
//			List<Team> result
//			= em.createQuery("select m.team from Member m", Team.class)
//				.getResultList();
			
			List<Team> result
			= em.createQuery("select t from Member m join m.team t", Team.class)
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





