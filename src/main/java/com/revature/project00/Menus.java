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
		Customer ctLogin;
		System.out.println("");
		System.out.println("  **********Log In Menu**********\n");
		System.out.println("           Account Name:\n");
		String accountName = input.nextLine();
		System.out.println("           Password:");
		String accountPass = input.nextLine();
		ctLogin = new Customer(accountName, accountPass);
		return ctLogin;
	}
	
	public String BankingMenu() {
		System.out.println("");
		System.out.println("  **********Banking Menu**********\n");
		System.out.println("       1. Apply for Bank Account");
		System.out.println("       2. View Account Balance");	
		System.out.print("       3. Withdraw");
		System.out.println("    4. Deposite");
		System.out.print("       5. Transfer");
		System.out.println("    6. Notification");
		System.out.println("       7. Sign Out");
		String result = input.nextLine();		
		return result;
	}
	
	public BankAccount ApplyForAccount() {
		
		BankAccount bank;
		System.out.println("");
		System.out.println("  **********Apply for Banking Account**********\n");
		System.out.println("       Create a name for your banking account:");
		String bankAccountName = input.nextLine();
		System.out.println("Choose an account type:\n");
		System.out.print("       1. Checking");
		System.out.print("       2. Saving");
		System.out.println("       3. Investment");
		String accountType = input.nextLine();
		System.out.println("Starting Balance:");
		double startingBalance = input.nextDouble();
		bank = new BankAccount(bankAccountName, accountType, startingBalance);	
		return bank;
	}
	
	
}
