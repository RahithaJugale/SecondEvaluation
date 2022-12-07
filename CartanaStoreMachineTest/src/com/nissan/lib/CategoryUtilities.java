package com.nissan.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.model.Category;

public class CategoryUtilities {
	
	private static List<Category> categories = new ArrayList<Category>();
	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);
	
	public static void addCategory() {
		String categoryName;
		float tax;
		char choice = 'n';
		try {
			System.out.println("ADD NEW CATEGORY");
			do {
				//getting category name
				System.out.print("Enter category name:");
				categoryName = getValidCategoryName(scanner.nextLine());
				
				//checking for duplicate entries of category name
				if(checkCategoryExists(categoryName)) {
					System.out.println("Category already exists. Please try again.");
					continue;
				}
				
				//getting tax
				System.out.print("Enter tax in %: ");
				tax = getValidTax(scanner.nextLine());
				
				//inserting into List
				categories.add(new Category(categoryName, tax));
				System.out.println("Category Added");
				
				//prompting user for another category addition
				System.out.print("Do you want to add another category? (Y/N): ");
				choice = scanner1.next().charAt(0);
				
			}while((choice == 'y')||(choice == 'Y'));
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}


	private static boolean checkCategoryExists(String categoryName) {
		if(categories.size() == 0)
			return false;
		else {
			for(Category category : categories) {
				if(category.getCategoryName().equalsIgnoreCase(categoryName))
					return true;
			}
		}
		return false;
	}


	private static String getValidCategoryName(String categoryName) {
		
		try {
			//defining pattern
			Pattern namePattern = Pattern.compile("[^A-Za-z ]");
			
			do {
				
				//defining matcher
				Matcher nameMatcher = namePattern.matcher(categoryName);
				boolean finder = nameMatcher.find();
				
				//validating for anything other than alphabets
				if(finder) {
					System.out.print("Category Name should contain only alphabets. Please re-enter: ");
					categoryName = scanner.nextLine();
				}else if(categoryName.length() <=0 ) {
					System.out.print("Category Name should not be blank. Please re-enter: ");
					categoryName = scanner.nextLine();
				}else if(categoryName.length() > 20 ) {
					System.out.print("Category Name should have only 20 characters. Please re-enter: ");
					categoryName = scanner.nextLine();
				}else
					break;
			}while(true);
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
		return categoryName;
	}
	
	private static float getValidTax(String tax) {
		
		try {
			//defining pattern
			Pattern taxPattern = Pattern.compile("[^0-9.]");
			
			do {
				
				//defining matcher
				Matcher taxMatcher = taxPattern.matcher(tax);
				boolean finder = taxMatcher.find();
				
				//validating for anything other than numbers
				if(finder) {
					System.out.print("Tax field should contain only numbers. Please re-enter: ");
					tax = scanner.nextLine();
				}else if(tax.length() <=0 ) {
					System.out.print("Tax field should not be blank. Please re-enter: ");
					tax = scanner.nextLine();
				}else
					break;
			}while(true);
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
		return Float.parseFloat(tax);
	}
	
	public static Category getCategory(int id) {
		
		for(Category category : categories) {
			//checking if the category id is present in the list
			if(category.getCategoryId() == id) {
				return category;
			}
		}
		return null;
	}
	
	public static void displayAllCategories() {
		System.out.println("-------------------------------------------------------");
		System.out.println("---------------------Category List---------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println(String.format("%-15s%-25s%-10s", "CategoryID", "Category Name", "Tax"));
		System.out.println("-------------------------------------------------------");
		for(Category category : categories) {
			System.out.println(String.format("%-15s%-25s%-10s", category.getCategoryId(), category.getCategoryName(), category.getTax()));
		}
	}
}
