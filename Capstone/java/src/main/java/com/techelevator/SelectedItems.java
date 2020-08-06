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
	private List <String> selectedItems = new ArrayList <String> ();
	private List <String> inventory = new ArrayList <String> ();
	List <MasterItemType> readList = new ArrayList <MasterItemType> ();
	private Menu menu;
	private static final String [] SELECT_PRODUCT = {"Chips", "Candy", "Drinks", "Gum", "Back"};
	private static final String [] SELECT_CHIP = {"Potato Crisps", "Stackers", "Grain Waves", "Cloud Popcorn", "Back"};
	
	
	public List <MasterItemType> getInventory() throws FileNotFoundException {
		File products = new File("vendingmachine.csv");
		if (products.exists()) {
			try (Scanner fileScanner = new Scanner(products)) {
				while (fileScanner.hasNextLine()) {
					String tempItem = fileScanner.nextLine();
					String [] item = tempItem.split("\\|");
					for (int i = 0; i < item.length; i++) {
						BigDecimal y = BigDecimal.valueOf(Double.parseDouble(item[2]));
						if (item[3].equals("Chip")) {
							Chip chip = new Chip(item[0], item[1], y);	
							readList.add(chip);
						} else if (item[3].equals("Candy")) {
							Candy candy = new Candy(item[0], item[1], y);
							readList.add(candy);
						} else if (item[3].equals("Drink")) {
							Chip drink = new Chip(item[0], item[1], y);	
							readList.add(drink);
						} else if (item[3].equals("Gum")) {
							Chip gum = new Chip(item[0], item[1], y);
							readList.add(gum);
						}
					}
				}
			} 
		}
		return readList;
	}
	
	public void addItemToPerchase(String str) {
		String itemSelected = "";
		String chipSelected = "";
		String candySelected = "";
		String drinkSelected = "";
		String gumSelected = "";
		while (!itemSelected.equals("Back")) {
			if (itemSelected.equals("Chip")) {
				for (MasterItemType i : readList) {
					if (i.getName().equals(itemSelected)) {
						total.add(i.getPrice());
						selectedItems.add(i.getName());
					}
				}
				chipSelected = (String) menu.getChoiceFromOptions(SELECT_CHIP);
			} else if (itemSelected.equals("Candy")) {
				System.out.println("Do stuff");
			} else if (itemSelected.equals("Drink")) {
				System.out.println("Do stuff");
			} else if (itemSelected.equals("Gum")) {
				System.out.println("Do stuff");
			}
		}
	}
	
	public BigDecimal getTotal() {
		return this.total;
	}
	
}
