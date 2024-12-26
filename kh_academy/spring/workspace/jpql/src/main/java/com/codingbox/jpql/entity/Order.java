package com.codingbox.jpql.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator3")
	@SequenceGenerator(name = "seq_generator3", sequenceName = "order_seq", allocationSize = 1)
	private Long id;
	private int orderAmount;
	
	@Embedded
	private Address address;
	
}








