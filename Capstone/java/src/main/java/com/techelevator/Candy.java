package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Candy implements MasterItemType {

	private Map <String, BigDecimal> item = new HashMap <String, BigDecimal> ();
	private String slot;
	private int quantity;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSlot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
