package com.codingbox.jpaitem.relation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Getter @Setter
// @ToString
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
	 * 
	 * - 외래키가 있는 객체가 주인이다.
	 */
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
//	@Setter(value = AccessLevel.NONE) // lombok에서 자동 setter 생성 막아주기
	private Team team;

	// setter메서드 사용자 정의로 만들어 준 후, 
//	public void changeTeam(Team team) {
//		this.team = team;
//		// 해당 로직을 setter에다가 넣어준다.
//		team.getMember().add(this);
//	}

//	@Override
//	public String toString() {
//		return "Member [id=" + id + ", username=" + username + ", team=" + team + "]";
//	}
	
//	@Column(name = "TEAM_ID")
//	private Long teamId;
}