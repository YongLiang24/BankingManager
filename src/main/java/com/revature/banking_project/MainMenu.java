package com.revature.banking_project;

import java.util.Scanner;

public interface MainMenu {

	Scanner input = new Scanner(System.in);
	/**
	 * this method valids and returns the user input from the main menu
	 * @return
	 */
	default String mainMenu(){
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
