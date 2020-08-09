package com.techelevator;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class SelectedItemTest {

	SelectedItems item = new SelectedItems();
	@Test
	public void getTotalTest() {
		assertEquals(new BigDecimal(0.0), item.getTotal());
	}
	
	@Test
	public void getInventoryAndMenuListsTest() {
		int result = 0;
		try {
			FileReader       input = new FileReader("vendingmachine.csv");
			LineNumberReader count = new LineNumberReader(input);
			while (count.skip(Long.MAX_VALUE) > 0) {
			   }
			result = count.getLineNumber() + 1;
			count.close();
			assertEquals(result, item.getInventory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// subtract 1 from each list to get rid of "Back"
		int listSum = item.getChipList().length - 1 + item.getCandyList().length - 1 + item.getDrinkList().length - 1 + item.getGumList().length - 1;
		assertEquals(result, listSum);
	}
	
	public void addItemToPerchaseTest() {
		assertEquals("", item.addItemToPerchase("Does not exist"));
		List <MasterItemType> newList = item.getInventoryList();
		//Come back to this and figure out how to test this
	}
	
}
