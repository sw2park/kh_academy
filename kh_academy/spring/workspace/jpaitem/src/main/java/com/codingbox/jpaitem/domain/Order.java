package com.codingbox.jpaitem.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name = "ORDERS")
@Getter @Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator2")
	@SequenceGenerator(name = "seq_generator2", sequenceName = "order_seq", allocationSize = 1)
	@Column(name = "ORDER_ID")
	private Long id;
//	@Column(name = "MEMBER_ID")
//	private Long memberId;
	private LocalDateTime orderDate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);
		this.orderItems.add(orderItem);
	}
}