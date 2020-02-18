package com.revature.banking_project;

public class MainMenu implements ScannerInput {

	protected String MainMenuList() {
		System.out.println("Welcome to Bank Manager");
		System.out.println("1. Customer Login");
		System.out.println("2. Employee Login");
		System.out.println("3. Register for Customer Account");
		System.out.println("4. Exit");
		String userInput = input.nextLine();		
		while(!(userInput.matches("1") || userInput.matches("2") || userInput.matches("3") || userInput.matches("4"))) {
			System.out.println("Invalid input, please select options from 1-4");
			 userInput = input.nextLine();
		}		
		return userInput;
	}
}
