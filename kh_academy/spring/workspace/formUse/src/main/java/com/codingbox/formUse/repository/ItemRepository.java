package com.codingbox.formUse.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingbox.formUse.dto.Item;

@Repository
public class ItemRepository {
	private static final Map<Long, Item> store = new HashMap<>();
	private static long sequence = 0L;
	
	// 저장
	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		
		return item;
	}
	
	// 검색
	public Item findById(Long id) {
		return store.get(id);
	}
	
	// 전체검색
	public List<Item> findAll(){
		return new ArrayList<Item>(store.values());
	}
	
	// 수정
	public void update(Long itemId, Item updateParam) {
		Item findItem = findById(itemId);
		findItem.setItemName(updateParam.getItemName());
		findItem.setPrice(updateParam.getPrice());
		findItem.setQuantity(updateParam.getQuantity());
	}
}