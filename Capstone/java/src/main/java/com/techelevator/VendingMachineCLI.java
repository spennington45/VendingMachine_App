package com.techelevator;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String [] PURCHESE_MENU = {"Feed Money", "Select Product", "Finish Transaction", "Back"};
	private static final String [] MONEY_MENU = {"$1.00", "$2.00", "$5.00", "$10.00", "Back"};
	private static final String [] SELECT_PRODUCT = {"Chip", "Candy", "Drink", "Gum", "Back"};
	private static  Object[] SELECT_CHIP;
	private static  Object[] SELECT_CANDY;
	private static  Object[] SELECT_DRINK;
	private static  Object[] SELECT_GUM;
	private Menu menu;
	private CustomerBalance customer = new CustomerBalance();
	private List <String> selectedItems = new ArrayList <String> ();
	static List <MasterItemType> inventory = new ArrayList <MasterItemType> ();
	static SelectedItems item = new SelectedItems();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				readProducts();
				System.out.println("Current Money Provided: $" + customer.getCurrentBalance());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Current Money Provided: $" + customer.getCurrentBalance());
				processPurchaseMenuOption();
			} else {
				System.exit(0);
			}
		}
	}

	private void processPurchaseMenuOption() throws FileNotFoundException {
		String purchaseMenuOption = "";
		while (!purchaseMenuOption.equals("Back")) {
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHESE_MENU);
			if (purchaseMenuOption.equals("Feed Money")) {
				processMoneyFeed();
			} else if (purchaseMenuOption.equals("Select Product")) {
				selectProduct();
			} else if (purchaseMenuOption.equals("Finish Transaction")) {
				finishTransaction();
			}
		}
		System.out.println("Current Money Provided: $" + customer.getCurrentBalance());
	}


	private void selectProduct() throws FileNotFoundException {
		System.out.println("Current Money Provided: $" + customer.getCurrentBalance());
		System.out.println("Please enter the code for the item you wish to perchis");
		String itemSelected = "";
		String chipSelected = "";
		String candySelected = "";
		String drinkSelected = "";
		String gumSelected = "";
		while (!itemSelected.equals("Back")) {
			itemSelected = (String) menu.getChoiceFromOptions(SELECT_PRODUCT);
			if (itemSelected.equals("Chip")) {
				chipSelected = (String) menu.getChoiceFromOptions(SELECT_CHIP);
				if (!chipSelected.contentEquals("Back")) {
					selectedItems.add(item.addItemToPerchase(chipSelected));
				}
			} else if (itemSelected.equals("Candy")) {
				candySelected = (String) menu.getChoiceFromOptions(SELECT_CANDY);
				if (!candySelected.contentEquals("Back")) {
					selectedItems.add(item.addItemToPerchase(candySelected));
				}
			} else if (itemSelected.equals("Drink")) {
				drinkSelected = (String) menu.getChoiceFromOptions(SELECT_DRINK);
				if (!drinkSelected.contentEquals("Back")) {
					selectedItems.add(item.addItemToPerchase(drinkSelected));
				}
			} else if (itemSelected.equals("Gum")) {
				gumSelected = (String) menu.getChoiceFromOptions(SELECT_GUM);
				if (!gumSelected.contentEquals("Back")) {
					selectedItems.add(item.addItemToPerchase(gumSelected));
				}
			}
		}
		System.out.println(selectedItems.toString());
	}

	private void finishTransaction() throws FileNotFoundException {
		System.out.flush();  
		if (customer.getCurrentBalance().compareTo(item.getTotal()) == -1) {
			System.out.println("Sorry you do not have enough money to finish this transaction. Please add more money.");
			processPurchaseMenuOption();
		} else {
			customer.subFromCurrentBalance(item.getTotal());
			System.out.println(customer);
			run();
		}
		
	}


	private void processMoneyFeed() {
		String feedOptions = "";
		while (!feedOptions.equals("Back")) {
			feedOptions = (String) menu.getChoiceFromOptions(MONEY_MENU);	
			if (!feedOptions.equals("Back")) {
				BigDecimal x = BigDecimal.valueOf(Double.parseDouble(feedOptions.replace("$", "")));
				customer.addToCurrentBalance(x.setScale(2));
				System.out.println("Current Money Provided: $" + customer.getCurrentBalance());				
			}
		}
		System.out.println("Current Money Provided: $" + customer.getCurrentBalance());
	}

	public static void main(String[] args) throws FileNotFoundException {
		item.getInventory();
		SELECT_CHIP = item.getChipList();
		SELECT_CANDY = item.getCandyList();
		SELECT_DRINK = item.getDrinkList();
		SELECT_GUM = item.getGumList();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	
	public static void readProducts() throws FileNotFoundException {
		File products = new File("vendingmachine.csv");
		List <String> readList = new ArrayList <String> ();
		if (products.exists()) {
			try (Scanner fileScanner = new Scanner(products)) {
				while (fileScanner.hasNextLine()) {
				String items = fileScanner.nextLine();
				readList.add(items);
				}
			} 
		}
		for (String i : readList) {
			System.out.println(i);
		}
		
	}
	

	
}
