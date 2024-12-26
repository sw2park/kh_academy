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

public class JpaMain9 {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		// transaction : 하나의 작업단위
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			for(int i=0; i<100; i++) {
				Member member = new Member();
				member.setUsername("member" + i);
				member.setAge(i);
				em.persist(member);
			}
			
			em.flush();
			em.clear();
			
			// 페이징 처리
			String jqpl = "select m from Member m order by m.age asc";
			List<Member> resultList = 
					em.createQuery(jqpl, Member.class)
					  .setFirstResult(0)
					  .setMaxResults(20)
					  .getResultList();
			
			System.out.println("result.size : " + resultList.size());
			
			for( Member m : resultList ) {
				System.out.println("member : " + m.toString());
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






