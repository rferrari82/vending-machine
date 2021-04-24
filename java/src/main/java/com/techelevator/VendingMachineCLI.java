package com.techelevator;

import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = {"Feed Money", "Select Product", "Finish Transaction"};
	private static final String[] MONEY_OPTIONS = {"$1", "$2","$5", "$10", "Back"};
	private VendingMachine vendingMachine;
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				handleDisplayProducts();
				//vendingMachine.displayProducts();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				handlePurchaseOptions();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void handlePurchaseOptions(){
		boolean stay = true;

		while(stay) {
			String currentMoney = "Current Money Provided: $" + vendingMachine.getBalance().setScale(2, RoundingMode.HALF_UP).toString();
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, currentMoney);
			if(choice.equals("Feed Money")){
				handleFeedMoney();
			} else if(choice.equals("Select Product")){
				handleSelectProduct();
			} else if(choice.equals("Finish Transaction")){
				handleFinishTransaction();
				stay = false;
			}
		}
	}

	public void handleFeedMoney(){
		boolean stay = true;
		while(stay){
			String choice = (String) menu.getChoiceFromOptions(MONEY_OPTIONS);
			if(choice.equals("$1")){
				vendingMachine.feedMoney(new BigDecimal(1));
			} else if(choice.equals("$2")){
				vendingMachine.feedMoney(new BigDecimal(2));
			}
			else if(choice.equals("$5")){
				vendingMachine.feedMoney(new BigDecimal(5));
			}
			else if(choice.equals("$10")){
				vendingMachine.feedMoney(new BigDecimal(10));
			}
			else if(choice.equals("Back")){
				stay = false;
			}

		}
	}

	public void handleSelectProduct() {
		String choice = (String) menu.getChoiceFromOptions(vendingMachine.getProducts(true));
		System.out.println(vendingMachine.handlePurchase(choice));
		//System.out.println(choice);
	}

	public void handleDisplayProducts() {
		System.out.println();
		String[] products = vendingMachine.getProducts(false);
		for (String s : products) {
			System.out.println(s);
		}
	}

	public void handleFinishTransaction(){
		System.out.println(vendingMachine.completePurchase());

	}

}
