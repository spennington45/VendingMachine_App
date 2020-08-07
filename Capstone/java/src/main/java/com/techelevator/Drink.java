package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
			// TODO Auto-generated method stub
			return name;
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

		
		public void quantityReduceBy1() {
			 quantity--;
		}

		@Override
		public BigDecimal getPrice() {
			return this.price;
		}
}
