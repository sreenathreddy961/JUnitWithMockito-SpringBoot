package com.practice.unit_testing.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.unit_testing.model.Item;
import com.practice.unit_testing.repository.ItemRepo;

@Service
public class ItemService {

	@Autowired
	ItemRepo itemRepo;
	
	public Item fetchAllItems() {
		return new Item(1, "Table", 10, 100);
	}
	
	public List<Item> fetchAllItemsFromDB(){
		
		List<Item> itemList = itemRepo.findAll();
		for(Item item : itemList) {
			item.setValue(item.getItemPrice() * item.getItemQuantity());
		}
		return itemList;
	}

}
