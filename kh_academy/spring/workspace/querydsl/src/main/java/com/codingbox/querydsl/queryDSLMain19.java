package com.codingbox.querydsl;

import java.util.List;

import org.hibernate.query.criteria.JpaExpression;

import static com.codingbox.querydsl.entity.QMember.*;
import static com.codingbox.querydsl.entity.QTeam.*;

import com.codingbox.querydsl.dto.MemberDto;
import com.codingbox.querydsl.entity.Member;
import com.codingbox.querydsl.entity.QMember;
import com.codingbox.querydsl.entity.Team;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class queryDSLMain19 {
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

			// jpql
			List<MemberDto> result = em
					.createQuery("select new com.codingbox.querydsl.dto.MemberDto(m.username, m.age)" + "from Member m",
							MemberDto.class)
					.getResultList();

			for (MemberDto memberDto : result) {
				System.out.println("memberDTO : " + memberDto);
			}

			// queryDSL : bean, getter, setter
			// 1param : MemberDto.class 와 같이 type을 지정
			// 2param~ : 꺼내올 값 나열
			List<MemberDto> result2 = queryFactory
					.select(Projections.bean(MemberDto.class, member.username, member.age)).from(member).fetch();
			for (MemberDto memberDto : result2) {
				System.out.println("memberDTO : " + memberDto);
			}

			// 필드 직접 접근
			// getter, setter가 없어도 된다.
			List<MemberDto> result3 = queryFactory
					.select(Projections.fields(MemberDto.class, member.username, member.age)).from(member).fetch();
			for (MemberDto m : result3) {
				System.out.println("memberDTO3 : " + m);
			}
			
			// 생성자 접근
			List<MemberDto> result4 = queryFactory
					.select(Projections.constructor(MemberDto.class, member.username, member.age)).from(member).fetch();
			for (MemberDto m : result4) {
				System.out.println("memberDTO4 : " + m);
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