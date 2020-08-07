package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemClassTest {

	Chip chip = new Chip("A1", "myChips", new BigDecimal(1.13));
	@Test
	public void chipTest() {
		assertEquals("A1", chip.getSlot());
		assertEquals("myChips", chip.getName());
		assertEquals(new BigDecimal(1.13), chip.getPrice());
	}
	
	@Test
	public void chipTestQuantity () {
		assertEquals(5, chip.getQuantity());
		chip.quantityReduceBy1();
		assertEquals(4, chip.getQuantity());
	}

	Candy candy = new Candy("A1", "myChips", new BigDecimal(1.13));
	@Test
	public void candyTest() {
		assertEquals("A1", candy.getSlot());
		assertEquals("myChips", candy.getName());
		assertEquals(new BigDecimal(1.13), candy.getPrice());
	}
	
	@Test
	public void candyTestQuantity () {
		assertEquals(5, candy.getQuantity());
		candy.quantityReduceBy1();
		assertEquals(4, candy.getQuantity());
	}
	
	Drink drink = new Drink("A1", "myChips", new BigDecimal(1.13));
	@Test
	public void drinkTest() {
		assertEquals("A1", drink.getSlot());
		assertEquals("myChips", drink.getName());
		assertEquals(new BigDecimal(1.13), drink.getPrice());
	}
	
	@Test
	public void drinkTestQuantity () {
		assertEquals(5, drink.getQuantity());
		drink.quantityReduceBy1();
		assertEquals(4, drink.getQuantity());
	}
	
	Gum gum = new Gum("A1", "myChips", new BigDecimal(1.13));
	@Test
	public void gumTest() {
		assertEquals("A1", gum.getSlot());
		assertEquals("myChips", gum.getName());
		assertEquals(new BigDecimal(1.13), gum.getPrice());
	}
	
	@Test
	public void gumTestQuantity () {
		assertEquals(5, gum.getQuantity());
		gum.quantityReduceBy1();
		assertEquals(4, gum.getQuantity());
	}
	
}
