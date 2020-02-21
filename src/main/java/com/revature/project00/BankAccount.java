package com.revature.project00;

public class BankAccount {
	/**
	 * This is a POJO class that responsibles for creating BankAccount objects with attributes.
	 */
	private String bankAccountName;
	private String accountType;
	private boolean approvalStatus = false;
	private double balance=0;
	
	
	public BankAccount(String bankAccountName, String accountType, double balance) {
		super();
		this.bankAccountName = bankAccountName;
		this.accountType = accountType;
		this.balance = balance;
	}
		
	public BankAccount(boolean approvalStatus) {
		super();
		this.approvalStatus = approvalStatus;
	}
	
	
	public BankAccount(String bankAccountName, double balance) {
		super();
		this.bankAccountName = bankAccountName;
		this.balance = balance;
	}
	

	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public boolean isApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
