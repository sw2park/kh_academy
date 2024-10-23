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
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator4")
	@SequenceGenerator(name = "seq_generator4", sequenceName = "orderitem_seq", allocationSize = 1)
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	@Column(name = "ORDER_ID")
	private Long orderId;
	@Column(name = "ITEM_ID")
	private Long itemId;
	private int orderPrice;
	private int count;
}