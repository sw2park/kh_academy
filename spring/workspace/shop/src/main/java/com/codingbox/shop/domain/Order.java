package com.codingbox.shop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator2")
	@SequenceGenerator(name = "seq_generator2", sequenceName = "order_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	private LocalDateTime orderDate;
	
	// 주문상태
	// ORDER, CANCEL
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public void setMember(Member member) {
		this.member = member;
		member.getOrders().add(this);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
}