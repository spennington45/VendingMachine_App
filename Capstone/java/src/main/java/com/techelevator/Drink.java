package com.techelevator;

import java.math.BigDecimal;


public class Drink implements MasterItemType {

		@Override
	public String toString() {
		return "Drink [item=" + name + ", slot=" + slot + ", quantity=" + quantity + ", name=" + name + "]";
	}

		private BigDecimal price;
		private String slot;
		private int quantity = 5;
		private String name;

		public Drink(String slot, String name, BigDecimal price) {
			this.slot = slot;
			this.price= price;
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

		
		public void quantityReduceBy1() {
			 quantity--;
		}

		@Override
		public BigDecimal getPrice() {
			return this.price;
		}
}
