package com.codingbox.shop.domain;

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
public class Item {

	@Id @Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator4")
	@SequenceGenerator(name = "seq_generator4", sequenceName = "item_seq", allocationSize = 1)
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
	// ============== 비즈니스 로직 ==================
	public void removeStock(int count) {
		int restStock = this.stockQuantity - count;
		
		// 재고 부족시 로직 처리
		if(restStock < 0) {
			// 예외처리
		}
		
		this.stockQuantity = restStock;
	}
}