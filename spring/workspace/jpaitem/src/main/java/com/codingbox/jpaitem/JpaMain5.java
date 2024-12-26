package com.codingbox.jpaitem;

import java.time.LocalDateTime;

import com.codingbox.jpaitem.embedded.Address;
import com.codingbox.jpaitem.embedded.Member;
import com.codingbox.jpaitem.embedded.Period;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain5 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Address address = new Address("서울", "역삼", "123");
			
			Member member = new Member();
			member.setUsername("user1");
			member.setAddress(address);
			em.persist(member);
			
			// 기존 address를 복사해서 넣어준다.
			Address copyAddr = new Address(address.getCity(), address.getStreet(), address.getZipcode());
			
			Member member2 = new Member();
			member2.setUsername("user2");
			member2.setAddress(copyAddr);
			em.persist(member2);
			
			// user1의 주소를 newCity 변경하고 싶다.
			// member.getAddress().setCity("newCity");
			
			Address addrNew = new Address("newCity", "역삼", "123");
			// 즉, 값을 하나만 바꾸는게 아니라 address를 통으로 갈아끼운다.
			member.setAddress(addrNew);
			em.persist(member);
			
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
