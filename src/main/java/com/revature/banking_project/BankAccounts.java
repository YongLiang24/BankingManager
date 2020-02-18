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
		System.out.println(systemMessage+"Bank Account Name: ");
		String userInput = input.nextLine();		
		double balance =-1;		
		while(balance <0) {
			System.out.println(systemMessage+"Starting balance: ");
			String startingBalance = input.nextLine();
			try {
			balance = Double.parseDouble(startingBalance);
			
			if(balance <1) {
				System.out.println(systemMessage+"Invalid input, minumum of 1 dollar is required");
				balance = -1;
			}		
			}
			catch(NumberFormatException e) {
				System.out.println(systemMessage+"Invalid input, try again.");
				balance =-1;
			}
		}
		if(!preApproveAccounts.containsKey(userInput)) {
			System.out.println(systemMessage+"Account Name: "+userInput +" with Balance: "+ "$"+balance+ " is Created," + " Pending for Approval.\n");
			preApproveAccounts.put(userInput, balance);
		}else {
			System.out.println(systemMessage+"Account Already Exist.");
		}
			
	}

	 void DisplayPreApproveAccount() {
		 int i=0;
		 for(Map.Entry<String, Double> account: preApproveAccounts.entrySet()) {
			 i++;
			 System.out.println(systemMessage+i+".Account Name:"+account.getKey()+", -Balance:"+account.getValue()+"\n");
		 }
	 }
	 
	 void ApproveAccount(String name) {
		 if(preApproveAccounts.isEmpty()) {
			 System.out.println(systemMessage+"No pending accounts available.\n");
		 }
		 for(Map.Entry<String, Double> account: preApproveAccounts.entrySet()) {
			 if(account.getKey().equals(name)) {
				 System.out.println(systemMessage+"Account "+name+" has been approved.\n");
				 approvedAccounts.put(name, account.getValue());
				 preApproveAccounts.remove(account.getKey(), account.getValue());
			 }
			 else {
				 System.out.println(systemMessage+"Incorrect Account Name. Try Again");
			 }
		 }
	 }

	 void ViewBankAccount() {
		 int i=0;
		 if(!approvedAccounts.isEmpty()) {
			 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
				 i++;
				 System.out.println(systemMessage+i+".Account: "+account.getKey()+", Balance: "+account.getValue()+"\n");
			 }
		 }
		 else {
			 System.out.println(systemMessage+"No accounts available.\n");
		 }
	 }

	 void ViewBalance() {
		int i=0;
		 if(!approvedAccounts.isEmpty()) {
			 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
				 i++;
				 System.out.println(systemMessage+1+"."+account.getKey()+"  -  $"+account.getValue()+"\n");
			 }
		 }else {
			 System.out.println(systemMessage+"No accounts found.\n");
		 }
	 }

	 void AddDeposit() {

		 if(approvedAccounts.isEmpty()) {
			 System.out.println(systemMessage+"No accounts available.\n");
		 }
		 else {
			 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
				 System.out.println(systemMessage+1+"."+account.getKey()+"  -  $"+account.getValue()+"\n");
			 }
		 }
		 
			System.out.println(systemMessage+"Type an account name for the deposit.\n");
			String accountName = input.nextLine();
		
			double balance =-1;		
			while(balance <0) {
				System.out.println(systemMessage+"Choose an amount for the deposit. \n");
				String depositAmount=input.nextLine();
				try {
				balance = Double.parseDouble(depositAmount);
				
				if(balance <1) {
					System.out.println(systemMessage+"Invalid input, minumum of 1 dollar is required");
					balance = -1;
				}		
				}
				catch(NumberFormatException e) {
					System.out.println(systemMessage+"Invalid input, try again.");
					balance =-1;
				}
			}
		 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
			if(account.getKey().equals(accountName)) {
				double sum = account.getValue()+balance;
				approvedAccounts.put(account.getKey(), sum);
				System.out.println(systemMessage+"$"+balance+" has been added to "+account.getKey()+". The new balance is now $"+sum+"\n");
			}else {
				System.out.println(systemMessage+"Account not found. Try Again.\n");
			}
		 }
	 }

	 void WithdrawBalance() {
		 if(approvedAccounts.isEmpty()) {
			 System.out.println(systemMessage+"No accounts available.\n");
		 }
		 else {
			 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
				 System.out.println(systemMessage+"."+account.getKey()+"  -  $"+account.getValue()+"\n");
			 }
		 }
		 
			System.out.println(systemMessage+"Type an account name for withdrawal.\n");
			String accountName = input.nextLine();
		
			double balance =-1;		
			while(balance <0) {
				System.out.println(systemMessage+"Choose an amount to withdraw. \n");
				String depositAmount=input.nextLine();
				try {
				balance = Double.parseDouble(depositAmount);
				
				if(balance <1) {
					System.out.println(systemMessage+"Invalid input, minumum of 1 dollar is required\n");
					balance = -1;
				}		
				}
				catch(NumberFormatException e) {
					System.out.println(systemMessage+"Invalid input, try again.");
					balance =-1;
				}
			}
		 for(Map.Entry<String, Double> account: approvedAccounts.entrySet()) {
			if(account.getKey().equals(accountName)) {
				double difference = account.getValue()-balance;
				approvedAccounts.put(account.getKey(), difference);
				System.out.println(systemMessage+"$"+balance+" has been withdrawn from "+account.getKey()+". The new balance is now $"+difference+"\n");
			}else {
				System.out.println(systemMessage+"Account not found. Try Again.\n");
			}
		 }
	 }
}

