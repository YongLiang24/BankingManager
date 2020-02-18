package com.revature.banking_project;

public class EmployeeMenu implements ScannerInput{

	protected String EmpMenuList() {
		System.out.println("1. Accounts Approval");
		System.out.println("2. View Bank Accounts");
		System.out.println("3. View Transaction Logs");
		System.out.println("4. Sign Out");
		
		String userInput = input.nextLine();
		while(!(userInput.matches("1") || userInput.matches("2") || userInput.matches("3") || userInput.matches("4"))) {
			System.out.println("Invalid input, please select option 1, 2, 3 or 4");
			 userInput = input.nextLine();		 
		}
		
		return userInput;
	}
}
