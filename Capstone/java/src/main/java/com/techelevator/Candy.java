package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Candy implements MasterItemType {

	@Override
	public String toString() {
		return "Candy [item=" + item + ", slot=" + slot + ", quantity=" + quantity + ", name=" + name + "]";
	}

	private Map <String, BigDecimal> item = new HashMap <String, BigDecimal> ();
	private String slot;
	private int quantity = 5;
	private String name;

	

	public Candy(String slot, String name, BigDecimal price) {
		this.slot = slot;
		this.item.put(name,price);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSlot() {
		return slot;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public BigDecimal getPrice() {
		return item.get(name);
	}
	
	public void quantityReduceBy1() {
		 quantity--;
	}

}
