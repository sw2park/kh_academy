package com.codingbox.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.shop.domain.Item;
import com.codingbox.shop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
	@Autowired // 생략 가능 
	private final ItemRepository itemRepository;
	
	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	public List<Item> findItems(){
		return itemRepository.findAll();
	}
	
	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}
	
	@Transactional
	public Item updateItem(Long itemId, Item param) {
		// 영속상태
		Item findItem = itemRepository.findOne(itemId);
		
		findItem.setPrice(param.getPrice());
		// findItem.setName(param.getName());
		findItem.setStockQuantity(param.getStockQuantity());
		
		/*
		 * 영속성 컨텍스트 영역에서는 save or merge를 호출할 필요가 전혀 없다.
		 * 영속성 컨텍스트에 변화가 일어나게 되고, 변화가 일어나는 것을 jpa가 감지하게 된다.
		 * 따라서 나는 spring의 Transactional에서 commit이 일어나고 영속성 컨텍스트가 flush를 날리게 된다.
		 * flush : 영속성 컨텍스트에서 변화가 생긴 부분을 감지 후 -> update 요청
		 * => 변경감지에 의해서 데이터를 update 하는 방법
		 */
		
		return findItem;
	}

	@Transactional
	public void updateItem(Long itemId, String name, int price, int stockQuantity) {
		Item findItem = itemRepository.findOne(itemId);
		
		findItem.setName(name);
		findItem.setPrice(price);
		findItem.setStockQuantity(stockQuantity);
	}
}