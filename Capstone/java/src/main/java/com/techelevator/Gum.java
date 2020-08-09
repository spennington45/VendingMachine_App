package com.techelevator;
import java.math.BigDecimal;


public class Gum implements MasterItemType {

	private BigDecimal price;
	private String slot;
	private int quantity = 5;
	private String name;

	public Gum(String slot, String name, BigDecimal price) {
		this.slot = slot;
		this.price = price;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Gum [item=" + name + ", slot=" + slot + ", quantity=" + quantity + ", name=" + name + "]";
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
		return this.price;
	}
	
	public void quantityReduceBy1() {
		 quantity--;
	}

}
