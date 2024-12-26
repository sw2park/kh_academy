package com.codingbox.jpql;

import java.util.List;

import com.codingbox.jpql.dto.MemberDTO;
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

public class JpaMain12 {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업단위
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
			member.setAge(10);
			member.changeTeam(team);
			em.persist(member);
			
			em.flush();
			em.clear();
			
			// 서브쿼리
			String jpql = 
			"select m from Member m where m.age > (select avg(m2.age) from Member m2)";
			List<Member> resulList = 
					em.createQuery(jpql, Member.class)
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






