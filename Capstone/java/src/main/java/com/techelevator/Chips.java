package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Chips implements MasterItemType {

	private Map <String, BigDecimal> item = new HashMap <String, BigDecimal> ();
	private String slot;
	private int quantity = 5;
	private String name;

	

	public Chips(String slot, String name, BigDecimal price) {
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

}
