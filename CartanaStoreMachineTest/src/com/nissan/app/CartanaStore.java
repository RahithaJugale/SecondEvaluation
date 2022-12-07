package com.nissan.app;

import java.util.Scanner;

import com.nissan.lib.CategoryUtilities;
import com.nissan.lib.ItemUtilities;

public class CartanaStore {

	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);

	public static void main(String[] args) {
		int userChoice;
		char choice = 'n';
		System.out.println("CARTANA STORE");
		try {
			do {
				System.out.print("1. Admin\n2. Store Employee\nPlease select:");
				userChoice = Integer.parseInt(scanner.nextLine());

				switch (userChoice) {

				case 1:
					adminOptions();
					break;
				case 2:
					employeeOptions();
					break;
				default:
					System.out.println("Invalid selection");
					System.exit(0);
				}

				System.out.print("Do you want to see MainMenu? (Y/N): ");
				choice = scanner1.next().charAt(0);
			} while ((choice == 'y') || (choice == 'Y'));
			System.out.println("Thank You. Exiting...");
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void adminOptions() {
		int menuChoice;
		char choice = 'n';
		try {
			System.out.println("WELCOME ADMIN");
			do {

				System.out.println("PLEASE NOTE: Add few categories first and proceed with the other operations");
				System.out.print(
						"1. Add categories\n2. List All Categories\n3. Add Items\n4. List Items\nPlease choose an option: ");
				menuChoice = Integer.parseInt(scanner.nextLine());

				switch (menuChoice) {

				case 1:
					System.out.println();
					CategoryUtilities.addCategory();
					break;
				case 2:
					System.out.println();
					CategoryUtilities.displayAllCategories();
					break;
				case 3:
					System.out.println();
					ItemUtilities.addItems();
					break;
				case 4:
					System.out.println();
					ItemUtilities.listItems();
					break;

				default:
					System.out.println("Invalid selection");
				}

				// prompting user for another item addition
				System.out.print("Do you want to see Admin Options? (Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}

	private static void employeeOptions() {
		int menuChoice;
		char choice = 'n';
		try {
			System.out.println("WELCOME EMPLOYEE");
			do {

				System.out.print("1. List Items\n2. Search Items\nPlease choose an option: ");
				menuChoice = Integer.parseInt(scanner.nextLine());

				switch (menuChoice) {

				case 1:
					System.out.println();
					ItemUtilities.listItems();
					break;
				case 2:
					System.out.println();
					ItemUtilities.search();
					break;
				default:
					System.out.println("Invalid selection");
				}

				// prompting user for another item addition
				System.out.print("Do you want to see Employee Options? (Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

}
