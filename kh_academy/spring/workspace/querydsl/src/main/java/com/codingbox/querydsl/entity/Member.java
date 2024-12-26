package com.codingbox.querydsl.entity;

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
	@Id @Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator2")
	@SequenceGenerator(name = "seq_generator2", sequenceName = "member_seq", allocationSize = 1)
	private Long id;
	private String username;
	private int age;
	
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}
	
	public Member() {}
	
	public Member(String username) {
		this(username, 0);
	}
	
	public Member(String username, int age) {
		this(username, age, null);
	}
	
	public Member(String username, int age, Team team) {
		this.username = username;
		this.age = age;
		if(team != null) {
			changeTeam(team);
		}
	}

	@Override
	public String toString() {
		return "Member [id=" + id 
				+ ", username=" + username 
				+ ", age=" + age + "]";
	}
}