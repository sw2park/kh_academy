package com.codingbox.shop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
public class Member {

	@Id 
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "member_seq", allocationSize = 1)
	private Long id;
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();
}









