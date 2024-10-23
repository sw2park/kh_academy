package com.codingbox.jpaitem;

import com.codingbox.jpaitem.relation.Member;
import com.codingbox.jpaitem.relation.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Team team = new Team();
			team.setName("teamA");
			// 영속상태가 되면 pk의 값이 세팅이 된 후
			// 영속상태가 된다.
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
			// member.setTeamId(team.getId());
			em.persist(member);
			
			// select
			// 어느팀 소속인지 알고싶을때 jpa or db에게 계속 물어봐야 한다.
//			Member findMember = em.find(Member.class, member.getId());
//			Long findTeamId = findMember.getTeamId();
//			Team findTeam = em.find(Team.class, findTeamId);
//			System.out.println("findTeam : " + findTeam.getName());
			
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
