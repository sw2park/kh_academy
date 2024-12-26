package com.codingbox.formUse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.formUse.dto.Item;
import com.codingbox.formUse.repository.ItemRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
// @RequiredArgsConstructor : 생성자를 자동으로 만들어준다.
public class BasicItemController {
	private final ItemRepository itemRepository;
	
	// @Autowired
	// 이렇게 생성자가 딱 1개만 있으면 스프링이 해당 생성자에게 @Autowired로 의존관계를 주입해준다. 
//	public BasicItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "basic/items";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		
		return "basic/item";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("item", new Item());
		
		return "basic/addForm";
	}
	
	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		
		model.addAttribute("item", item);
		
		return "/basic/editForm";
	}
	
	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable long itemId, @ModelAttribute Item item) {
		itemRepository.update(itemId, item);
		
		return "redirect:/basic/items/{itemId}";
	}
	
	//@PostMapping("/add")
	public String save(@RequestParam String itemName, @RequestParam int price, @RequestParam Integer quantity, Model model) {
		Item item = new Item();
		
		item.setItemName(itemName);
		item.setPrice(price);
		item.setQuantity(quantity);
		
		itemRepository.save(item);
		
		model.addAttribute("item", item);
		
		return "basic/item";
	}
	
	//@PostMapping("/add")
	public String saveV2(@ModelAttribute("item") Item item, Model model) {
		/*
		Item item = new Item();
		
		item.setItemName(itemName);
		item.setPrice(price);
		item.setQuantity(quantity);
		*/
		itemRepository.save(item);
		
		model.addAttribute("item", item);
		
		return "basic/item";
	}
	
	/*
	 *  @ModelAttribute("hello") Item item
	 *  model.addAttribute("hello", item);
	 */
	//@PostMapping("/add")
	public String saveV3(@ModelAttribute("item") Item item) {
		itemRepository.save(item);
		
		// @ModelAttribute가 해주는 역할
		// model.addAttribute("item", item);
		
		return "basic/item";
	}
	
	/*
	 * @ModelAttribute name 생략 가능
	 * 생략 시 model에 저장되는 name은 클래스명 첫 글자만 소문자로 등록 Item -> item
	 * model.addAttribute("item", item);
	 */
	//@PostMapping("/add")
	public String saveV4(@ModelAttribute Item item) {
		itemRepository.save(item);
		
		return "basic/item";
	}
	
	// @ModelAttribute 자체 생략 가능
	// 가독성을 위해서 적당히 줄이는 것을 권장
	//@PostMapping("/add")
	public String saveV5(Item item) {
		itemRepository.save(item);
		
		return "basic/item";
	}
	
	//@PostMapping("/add")
	public String saveV6(Item item) {
		itemRepository.save(item);
		
		return "redirect:/basic/items/" + item.getId();
	}
	
	@PostMapping("/add")
	public String saveV7(Item item, RedirectAttributes redirectAttributes) {
		Item savedItem = itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getId());
		redirectAttributes.addAttribute("status", "true");
		
		return "redirect:/basic/items/{itemId}";
		// /basic/items/3?status=true
	}
	
	// 테스트용 데이터를 추가
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("testA", 10000, 10));
		itemRepository.save(new Item("testB", 20000, 20));
	}
	
	@PostConstruct
	public void init2() {
		System.out.println("초기화 메서드");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("종료 메서드");
	}
}