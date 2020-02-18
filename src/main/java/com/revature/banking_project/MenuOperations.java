package com.revature.banking_project;

public class MenuOperations extends BankAccounts implements AccountRegister{
	
	private String mainOption;
	MainMenu mainMenu = new MainMenu();
	CustomerMenu ctMenu = new CustomerMenu();
	EmployeeMenu empMenu = new EmployeeMenu();
	boolean switchOn = true;
	boolean ctSwitch;
	String currentCustomerAccount;
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
			System.out.println("Welcome to Customer Login.\n");
			System.out.println(systemMessage+"Username:");
			String userName = input.nextLine();
			System.out.println(systemMessage+"Password: ");
			String userPassword = input.nextLine();
			if(IsAccountValid(userName, userPassword)) {
				ctSwitch = true;	
				while(ctSwitch == true){
					switch(ctMenu.CTMenuList()) {
					case "1":
						applyBankAccount();
						break;
					case "2":
						ViewBalance();
						break;
					case "3":
						AddDeposit();
						break;
					case "4":
						WithdrawBalance();
						break;
					case "5":
						ctSwitch =false;
						break;
					}						
				}
			}else {
				System.out.println(systemMessage+"Invalid Username or Password, Please register.\n");				
			}			
			break;
		case "2":
			System.out.println("Welcome to Employee Login\n");
			System.out.println(systemMessage+"Test Account: name: admin - pass: 123\n");
			System.out.println(systemMessage+"username: ");
			String empName = input.nextLine();
			System.out.println(systemMessage+"password: ");
			String empPassword = input.nextLine();
			if(IsEmpValid(empName, empPassword)) {
				ctSwitch = true;
				while(ctSwitch) {
					 switch(empMenu.EmpMenuList()) {
					 case "1":
						DisplayPreApproveAccount();
						System.out.println(systemMessage+"Please type a account name to submit approval.");
						String approveName = input.nextLine();
						ApproveAccount(approveName);
						 break;
					 case "2":
						 ViewBankAccount();
						 break;
					 case "3":
						 System.out.println(systemMessage+"View log is not available");
						 break;
					 case "4":
						 ctSwitch =false;
						 break;
					 default: break;
					 }
				}			

			}else {
				System.out.println(systemMessage+"Invalid Username or Password - Returning to Main Menu.\n");				
			}
			break;
		case "3":
			CreateAccount();		
			break;
		case "4":
			System.out.println(systemMessage+"See You Again!");
			System.exit(0);
			break;			
		default:			
			break;
		}
	}	
}
