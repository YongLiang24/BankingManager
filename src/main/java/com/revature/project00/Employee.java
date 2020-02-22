package com.revature.project00;

public class Employee {
    /**
     * This is a POJO Employee class.
     */
	private String empUsername;
	private String empPassword;
	public Employee(String empUsername, String empPassword) {
		super();
		this.empUsername = empUsername;
		this.empPassword = empPassword;
	}
	public String getEmpUsername() {
		return empUsername;
	}
	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	
	
}
