package com.codingbox.jpql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// mm이 엔티티 이름이다. 
// jpql에서도 mm으로 써야한다. 보통은 기본을 쓴다.
@Entity //(name = "mm")
@Getter @Setter @ToString
public class Member {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "member_seq", allocationSize = 1)
	@Id
	private Long id;
	private String username;
	private int age;
	
	// 연관관계 매핑
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}
}








