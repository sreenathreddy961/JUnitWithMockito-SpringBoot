package com.practice.unit_testing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Item {

	@Id
	private int id;
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	@Transient
	private int value;

	protected Item() {
		
	}
	public Item(int id, String itemName, int itemPrice, int itemQuantity) {
		
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		
	}

	public int getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuntity=" + itemQuantity
				+ "]";
	}

}
