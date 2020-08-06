package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Drink implements MasterItemType {

		private Map <String, BigDecimal> item = new HashMap <String, BigDecimal> ();
		private String slot;
		private int quantity = 5;
		private String name;

		public Drink(Map<String, BigDecimal> item, String slot, String name, BigDecimal price) {
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
		public BigDecimal getPrice() {
			// TODO Auto-generated method stub
			return item.get(name);
		}
}
