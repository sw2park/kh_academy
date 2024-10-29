package com.codingbox.shop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingbox.shop.domain.Item;
import com.codingbox.shop.dto.ItemForm;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
	@Autowired // 생략 가능
	private final EntityManager em;
	
	// 상품 저장
	public void save(Item item) {
//		if(item.getId() == null) {
//			// 신규 등록
//			em.persist(item);
//		} else {
//			// update
//			em.merge(item);
//		}
		em.persist(item);
	}
	
	// Item key값으로 하나 조회
	public Item findOne(Long id) {
		return em.find(Item.class, id);
	}
	
	// 여러건 조회
	public List<Item> findAll(){
		return em.createQuery("select i from Item i", Item.class).getResultList();
	}
}