package com.codingbox.jpaitem.relation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator5")
	@SequenceGenerator(name = "seq_generator5", sequenceName = "member2_seq", allocationSize = 1)
	@Column(name = "MEMBER_ID")
	private Long id;
	private String username;
	
	/*
	 * 1대다의 개념을 알려줘야 한다.
	 * DB의 기준으로 1대다의 개념을 알려줘야한다.
	 * @ManyToOne : 여기선 team이 하나이다.
	 * @JoinColumn(name = "TEAM_ID") : 관계 컬럼을 적어준다. TEAM_ID와 조인해야 한다. 
	 */
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
//	@Column(name = "TEAM_ID")
//	private Long teamId;
}