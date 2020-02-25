package com.revature.project00;

public class BankAccount {
	/**
	 * This is a POJO class for creating BankAccount objects at banking account creation.
	 * The approvalStatus defaults with false and will become true once an account gets approved
	 */
	private String bankAccountName;
	private String accountType;
	private boolean approvalStatus = false;
	private double balance=0;
	private int accountId;
	private int customerId;
	
	
	
	public BankAccount(int accountId, String bankAccountName, double balance, String accounType, int customerId) {
		super();
		this.accountId = accountId;
		this.bankAccountName = bankAccountName;
		this.balance = balance;
		this.accountType = accounType;
		this.customerId=customerId;
		
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
