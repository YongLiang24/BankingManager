package com.revature.banking_project;

import java.util.HashMap;
import java.util.Map;

public abstract class BankAccounts implements ScannerInput{
	Map <String, Double>preApproveAccounts = new HashMap<String, Double>();
	Map <String, Double>approvedAccounts = new HashMap<String, Double>();
	//Map<String, Object> userSpecificAccounts = new HashMap<String, Object>();
	/**
	 * apply for pre approved account bank account and validates user inputs
	 * @param bankAccName
	 * @param initBalance
	 */
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
		if(!preApproveAccounts.containsKey(userInput)) {
			System.out.println("Account Name: "+userInput +" with Balance: "+ "$"+balance+ " is Created," + " Pending for Approval.\n");
			preApproveAccounts.put(userInput, balance);
		}else {
			System.out.println("Account Already Exist.");
		}
			
	}

	 void DisplayPreApproveAccount() {
		 for(Map.Entry<String, Double> account: preApproveAccounts.entrySet()) {
			 System.out.println("Account Name:"+account.getKey()+", -Balance:"+account.getValue());
		 }
	 }
	 
	 void ApproveAccount(String name) {
		 if(preApproveAccounts.isEmpty()) {
			 System.out.println("No pending accounts available.");
		 }
		 for(Map.Entry<String, Double> account: preApproveAccounts.entrySet()) {
			 if(account.getKey().equals(name)) {
				 System.out.println("Account "+name+" has been approved.");
				 approvedAccounts.put(name, account.getValue());
				 preApproveAccounts.remove(account.getKey(), account.getValue());
			 }
			 else {
				 System.out.println("Account not found.");
			 }
		 }
	 }

	 void ViewBankAccount() {
		 int i=0;
		 if(!approvedAccounts.isEmpty()) {
			 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
				 i++;
				 System.out.println(i+".Account: "+account.getKey()+", Balance: "+account.getValue()+"\n");
			 }
		 }
		 else {
			 System.out.println("No accounts available.\n");
		 }
	 }


}

