package com.codingbox.querydsl;

import java.util.List;

// 
import static com.codingbox.querydsl.entity.QMember.*;

import com.codingbox.querydsl.entity.Member;
import com.codingbox.querydsl.entity.QMember;
import com.codingbox.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class queryDSLMain2 {
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
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);
			em.persist(member4);

			// 초기화
			em.flush();
			em.clear();

			// jpql, member1을 찾기
			String sql = "select m from Member m where m.username = :username";
			Member findByJpql = em.createQuery(sql, Member.class).setParameter("username", "member1").getSingleResult();

			System.out.println("findByJpql : " + findByJpql.getUsername().equals("member1"));

			// QMember의 이름을 부여, 별칭
			// 아래 코드처럼 쓰기도 함
//			QMember m = new QMember("m");
			QMember m = QMember.member;
			
			// 아래 코드처럼 쓰기도 함
//			Member findByQueryDSL = queryFactory.select(m).from(m).where(m.username.eq("member1")).fetchOne();
//			Member findByQueryDSL = queryFactory.select(QMember.member)
//					.from(QMember.member)
//					.where(QMember.member.username.eq("member1")).fetchOne();
			
			// 상단 import부분에 Q클래스를 임포트 했을 시 아래처럼 사용가능
			Member findByQueryDSL = queryFactory.select(member).from(member).where(member.username.eq("member1")).fetchOne();

			System.out.println("findByQueryDSL : " + findByQueryDSL.getUsername().equals("member1"));

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