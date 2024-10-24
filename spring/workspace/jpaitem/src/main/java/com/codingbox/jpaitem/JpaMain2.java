package com.codingbox.jpaitem;

import java.util.List;

import com.codingbox.jpaitem.relation.Member;
import com.codingbox.jpaitem.relation.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// 저장
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
			member.setTeam(team);
			em.persist(member);
			
			Member member2 = new Member();
			member2.setUsername("member2");
			member2.setTeam(team);
			em.persist(member2);
			
			// 강제로 db쿼리를 보고 싶을때
			em.flush();
			em.clear();
			
			// 조회
			// find시에 1차캐시에서 가지고 와서 select 문이 없다.
			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			System.out.println("findTeamname :" + findTeam.getName());
			
			// 양방향 매핑
			Member findSideMember = em.find(Member.class, member.getId());
			List<Member> members = findSideMember.getTeam().getMember();
			
			for(Member m : members) {
				System.out.println("result = " + m.getUsername());
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
