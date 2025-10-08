package com.practice.unit_testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.unit_testing.model.Item;
import com.practice.unit_testing.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Table", 10, 100);
	}
	
	@GetMapping("/item-from-service")
	public Item itemFromServiceLayer() {
		return itemService.fetchAllItems();
	}
	
	@GetMapping("/items-from-db")
	public List<Item> itemFromDB() {
		
		return itemService.fetchAllItemsFromDB();
	}
}
