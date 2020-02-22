package com.revature.project00;

public class Customer {
/**
 * This is a POJO class for creating Customer Objects using DAO design Pattern and has two constructors
 * First constructor takes 3 arguments and is used for customer account creations
 * Second constructor takes 2 arguments, which are username and password and is used
 * for login credentials
 */
	private String fullName;
	private String username;
	private String password;
	public Customer(String fullName, String username, String password) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}
	
	
	/**
	 * This overloaded constructor accepts only username and password for login method
	 * @param username
	 * @param password
	 */
	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
