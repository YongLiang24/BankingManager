package com.revature.banking_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface AccountRegister {
	
	Scanner input = new Scanner(System.in);
	Map<String, String> customerAccountMap = new HashMap<String,String>();
	
	default boolean createAccount() {
		System.out.println("Account Registration");
		System.out.println("Username: ");
		String userInput = input.nextLine();
		System.out.println("Password: ");
		String userPassword = input.nextLine();
		
		if(!customerAccountMap.containsKey(userInput)) {
			customerAccountMap.put(userInput, userPassword);
			return true;
		}
		else {
			return false;
		}
	}
	
}
