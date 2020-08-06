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
	private static final String [] SELECT_PRODUCT = {"Chips", "Candy", "Drinks", "Gum", "Back"};
	private static final String [] SELECT_CHIP = {"Potato Crisps", "Stackers", "Grain Waves", "Cloud Popcorn", "Back"};
	private Menu menu;
	private CustomerBalance customer = new CustomerBalance();
	private List <String> selectedItems = new ArrayList <String> ();

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
		SelectedItems item = new SelectedItems();
		System.out.println("Current Money Provided: $" + customer.getCurrentBalance());
		System.out.println("Please enter the code for the item you wish to perchis");
		item.getInventory();
		String itemSelected = "";
		String chipSelected = "";
		String candySelected = "";
		String drinkSelected = "";
		String gumSelected = "";
		itemSelected = (String) menu.getChoiceFromOptions(SELECT_PRODUCT);
		while (!itemSelected.equals("Back")) {
			if (itemSelected.equals("Chip")) {
				chipSelected = (String) menu.getChoiceFromOptions(SELECT_CHIP);
				item.addItemToPerchase(chipSelected);
			} else if (itemSelected.equals("Candy")) {
				System.out.println("Do stuff");
			} else if (itemSelected.equals("Drink")) {
				System.out.println("Do stuff");
			} else if (itemSelected.equals("Gum")) {
				System.out.println("Do stuff");
			}
		}
	}

	private void finishTransaction() throws FileNotFoundException {
		System.out.flush();  
		CustomerBalance finalBalance = new CustomerBalance();
		customer.getCurrentBalance();
        System.out.println("$" + customer.getCurrentBalance());
    	System.out.flush();  
        run();
		
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
