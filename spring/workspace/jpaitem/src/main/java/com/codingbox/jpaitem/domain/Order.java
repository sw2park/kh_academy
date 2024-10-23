package com.codingbox.jpaitem.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// @Entity
@Table(name = "ORDERS")
@Getter @Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator2")
	@SequenceGenerator(name = "seq_generator2", sequenceName = "order_seq", allocationSize = 1)
	@Column(name = "ORDER_ID")
	private Long id;
	@Column(name = "MEMBER_ID")
	private Long memberId;
	private LocalDateTime orderDate;
	private String status;
}