package com.revature.banking_project;

import java.util.HashMap;
import java.util.Map;

public interface AccountRegister extends ScannerInput{
	
	Map<String, String> customerAccountMap = new HashMap<String,String>();//stores customer account info
	Map<String, String> empAccountMap = new HashMap<String, String>();//stores employee account info
	
	default boolean CreateAccount() {
		System.out.println("Account Registration");
		System.out.println("Username: ");
		String userInput = input.nextLine();
		System.out.println("Password: ");
		String userPassword = input.nextLine();	
		if(!customerAccountMap.containsKey(userInput)) {
			customerAccountMap.put(userInput, userPassword);
			System.out.println("Account Created!\n");
			
			return true;
		}
		else {
			System.out.println("Account Already Exist.\n");
			return false;
		}
	}
	
	/**
	 * This method validates the user inputs for customer login
	 * @param username
	 * @param password
	 * @return
	 */
	default boolean IsAccountValid(String username, String password) {
		
		if(customerAccountMap.containsKey(username) && customerAccountMap.containsValue(password)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * this method validate for employee login
	 * @param username
	 * @param password
	 * @return
	 */
	default boolean IsEmpValid(String username, String password) {
		if(empAccountMap.containsKey(username) && empAccountMap.containsValue(password)) {
			return true;
		}
		return false;
	}
	
	
	
}
