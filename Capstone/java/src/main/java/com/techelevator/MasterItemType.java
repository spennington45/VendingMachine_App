package com.techelevator;

import java.math.BigDecimal;

public interface MasterItemType {

	
	public String getName();
	public String getSlot();
	public int getQuantity();
	public BigDecimal getPrice();
	public void quantityReduceBy1();
	
}
