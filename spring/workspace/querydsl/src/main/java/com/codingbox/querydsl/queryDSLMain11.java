package com.codingbox.querydsl;

import java.util.List;
 
import static com.codingbox.querydsl.entity.QMember.*;
import static com.codingbox.querydsl.entity.QTeam.*;

import com.codingbox.querydsl.entity.Member;
import com.codingbox.querydsl.entity.QMember;
import com.codingbox.querydsl.entity.Team;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class queryDSLMain11 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업단위
		EntityTransaction tx = em.getTransaction();
		// queryDSL
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		tx.begin();

		try {
			Team teamA = new Team("teamA");
			Team teamB = new Team("teamB");
			em.persist(teamA);
			em.persist(teamB);

			Member member1 = new Member("member1", 10, teamA);
			Member member2 = new Member("member2", 20, teamA);
			Member member3 = new Member("member3", 30, teamB);
			Member member4 = new Member("member4", 40, teamB);
			Member member5 = new Member(null, 100, teamB);
			Member member6 = new Member("member5", 100, teamB);
			Member member7 = new Member("member6", 100, teamB);
			
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);
			em.persist(member4);
			em.persist(member5);
			em.persist(member6);
			em.persist(member7);

			// 초기화
			em.flush();
			em.clear();
			
			/*
			 * 회원과 팀을 조인하면서, 팀 이름이 teamA인 팀만 조인,
			 * 회원 모두 조회
			 * jpql :
			 * select m, t from Member m left join m.team t on t.name = 'teamA';
			 * SQL :
			 * select m.* t.* from member m 
			 * left outer join team t 
			 * on m.team_id = t.id 
			 * and t.name = 'teamA';
			 */
			List<Tuple> result = queryFactory.select(member, team)
												.from(member)
												.leftJoin(member.team, team)
												.on(team.name.eq("teamA"))
												.fetch();
			
			for(Tuple tuple : result) {
				System.out.println("tuple = " + tuple);
			}
			
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