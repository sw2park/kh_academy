package com.codingbox.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.shop.domain.Item;
import com.codingbox.shop.dto.ItemForm;
import com.codingbox.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	@Autowired // 생략 가능
	private final ItemService itemService;
	
	@GetMapping("/items/new")
	public String createForm(Model model) {
		model.addAttribute("form", new ItemForm());
		return "/items/createItemForm.html";
	}
	
	@PostMapping("/items/new")
	public String create(ItemForm form) {
		Item item = new Item();
		
		item.setName(form.getName());
		item.setPrice(form.getPrice());
		item.setStockQuantity(form.getStockQuantity());
		
		itemService.saveItem(item);
		
		return "redirect:/";
	}
	
	@GetMapping("/items")
	public String list(Model model) {
		List<Item> items = itemService.findItems();
		model.addAttribute("items", items);
		
		return "items/itemList";
	}
}