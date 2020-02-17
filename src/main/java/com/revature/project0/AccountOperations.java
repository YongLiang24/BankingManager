package com.revature.project0;

import java.util.Scanner;

public class AccountOperations implements BankingAccount{
	
	

	public AccountOperations() {
		super();
	}

	void CustomerMenu(Scanner input) {
		System.out.println("1. Apply for Banking Account");
		System.out.println("2. View Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdrawal");
		System.out.println("5. Exit");
		
		String userInput = input.nextLine();
		while(!(userInput.matches("1") || userInput.matches("2") || userInput.matches("3") || userInput.matches("4") || userInput.matches("5"))) {
			System.out.println("Invalid input, please select option 1, 2, 3 or 4");
			 userInput = input.nextLine();
			 
		}
		
		this.CustomerSelection(userInput);
		
	}
	
	void CustomerSelection(String userInput) {
		switch(userInput) {
		
		case "1":
			BankingAccount.super.applyBankAccount();
			break;
			
		default:
			break;
			
		
		
		}
	}
	
	
}
