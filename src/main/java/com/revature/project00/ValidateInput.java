package com.revature.project00;


public abstract class ValidateInput extends DatabaseCommunicate implements ScannerInput{
	/**
	 * This abstract class contains various validation methods to check against the user inputs from the Menu class.
	 * The Menu class extends this abstract class.
	 * @param 
	 */
	
	/**
	 * This method validates user inputs when there are two numeric options to choose on the menu.
	 * @param result
	 */
	 protected void validate2Options(String result) {
		while(!(result.matches("1") || result.matches("2"))) {
			System.out.println("Invalid input, please type a number from 1-2\n");
			result = input.nextLine();
			System.out.println("``````````````````````````````````");
		}
	}
	
	 /**
	  * This method validates user inputs when there are three numeric options to choose on the menu.
	  * @param result
	  */
	 protected void validate3Options(String result) {
		while(!(result.matches("1") || result.matches("2") || result.matches("3"))) {
			System.out.println("Invalid input, please type a number from 1-3\n");
			result = input.nextLine();
			System.out.println("``````````````````````````````````");
		}
	}
	
	 /**
	  * This method validates user inputs when there are four numeric options.
	  * @param result
	  */
	 protected void validate4Options(String result) {
		while(!(result.matches("1") || result.matches("2") || result.matches("3") || result.matches("4"))) {
			System.out.println("Invalid input, please type a number from 1-4\n");
			result = input.nextLine();			
			System.out.println("``````````````````````````````````");
		}
	}
	 protected void validate5Options(String result) {
		while(!(result.matches("1") || result.matches("2") || result.matches("3") || result.matches("4") || result.matches("5"))) {
			System.out.println("Invalid input, please type a number from 1-4\n");
			result = input.nextLine();			
			System.out.println("``````````````````````````````````");
		}
	}
	 
	 /**
	  * This method validates 7 options from user inputs
	  * @param result
	  */
	 protected void validate7Options(String result) {
		while(!(result.matches("1") || result.matches("2") || result.matches("3") || result.matches("4") 
				|| result.matches("5") || result.matches("6"))){
			System.out.println("Invalid input, please type a number from 1-6\n");
			result = input.nextLine();
			System.out.println("``````````````````````````````````");
		}
	}
	
	 /**
	  * This method prompts for a string user input, then parse the string into double to validate the input
	  * if the input was not a number or less than 1, it will continue to run the while loop and prompts again.
	  * @return double type value
	  */
	 protected double validateBalance() {
		
		double balance =-1;		
		while(balance <0) {
			System.out.println("Starting balance: ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			balance = Double.parseDouble(balanceString);		
			if(balance <1) {
				System.out.println("Invalid input, minumum of 1 dollar is required");
				balance = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				balance =-1;
			}
		}
		return balance;
	 
	}
	 protected double validateWithdrawAmount() {
			
		double balance =-1;		
		while(balance <0) {
			System.out.println("      Please enter the amount to withdraw: ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			balance = Double.parseDouble(balanceString);		
			if(balance <1) {
				System.out.println("      The amount can not be less than 1");
				balance = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				balance =-1;
			}
		}
		return balance;
	 
	}
	 
	 protected double validateDepositeAmount() {
			
		double balance =-1;		
		while(balance <0) {
			System.out.println("      Please enter the amount to deposite: ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			balance = Double.parseDouble(balanceString);		
			if(balance <1) {
				System.out.println("      The amount can not be less than 1");
				balance = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				balance =-1;
			}
		}
		return balance;
	 
	}
	 protected int validateAccountId() {
			
		int accountId =-1;		
		while(accountId <0) {
			System.out.println("      Please enter an account Id to select the account ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			accountId = Integer.parseInt(balanceString);		
			if(accountId <1) {
				System.out.println("Invalid ID, try again");
				accountId = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				accountId =-1;
			}
		}
		return accountId;
	 
	}
	 
	 protected int validateTransferId() {
			
		int accountId =-1;		
		while(accountId <0) {
			System.out.println("      Select one of your bank account by ID to make the transfer ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			accountId = Integer.parseInt(balanceString);		
			if(accountId <1) {
				System.out.println("Invalid ID, try again");
				accountId = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				accountId =-1;
			}
		}
		return accountId;
	 
	}

	 protected double validateTransferAmount() {
			
		double balance =-1;		
		while(balance <0) {
			System.out.println("      Please enter the amount for the transfer: ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			balance = Double.parseDouble(balanceString);		
			if(balance <1) {
				System.out.println("      The amount can not be less than 1");
				balance = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				balance =-1;
			}
		}
		return balance;
	 
	}
	 
	 protected int validateTransferAccId() {
			
		int accountId =-1;		
		while(accountId <0) {
			System.out.println("      Please enter an account Id to start the transfer ");
			String balanceString = input.nextLine();
			System.out.println("``````````````````````````````````");
			try {
			accountId = Integer.parseInt(balanceString);		
			if(accountId <1) {
				System.out.println("Invalid ID, try again");
				accountId = -1;
				}		
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid non-numeric input, please try again.");
				accountId =-1;
			}
		}
		return accountId;
	 
	}

}
