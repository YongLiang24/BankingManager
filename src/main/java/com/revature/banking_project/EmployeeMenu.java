package com.revature.banking_project;

import java.util.Scanner;

public interface EmployeeMenu {

	Scanner input = new Scanner(System.in);
	
	default String empMenu() {
		
		System.out.println("1. Accounts Approval");
		System.out.println("2. View Customer Accounts");
		System.out.println("3. View Transaction Logs");
		System.out.println("4. Exit");
		
		String userInput = input.nextLine();
		while(!(userInput.matches("1") || userInput.matches("2") || userInput.matches("3") || userInput.matches("4"))) {
			System.out.println("Invalid input, please select option 1, 2, 3 or 4");
			 userInput = input.nextLine();
			 
		}
		
		return userInput;
	}
}
