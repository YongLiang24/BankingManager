package com.revature.banking_project;

import java.util.HashMap;
import java.util.Map;

public abstract class BankAccounts implements ScannerInput{
	Map <String, Double>preApproveAccounts = new HashMap<String, Double>();
	Map <String, String>approvedAccounts = new HashMap<String, String>();
	
	void applyBankAccount(String bankAccName, double initBalance) {
		
		if(!preApproveAccounts.containsKey(bankAccName)) {
			System.out.println("Account Created");
			preApproveAccounts.put(bankAccName, initBalance);
		}else {
			System.out.println("this account already exist.");
		}
	}
	
	 void applyBankAccount() {
		System.out.println("Bank Account Name: ");
		String userInput = input.nextLine();		
		double balance =-1;		
		while(balance <0) {
			System.out.println("Starting balance: ");
			String startingBalance = input.nextLine();
			try {
			balance = Double.parseDouble(startingBalance);
			
			if(balance <1) {
				System.out.println("Invalid input, minumum of 1 dollar is required");
				balance = -1;
			}
			
			
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input, try again.");
				balance =-1;
			}
		}
		
			preApproveAccounts.put(userInput, balance);
	}
}
