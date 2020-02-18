package com.revature.banking_project;

public class CustomerMenu implements ScannerInput{
	
	/**
	 * This method display the customer menu and prompt user for inputs
	 * @return
	 */
	protected String CTMenuList() {
		System.out.println("Welcome to Console Banking.");
		System.out.println("1. Apply for Banking Account");
		System.out.println("2. View Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdrawal");
		System.out.println("5. Sign Out");
		
		String userInput = input.nextLine();
		while(!(userInput.matches("1") || userInput.matches("2") || userInput.matches("3") || userInput.matches("4") || userInput.matches("5"))) {
			System.out.println("Invalid input, please select option 1, 2, 3 or 4\n");
			 userInput = input.nextLine();
			 
		}
		return userInput;
	}
}
