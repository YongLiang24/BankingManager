package com.revature.banking_project;

public class MenuOperations extends BankAccounts implements AccountRegister{
	
	private String mainOption;
	private String empOption;
	MainMenu mainMenu = new MainMenu();
	CustomerMenu ctMenu = new CustomerMenu();
	EmployeeMenu empMenu = new EmployeeMenu();
	boolean switchOn = true;
	/**
	 * Constructor
	 */
	public MenuOperations() {
		empAccountMap.put("admin", "123");
		do {
		mainOption = mainMenu.MainMenuList();
		CustomerLoginMenu(mainOption);
		input.close();
		}while(switchOn);	
	}
	
	
	void CustomerLoginMenu(String option) {
		
		switch(option) {
		case "1":
			System.out.println("Welcome to Customer Login.");
			System.out.println("Username:");
			String userName = input.nextLine();
			System.out.println("Password: ");
			String userPassword = input.nextLine();
			if(IsAccountValid(userName, userPassword)) {
							
				switch(ctMenu.CTMenuList()) {
					case "1":
						System.out.println("Create a Banking Account");
						System.out.println("Bank Account Name:");
						input.nextLine();
						applyBankAccount("name");
						break;
					case "2":
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
						break;
					default: break;
				}
			}else {
				System.out.println("Invalid Username or Password - Returning to Main Menu.\n");				
			}			
			break;
		case "2":
			System.out.println("Welcome to Employee Login");
			System.out.println("Test Account: name: admin - pass: 123");
			System.out.println("username: ");
			String empName = input.nextLine();
			System.out.println("password: ");
			String empPassword = input.nextLine();
			if(IsEmpValid(empName, empPassword)) {
				 empOption = empMenu.EmpMenuList();
				 switch(empOption) {
				 case "1":
					 System.out.println("mad it here");
					 break;
				 case "2":
					 break;
				 case "3":
					 break;
				 case "4":
					 break;
				 default: break;
				 }
			}else {
				System.out.println("Invalid Username or Password - Returning to Main Menu.\n");				
			}
			break;
		case "3":
			CreateAccount();		
			break;
		case "4":
			System.out.println("See You Again!");
			System.exit(0);
			break;			
		default:			
			break;
		}
	}
	
	
	
}
