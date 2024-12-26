package com.codingbox.jpaitem;

import java.util.List;

import com.codingbox.jpaitem.relation.Member;
import com.codingbox.jpaitem.relation.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			/*
			 * - 양방향 매핑 시, 가장 많이하는 실수
			 * - insert는 두번 발생하나, db에 insert가 되지 않는다.
			 *   Team의 member는 읽기전용이기 때문
			 */
//			Member member = new Member();
//			member.setUsername("member11");
//			em.persist(member);
//			
//			Team team = new Team();
//			team.setName("TeamAA");
//			team.getMember().add(member);
//			em.persist(team);
			
			// 수정된 결과
			Team team = new Team();
			team.setName("TeamBB");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member22");
//			member.setTeam(team);
//			member.changeTeam(team);
			em.persist(member);
			
			team.addMember(member);
			
			/*
			 * member.changeTeam(team);
			 *  - 일반적인 setter의 형태(자바에서의 관례)가 아니면 메서드 이름을 바꿔준다.
			 *  - 그럼 추후 소스코드를 봤을때 단순 setter작업이 아닌 중요한 작업을 진행하는지를 파악할 수 있다.
			 */
			
			// 추가
			// 양방향 매핑시에는 양쪽에 값을 모두 입력해 주어야 한다.
			// DB를 다시 다녀오지 않고 객체 상태로만 사용할 수 있다.
			// team.getMember().add(member);
			
			// jpa입장에서는, 이 코드가 맞는 답이긴 하나, 객체지향적으로 생각하면 둘 다 넣어줘야 한다.
			
//			em.flush();
//			em.clear();
			
			/*
			 *  - em.flush(); em.clear(); 가 주석처리 되고 실행했을 때는 내가 원하는 값을 얻을 수 없다.
			 *  - insert문은 실행되고, select문은 실행되지 않는다.
			 *  - 이유 :
			 *  	-> team이 영속성 컨텍스트에 들어가 있는데, (1차 캐시) 현재 변경된 것을 감지하지 못한 상태
			 *  	   (flush가 호출되지 않은 상태)에서, 검색을 하니 select가 되지 않은 것.
			 *  	-> 즉, 1차 캐시에서 조회된 것이 그대로 나오게 된다.
			 *  - JPA에서 양방향 매핑을 사용할 때 데이터를 set해줄 때, 양쪽으로 다 넣어 줘야한다.
			 *  - 객체 지향적으로 생각해봐도 양쪽으로 다 넣어줘야한다.
			 */
			System.out.println("-----------------------------------------------");
			
			Team findTeam = em.find(Team.class, team.getId());
			List<Member> members = findTeam.getMember();
			
			for(Member m : members) {
				System.out.println("m = " + m.getUsername());
			}
			
			System.out.println("-----------------------------------------------");
			
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
