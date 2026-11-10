/*
 * Class: CMSC203
 * Instructor: Khandan Monshi
 * Description: Assignment 4: management company with driver
 * Due: 11/11/2026
 * Platform/compiler: Win11 26H2 build 26430.9767 / openjdk 21.0.1 (Microsoft provided)
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Michael Jarman
 */

import java.util.Scanner;

public class PropertyDriver {
	// menu options
	private static final String[] menuOptions = new String[] { "Add Property",
			"Display All Properties", "Show Total Rent", "Exit"};
	private static Scanner kb;
	private static Property[] properties = new Property[5];;
	private static ManagementCompany mc = new ManagementCompany("Campus Realty", "123-45-6789", properties, 0);
	
	public static void main(String[] args) {
		kb = new Scanner(System.in);

		int choice = 0;
		while (choice != 4) {
			choice = menuSelection();
			switch (choice) {
				case 1 -> addProperty();
				case 2 -> displayProperties();
				case 3 -> showTotalRent();
                case 4 -> System.out.println("Goodbye. Assignment built by Michael Jarman (student)");
            }
		}

		// cleanup
		kb.close();
	}
	
	private static void printBanner () {
		System.out.println("====================================");
		System.out.println("  Assignment 4: Property Manager");
		System.out.println("====================================");
	}
	
	private static int menuSelection () {
		printBanner();
		for (int i = 0; i < menuOptions.length; i++) {
			System.out.println((i + 1) + " - " + menuOptions[i]);
		}
		String prompt = ("Enter Choice (1-" + menuOptions.length + "): ");
		return Integer.parseInt(userInput(0, prompt, menuOptions.length));
	}

	private static void addProperty () {
		String propertyName = userInput("", "Enter property name: ");
		String city = userInput("", "Enter city: ");
		double rent = Double.parseDouble(userInput(0.00, "Enter monthly rent: "));
		String owner = userInput("", "Enter owner: ");
		int propertyIndex = mc.addProperty(new Property(new Property(propertyName, city, rent, owner))); // ... requirements said to use a copy constructor in the *driver*
		if (propertyIndex == -1) {
			System.out.println("Failed to add new property");
		} else {
			System.out.println("Property added at index " + propertyIndex + ".");
		}
	}

	private static void displayProperties () {
		System.out.println(mc);
	}

	private static void showTotalRent () {
		double rent = mc.totalRent();
		System.out.println("Total Rent: " + ManagementCompany.formatMoney(rent));
	}

	private static <T> String userInput (T type, String prompt) {
		return userInput(type, prompt, -1);
	}

	private static <T> String userInput (T type, String prompt, int options) {
		boolean attempt = false;
		StringBuilder filteredInput = new StringBuilder();
		String failMessage = "Invalid input, please try again: ";

		System.out.print(prompt);
		String input = kb.nextLine();

		if (type instanceof Integer) {
			while (!attempt) {
				try {
					int fInput = Integer.parseInt(input);
					if ((fInput < 1 || fInput > options) && options != -1) {
						throw new IllegalArgumentException("Invalid Input");
					}
					filteredInput.append(fInput);
					attempt = true;
				} catch (IllegalArgumentException e) {
					attempt = false;
					System.out.print(failMessage);
					input = kb.nextLine();
				}
			}
		}
		else if (type instanceof String) {
			return input;
		} else if (type instanceof Double) {
			while (!attempt) {
				try {
					double fInput = Double.parseDouble(input);
					filteredInput.append(fInput);
					attempt = true;
				} catch (IllegalArgumentException e) {
					attempt = false;
					System.out.print(failMessage);
					input = kb.nextLine();
				}
			}
		} else {
			return null;
		}
		return filteredInput.toString();
	}

}
