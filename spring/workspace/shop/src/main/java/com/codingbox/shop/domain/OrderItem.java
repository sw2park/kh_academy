package com.codingbox.shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {

	@Id @Column(name = "order_item_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator3")
	@SequenceGenerator(name = "seq_generator3", sequenceName = "order_item_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	private int orderPrice;
	private int count;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	
	// =========== 비즈니스 로직 =============
	public static OrderItem createOrderItem(Item item, int price, int count) {
		OrderItem orderItem = new OrderItem();
		
		orderItem.setItem(item);
		orderItem.setOrderPrice(price);
		orderItem.setCount(count);
		
		// 재고조정 -> 주문한 만큼 재고조정 필요(item)
		item.removeStock(count);
		
		return orderItem;
	}
}