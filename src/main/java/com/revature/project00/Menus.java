package com.revature.project00;



public abstract class Menus extends ValidateInput implements ScannerInput{
	
	
	/**
	 * This method displays the main menu options and prompts for user input.
	 * @return
	 */
	public String MainMenuDisplay() {
		System.out.println("    *WELCOME TO CONSOLE BANKING*\n");
		System.out.println("   ***********Main Menu***********\n");
		System.out.println("         1. I'm a customer\n");
		System.out.println("         2. I'm an employee\n");	
		System.out.println("         3. Exit");
		String result = input.nextLine();
		System.out.println("``````````````````````````````````");
		this.Validate3Options(result);
		return result;
	}
	/**
	 * This method displays customer menu and prompts for user input
	 * @return
	 */
	public String CustomerMenuDisplay() {
		System.out.println("");
		System.out.println("  **********Customer Menu**********\n");
		System.out.println("         1. Login\n");
		System.out.println("         2. Create An Account\n");	
		System.out.println("         3. Go Back");
		String result = input.nextLine();
		System.out.println("``````````````````````````````````");
		this.Validate3Options(result);	
		return result;
	}
	
	/**
	 * this method prompts for user input to sign up for new account
	 * @return
	 */
	public Customer SignupCustomerAccount() {
		Customer ctSignup;
		System.out.println("");
		System.out.println("  **********Sign Up Menu**********\n");
		System.out.println("       What is your full name?\n");
		String fullname = input.nextLine();
		System.out.println("``````````````````````````````````");
		System.out.println("       Please create an account name:");
		String accountname = input.nextLine();
		System.out.println("``````````````````````````````````");
		System.out.println("       Please create a password:");
		String password = input.nextLine();
		System.out.println("``````````````````````````````````");
		ctSignup = new Customer(fullname, accountname, password);		
		return ctSignup;
	}
	/**
	 * this method prompts user for login credential
	 * @return
	 */
	public Customer CustomerLogin() {
		Customer ctLogin;
		System.out.println("");
		System.out.println("  **********Log In Menu**********\n");
		System.out.println("  What is your account name?\n");
		String accountName = input.nextLine();
		System.out.println("``````````````````````````````````");
		System.out.println("  What is your password?");
		String accountPass = input.nextLine();
		System.out.println("````````````````````````````````");
		ctLogin = new Customer(accountName, accountPass);
		return ctLogin;
	}
	/**
	 * this method displays banking menu after user is logged in
	 * @return
	 */
	public String BankingMenu() {
		System.out.println("");
		System.out.println("  **********Banking Menu**********\n");
		System.out.println("       1. Apply for Bank Account\n");
		System.out.println("       2. View Account Balance\n");	
		System.out.print("       3. Withdraw");
		System.out.println("    4. Deposite\n");
		System.out.print("       5. Transfer");
		System.out.println("    6. Sign Out");
		String result = input.nextLine();	
		System.out.println("``````````````````````````````````");
		this.Validate7Options(result);	
		return result;
	}
	/**
	 * this method prompts user to create a new banking account
	 * @return
	 */
	public BankAccount ApplyForAccount() {		
		BankAccount bank;
		System.out.println("");
		System.out.println("  **********Apply for Banking Account**********\n");
		System.out.println("       Please create a name for your banking account:");
		String bankAccountName = input.nextLine();
		System.out.println("``````````````````````````````````");
		System.out.println("Choose an account type:\n");
		System.out.print("       1. Checking");
		System.out.print("       2. Saving");
		System.out.println("       3. Investment");
		String accountType = input.nextLine();
		System.out.println("``````````````````````````````````");
		this.Validate3Options(accountType);	
		String type = accountType;
		switch(type) {
		case "1":
			type = "Checking";
			break;
		case"2":
			type="Saving";
			break;
		case"3":
			type="Investment";
			break;
			default:break;
		}
		double startingBalance = this.ValidateBalance();
		bank = new BankAccount(bankAccountName, type, startingBalance);	
		return bank;
	}
	/**
	 * this method displays a menu for employee login
	 * @return
	 */
	public String EmpMenu() {
		System.out.println("");
		System.out.println("  **********Employee Menu**********\n");
		System.out.println("        1. Employee Login\n");
		System.out.println("        2. Go Back");
		String result = input.nextLine();
		System.out.println("``````````````````````````````````");
		this.Validate2Options(result);
		return result;
	}
	/**
	 * this method prompts user for login credential
	 * @return
	 */
	public Employee EmpLogin() {
		Employee ctLogin;
		System.out.println("");
		System.out.println("  **********Log In Menu**********\n");
		System.out.println("    What is your employee account?\n");
		String accountName = input.nextLine();
		System.out.println("``````````````````````````````````");
		System.out.println("    What is your password?");
		String accountPass = input.nextLine();
		System.out.println("````````````````````````````````");
		ctLogin = new Employee(accountName, accountPass);
		return ctLogin;
	}
	/**
	 * this method diplays options after an employee is logged in
	 * @return
	 */
	public String EmpLoggedMenu() {
		System.out.println("");
		System.out.println("  **********Employee Menu**********\n");
		System.out.println("       1. Arrpove Bank Accounts\n");
		System.out.println("       2. View Customer's Bank Accounts\n");	
		System.out.println("       3. View Transaction Logs\n");
		System.out.println("       4. Sign Out\n");
		String result = input.nextLine();	
		System.out.println("``````````````````````````````````");
		this.Validate4Options(result);
		return result;
	}
	
	public String transferMenu() {
		System.out.println("");
		System.out.println("   *********Transfer Menu**********\n");
		System.out.println("      1. Search and Transfer\n");
		System.out.println("      2. Go Back");
		String result = input.nextLine();
		System.out.println("```````````````````````````````````");
		Validate2Options(result);
		return result;
	}
}
