package com.revature.project0;

import java.util.HashMap;
import java.util.Map;

public class AccountStorage implements AccountValidation{

	Map<String, String> customerAccount = new HashMap<String, String>();
	Map<String, String> employeeAccount = new HashMap<String, String>();
	
	public AccountStorage() {
		employeeAccount.put("admin", "123");
	}

	/**
	 * This method takes an newly created account name as argument and adds to the customerAccount hashmap
	 * @param accountName
	 */
	boolean addCustomerAccount(String accountName, String password) {
		
		if(!customerAccount.containsKey(accountName)) {
			customerAccount.put(accountName, password);
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method checks accountName and password for employee login
	 * @param accountName
	 */
	@Override
	public boolean isEmployeeValid(String accountName, String password) {
		if(employeeAccount.containsKey(accountName) && employeeAccount.containsValue(password)) {
			return true;
		}
		
		return false;
	}


	@Override
	public boolean isCustomerValid(String name, String password) {
		if(customerAccount.containsKey(name) && customerAccount.containsValue(password)) {
			return true;
		}
		return false;
	}
	
	
	
}
