package com.codingbox.jpaitem.relation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator6")
	@SequenceGenerator(name = "seq_generator6", sequenceName = "team_seq", allocationSize = 1)
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;
}