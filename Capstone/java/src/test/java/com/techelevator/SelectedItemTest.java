package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class SelectedItemTest {

	SelectedItems item = new SelectedItems();
	@Test
	public void getTotalTest() {
		assertEquals(new BigDecimal(0.0), item.getTotal());
	}
	
}
