package com.codingbox.mylogin.web.item.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.mylogin.web.item.dto.Item;
import com.codingbox.mylogin.web.item.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
	private final ItemRepository itemRepository;
	
	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "items/items";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		
		return "items/item";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("item", new Item());
		
		return "items/addForm";
	}
	
	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		
		model.addAttribute("item", item);
		
		return "/items/editForm";
	}
	
	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable long itemId, @ModelAttribute Item item) {
		itemRepository.update(itemId, item);
		
		// 로그인 여부 체크
		
		return "redirect:/items/items/{itemId}";
	}
	
	@PostMapping("/add")
	public String saveV7(Item item, RedirectAttributes redirectAttributes) {
		Item savedItem = itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getId());
		redirectAttributes.addAttribute("status", "true");
		
		return "redirect:/items/items/{itemId}";
	}
	
//	// 테스트용 데이터를 추가
//	@PostConstruct
//	public void init() {
//		itemRepository.save(new Item("testA", 10000, 10));
//		itemRepository.save(new Item("testB", 20000, 20));
//	}
}