package com.revature.banking_project;

import java.util.HashMap;
import java.util.Map;

public abstract class BankAccounts {
	Map <String, Double>preApproveAccounts = new HashMap<String, Double>();
	Map <String, String>approvedAccounts = new HashMap<String, String>();
	
	void applyBankAccount(String bankAccName) {
		
		if(!preApproveAccounts.containsKey(bankAccName)) {
			System.out.println("Account Created");
			preApproveAccounts.put(bankAccName, 11.1);
		}else {
			System.out.println("this account already exist.");
		}
	}
}
