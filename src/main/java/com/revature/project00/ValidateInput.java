package com.revature.project00;

public abstract class ValidateInput  implements ScannerInput{
	/**
	 * This abstract class contains various validation methods to check against the user inputs from the Menu class.
	 * The Menu class extends this abstract class.
	 * @param 
	 */
	
	/**
	 * This method validates user inputs when there are two numeric options to choose on the menu.
	 * @param result
	 */
	 void Validate2Options(String result) {
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
	 void Validate3Options(String result) {
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
	 void Validate4Options(String result) {
		while(!(result.matches("1") || result.matches("2") || result.matches("3") || result.matches("4"))) {
			System.out.println("Invalid input, please type a number from 1-4\n");
			result = input.nextLine();			
			System.out.println("``````````````````````````````````");
		}
	}
	 
	 /**
	  * This method validates 7 options from user inputs
	  * @param result
	  */
	 void Validate7Options(String result) {
		while(!(result.matches("1") || result.matches("2") || result.matches("3") || result.matches("4") 
				|| result.matches("5") || result.matches("6") || result.matches("7"))){
			System.out.println("Invalid input, please type a number from 1-7\n");
			result = input.nextLine();
			System.out.println("``````````````````````````````````");
		}
	}
	
	 /**
	  * This method prompts for a string user input, then parse the string into double to validate the input
	  * if the input was not a number or less than 1, it will continue to run the while loop and prompts again.
	  * @return double type value
	  */
	 double ValidateBalance() {
		
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



}
