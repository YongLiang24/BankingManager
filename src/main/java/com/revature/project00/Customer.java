package com.revature.project00;

public class Customer {

	private String fullName;
	private String username;
	private String password;
	public Customer(String fullName, String username, String password) {
		super();
		this.fullName = fullName;
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
