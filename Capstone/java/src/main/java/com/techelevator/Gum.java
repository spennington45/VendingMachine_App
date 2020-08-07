package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Gum implements MasterItemType {

	private Map <String, BigDecimal> item = new HashMap <String, BigDecimal> ();
	private String slot;
	private int quantity = 5;
	private String name;

	public Gum(String slot, String name, BigDecimal price) {
		this.slot = slot;
		this.item.put(name,price);
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String toString() {
		return "Gum [item=" + item + ", slot=" + slot + ", quantity=" + quantity + ", name=" + name + "]";
	}

	@Override
	public String getSlot() {
		// TODO Auto-generated method stub
		return slot;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	@Override
	public BigDecimal getPrice(String name) {
		// TODO Auto-generated method stub
		return item.get(name);
	}
	
	public void quantityReduceBy1() {
		 quantity--;
	}

}
