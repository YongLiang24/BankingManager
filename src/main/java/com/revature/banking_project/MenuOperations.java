package com.revature.banking_project;

public class MenuOperations extends BankAccounts implements AccountRegister{
	
	private String mainOption;
	MainMenu mainMenu = new MainMenu();
	CustomerMenu ctMenu = new CustomerMenu();
	EmployeeMenu empMenu = new EmployeeMenu();
	boolean switchOn = true;
	boolean ctSwitch;
	/**
	 * Constructor
	 */
	public MenuOperations() {
		empAccountMap.put("admin", "123");
		do {
		mainOption = mainMenu.MainMenuList();
		CustomerLoginMenu(mainOption);
		//input.close();
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
				ctSwitch = true;	
				while(ctSwitch == true){
					switch(ctMenu.CTMenuList()) {
					case "1":
						applyBankAccount();
						break;
					case "2":
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
						ctSwitch =false;
						break;
					}						
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
				ctSwitch = true;
				while(ctSwitch) {
					 switch(empMenu.EmpMenuList()) {
					 case "1":
						DisplayPreApproveAccount();
						 break;
					 case "2":
						 break;
					 case "3":
						 break;
					 case "4":
						 ctSwitch =false;
						 break;
					 default: break;
					 }
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
