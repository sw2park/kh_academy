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
}