package com.codingbox.querydsl;

import java.util.List;

// 
import static com.codingbox.querydsl.entity.QMember.*;

import com.codingbox.querydsl.entity.Member;
import com.codingbox.querydsl.entity.QMember;
import com.codingbox.querydsl.entity.Team;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class queryDSLMain8 {
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
			
			// 집합
			/*
			 *  jpql
			 *  count(m),
			 *  sum(m.age),
			 *  avg(m.age),
			 *  max(m.age),
			 *  min(m.age)
			 */
			List<Tuple> result = queryFactory.select(member.count(),
													member.age.sum(),
													member.age.max(),
													member.age.avg(),
													member.age.min())
												.from(member)
												.fetch();
			
			Tuple tuple = result.get(0);
			
			System.out.println(tuple.get(member.count()));
			System.out.println(tuple.get(member.age.sum()));
			System.out.println(tuple.get(member.age.avg()));
			System.out.println(tuple.get(member.age.max()));
			System.out.println(tuple.get(member.age.min()));
			
			
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