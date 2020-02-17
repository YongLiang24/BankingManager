package com.revature.project0;

import java.util.Scanner;

public class Menus extends AccountOperations{

	Scanner input = new Scanner(System.in);
	AccountStorage accounts = new AccountStorage();
	
	/**
	 * This method displays the main menu
	 * @return a user input as a String type
	 */
	public void MainMenuInput() {
		System.out.println("Welcome to Bank Manager");
		System.out.println("1. Customer Login");
		System.out.println("2. Employee Login");
		System.out.println("3. Register for Customer Account");
		System.out.println("4. Exit");
		String userInput = input.nextLine();
		
		while(!(userInput.matches("1") || userInput.matches("2") || userInput.matches("3") || userInput.matches("4"))) {
			System.out.println("Invalid input, please select option 1, 2, 3 or 4");
			 userInput = input.nextLine();
		}
		
		this.SubMenus(userInput);	
	}
	
	/**
	 * This method displays sub menu options
	 * @param userInput takes the input from main menu and divide the choices with switch statements
	 */
	public void SubMenus(String userInput) {
		switch(userInput) {
		
			case "1":
				System.out.println("Pealse Enter Your Account Name");
				String accountName = input.nextLine();
				System.out.println("Please Enter Your Password");
				String accountPassword = input.nextLine();
				if(accounts.isCustomerValid(accountName, accountPassword)) {
					System.out.println("login success.");
					CustomerMenu(input);
					break;
				}
				else {
					System.out.println("Account not found, please register a new account.");
					System.out.println("");
					this.MainMenuInput();
				}
				break;
			case "2":
				System.out.println("Test Account: username: admin, password: 123");
				System.out.println("Please Enter Your Employee Account");
				String empName = input.nextLine();
				System.out.println("Please Enter Your Password");
				String empPassword = input.nextLine();
				if(accounts.isEmployeeValid(empName, empPassword)) {
					System.out.println("Login Success.");
					break;
				}
				else {
					System.out.println("Incorrect account name or password, please try again.");
					System.out.println(" ");
					this.MainMenuInput();
					break;
				}
			case "3":
				System.out.println("Please Enter a Name for a New Account");
				String newAccount = input.nextLine();
				System.out.println("Please Enter a New Password");
				String newPassword = input.nextLine();
				if(accounts.addCustomerAccount(newAccount, newPassword)) {
					System.out.println("Account Created.");
					System.out.println("Returning to the Main Menu.");
					System.out.println(" ");
					this.MainMenuInput();
					break;
				}
				else {
					System.out.println("This account already exists.");
					System.out.println("Returning to the Main Menu.");
					System.out.println(" ");
					this.MainMenuInput();
					break;
				}	
				
			case "4":
				System.out.println("Program terminated");
				System.exit(0);
				
			default:
				System.out.println("Invalid input");
		}
		
		
	}
	
}
