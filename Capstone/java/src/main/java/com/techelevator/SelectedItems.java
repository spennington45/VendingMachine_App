package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class SelectedItems {

	private BigDecimal total = new BigDecimal(0.00);
	private String selectedItems = "";
	private List <String> inventory = new ArrayList <String> ();
	List <MasterItemType> readList = new ArrayList <MasterItemType> ();
	List <String> chipList = new ArrayList <String>();
	List <String> candyList = new ArrayList <String>();
	List <String> drinkList = new ArrayList <String>();
	List <String> gumList = new ArrayList <String>();
	
	
	public void getInventory() throws FileNotFoundException {
		File products = new File("vendingmachine.csv");
		if (products.exists()) {
			try (Scanner fileScanner = new Scanner(products)) {
				while (fileScanner.hasNextLine()) {
					String tempItem = fileScanner.nextLine();
					String [] item = tempItem.split("\\|");
						BigDecimal y = BigDecimal.valueOf(Double.parseDouble(item[2]));
						if (item[3].equals("Chip")) {
							Chip chip = new Chip(item[0], item[1], y);	
							readList.add(chip);
							chipList.add(item[1]);
						} else if (item[3].equals("Candy")) {
							Candy candy = new Candy(item[0], item[1], y);
							readList.add(candy);
							candyList.add(item[1]);
						} else if (item[3].equals("Drink")) {
							Drink drink = new Drink(item[0], item[1], y);	
							readList.add(drink);
							drinkList.add(item[1]);
						} else if (item[3].equals("Gum")) {
							Gum gum = new Gum(item[0], item[1], y);
							readList.add(gum);
							gumList.add(item[1]);
						}
					}
				
				}
		
			}
		System.out.println(readList.size());
		chipList.add("Back");
		candyList.add("Back");
		drinkList.add("Back");
		gumList.add("Back");
		}
		
	public List <MasterItemType> getInventoryList() {
		return readList;
	}
	public Object[] getChipList() {
		return chipList.toArray();
	}
	public Object[] getCandyList() {
		return candyList.toArray();
	}
	public Object[] getDrinkList() {
		return drinkList.toArray();
	}
	public Object[] getGumList() {
		return gumList.toArray();
	}
	
	public String addItemToPerchase(String str) {
		for (MasterItemType i : this.readList) {
			if (i.getName().equals(str)) {
				if (i.getQuantity() == 0) {
					System.out.println("Sorry " + str + " is out of stock!");
				} else {
					total = total.add(i.getPrice());
					selectedItems = (i.getName());
					i.quantityReduceBy1();
				}
			}
		}		
		return selectedItems;
	}
	
	
	public BigDecimal getTotal() {
		return this.total;
	}
	
}
