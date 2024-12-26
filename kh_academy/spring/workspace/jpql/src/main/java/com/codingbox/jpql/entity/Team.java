package com.codingbox.jpql.entity;

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

@Entity
@Getter @Setter
public class Team {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator2")
	@SequenceGenerator(name = "seq_generator2", sequenceName = "team_seq", allocationSize = 1)
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;
	
	// 양방향
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();
}








