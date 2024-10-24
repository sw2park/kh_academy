package com.codingbox.jpaitem.relation;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Getter @Setter
// @ToString
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator6")
	@SequenceGenerator(name = "seq_generator6", sequenceName = "team_seq", allocationSize = 1)
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;
	
	/*
	 * 매핑이 되어있는 team에 의해서 관리가 된다.
	 * mappedBy가 적힌 곳은 읽기만 가능하다.
	 * 값을 넣어봐야 아무일도 벌어지지 않는다.
	 * readonly 읽기만 가능하다. 
	 */
	@OneToMany(mappedBy = "team")
	private List<Member> member = new ArrayList<>();
	
	public void addMember(Member member) {
		member.setTeam(this);
		this.member.add(member);
	}

//	@Override
//	public String toString() {
//		return "Team [id=" + id + ", name=" + name + ", member=" + member + "]";
//	}
}