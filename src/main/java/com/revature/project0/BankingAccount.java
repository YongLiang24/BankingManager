package com.revature.project0;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface BankingAccount {

	Scanner input = new Scanner(System.in);
	Map<String, Double> bankAccountInfo = new HashMap<String, Double>();
	
	default void applyBankAccount() {
		System.out.println("Please type a name for your account.");
		String userInput = input.nextLine();
		
		double balance =-1;
		
		while(balance <0) {
			System.out.println("How much is your starting balance?");
			String startingBalance = input.nextLine();
			try {
			balance = Double.parseDouble(startingBalance);}
			catch(NumberFormatException e) {
				System.out.println("Invalid input, try again.");
				balance =-1;
			}
		}
		
		bankAccountInfo.put(userInput, balance);		
	}
	
	default void ViewBalance() {
		for(Map.Entry<String, Double> entry: bankAccountInfo.entrySet()) {
			System.out.println("Account: " +entry.getKey()+ " Balance: "+entry.getValue());
		}
	}
}
