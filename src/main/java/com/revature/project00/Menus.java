package com.revature.project00;



public class Menus implements ScannerInput{
	

	public String MainMenuDisplay() {
		System.out.println("");
		System.out.println("     WELCOME TO CONSOLE BANKING\n");
		System.out.println("  **********Main Menu**********\n");
		System.out.println("       1. I'm a customer\n");
		System.out.println("       2. I'm an employee\n");	
		System.out.println("       3. Exit");
		String result = input.nextLine();
		return result;
	}
	
	public String CustomerMenuDisplay() {
		System.out.println("");
		System.out.println("  **********Customer Menu**********\n");
		System.out.println("       1. Login\n");
		System.out.println("       2. Create An Account\n");	
		System.out.println("       3. Go Back");
		String result = input.nextLine();		
		return result;
	}
	
	public Customer SignupMenuDisplay() {
		Customer ctSignup;
		System.out.println("");
		System.out.println("  **********Sign Up Menu**********\n");
		System.out.println("       What is your full name?\n");
		String fullname = input.nextLine();
		System.out.println("       Please create an account name:");
		String accountname = input.nextLine();
		System.out.println("       Please create a password:");
		String password = input.nextLine();
		ctSignup = new Customer(fullname, accountname, password);		
		return ctSignup;
	}
	
	public Customer CustomerLogin() {
		return null;
	}
	
}
