package com.codingbox.jpaitem.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

// @Entity
@Getter @Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "member_seq", allocationSize = 1)
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
}
