package com.nissan.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.model.Category;
import com.nissan.model.Item;

public class ItemUtilities {

	private static List<Item> items = new ArrayList<Item>();
	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);

	public static void addItems() {

		// declaring variables
		String itemName;
		double buyingPrice;
		double sellingPrice;
		int quantity;
		int categoryId;
		char choice = 'n';

		try {
			do {
				System.out.println("ADD NEW ITEM");

				// getting itemName
				System.out.print("Enter item name: ");
				itemName = getValidItemName(scanner.nextLine());

				// getting buying Price
				System.out.print("Enter buying Price: ");
				buyingPrice = Double.parseDouble(getValidAmount(scanner.nextLine()));

				// getting selling Price
				System.out.print("Enter selling Price: ");
				sellingPrice = Double.parseDouble(getValidAmount(scanner.nextLine()));

				// displaying category and getting category id
				do {
					CategoryUtilities.displayAllCategories();
					System.out.print("Please select any of the category ID from the above list: ");
					categoryId = Integer.parseInt(scanner.nextLine());

					if (CategoryUtilities.getCategory(categoryId) == null) {
						System.out.print("Category does not exist. Please try again: ");
					} else
						break;

				} while (true);

				// getting quantity
				System.out.print("Enter quantity: ");
				quantity = Integer.parseInt(getValidAmount(scanner.nextLine()));

				// inserting item into list
				items.add(new Item(itemName, buyingPrice, sellingPrice, quantity, categoryId));
				System.out.println("Item added");

				// prompting user for another item addition
				System.out.print("Do you want to add another item? (Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static String getValidAmount(String amount) {
		try {
			// defining pattern
			Pattern amountPattern = Pattern.compile("[^0-9.]");

			do {

				// defining matcher
				Matcher amountMatcher = amountPattern.matcher(amount);
				boolean finder = amountMatcher.find();

				// validating for anything other than numbers
				if (finder) {
					System.out.print("Field should contain only numbers. Please re-enter: ");
					amount = scanner.nextLine();
				} else if (amount.length() <= 0) {
					System.out.print("Field should not be blank. Please re-enter: ");
					amount = scanner.nextLine();
				} else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		return amount;
	}

	private static String getValidItemName(String itemName) {
		try {
			// defining pattern
			Pattern namePattern = Pattern.compile("[^A-Za-z ]");

			do {

				// defining matcher
				Matcher nameMatcher = namePattern.matcher(itemName);
				boolean finder = nameMatcher.find();

				// validating for anything other than alphabets
				if (finder) {
					System.out.print("Item Name should contain only alphabets. Please re-enter: ");
					itemName = scanner.nextLine();
				} else if (itemName.length() <= 0) {
					System.out.print("Item Name should not be blank. Please re-enter: ");
					itemName = scanner.nextLine();
				} else if (itemName.length() > 30) {
					System.out.print("Item Name should have only 20 characters. Please re-enter: ");
					itemName = scanner.nextLine();
				} else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return itemName;
	}

	public static void listItems() {
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------Item List-----------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-15s%-35s%-20s%-20s%-25s%-10s%-10s", "Item Code", "Item Name","Buying Price", "Selling Price", "Category Name", "Tax%", "Quantity"));
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(Item i : items ) {
			Category category = null;
			category = CategoryUtilities.getCategory(i.getCategoryId());
			System.out.println(String.format("%-15s%-35s%-20s%-20s%-25s%-10s%-10s", i.getItemCode(), i.getItemName(),i.getBuyingPrice(), i.getSellingPrice(), category.getCategoryName(), category.getTax(), i.getQuantity()));
		}
	}
	
	public static void search() {
		int choice;
		try {
			System.out.println("SEARCH ITEMS");
			System.out.print("1. Search by ItemCode\n2. Search by Item Name\nPlease select an option to proceed: ");
			choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			
			case 1:
				searchByItemCode();
				break;
			case 2: 
				searchByItemName();
				break;
			default:
				System.out.println("Invalid Selection");
			}
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void searchByItemCode() {
		int flag = 0;
		int code;
		try {
			System.out.print("Please enter the Item code to be searched: ");
			code = Integer.parseInt(scanner.nextLine());
			
			for(Item i : items) {
				if(i.getItemCode() == code) {
					System.out.println("ITEM FOUND");
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println(String.format("%-15s%-35s%-20s%-20s%-25s%-10s%-10s", "Item Code", "Item Name","Buying Price", "Selling Price", "Category Name", "Tax%", "Quantity"));
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
					Category category = null;
					category = CategoryUtilities.getCategory(i.getCategoryId());
					System.out.println(String.format("%-15s%-35s%-20s%-20s%-25s%-10s%-10s", i.getItemCode(), i.getItemName(),i.getBuyingPrice(), i.getSellingPrice(), category.getCategoryName(), category.getTax(), i.getQuantity()));
					break;
				}else {
					++flag;
				}
			}
			if(flag == items.size())
				System.out.println("Sorry! Item not found");
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
	}

	private static void searchByItemName() {
		int flag = 0;
		String name;
		try {
			System.out.print("Please enter the Item name to be searched: ");
			name = scanner.nextLine();
			
			for(Item i : items) {
				if(i.getItemName().equalsIgnoreCase(name)) {
					System.out.println("ITEM FOUND");
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println(String.format("%-15s%-35s%-20s%-20s%-25s%-10s%-10s", "Item Code", "Item Name","Buying Price", "Selling Price", "Category Name", "Tax%", "Quantity"));
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
					Category category = null;
					category = CategoryUtilities.getCategory(i.getCategoryId());
					System.out.println(String.format("%-15s%-35s%-20s%-20s%-25s%-10s%-10s", i.getItemCode(), i.getItemName(),i.getBuyingPrice(), i.getSellingPrice(), category.getCategoryName(), category.getTax(), i.getQuantity()));
					break;
				}else {
					++flag;
				}
			}
			if(flag == items.size())
				System.out.println("Sorry! Item not found");
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
	}
}
