package com.codingbox.querydsl.entity;

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
	@Id @Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator3")
	@SequenceGenerator(name = "seq_generator3", sequenceName = "team_seq", allocationSize = 1)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();
	
	public Team() {}
	
	public Team(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + 
				", name=" + name + "]";
	}
}