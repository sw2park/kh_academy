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

public class JpaMain8 {

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
			
			// 프로젝션
//			List resultList = 
//			em.createQuery("select m.username, m.age from Member m")
//			  .getResultList();
			
			// 타입을 지정할 수 없으니까 object로 받아온다. 
//			Object o = resultList.get(0);
//			Object[] result = (Object[])o;
//			System.out.println("username = " + result[0]);
//			System.out.println("age = " + result[1]);
			
			// dto에 값 세팅
			// new 명령어로 조회, 마치 생성자를 호출한 듯한 문법
			List<MemberDTO> result 
			= em.createQuery("select new com.codingbox.jpql.dto.MemberDTO(m.username, m.age) from Member m")
			    .getResultList();
			MemberDTO memberDTO = result.get(0);
			System.out.println("username : " + memberDTO.getUsername());
			System.out.println("age : " + memberDTO.getAge());
			
			
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






