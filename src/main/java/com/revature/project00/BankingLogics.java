package com.revature.project00;

import java.sql.ResultSet;

public class BankingLogics extends Menus {	
	boolean switchOn = true;

	public BankingLogics() {
		super();
		do {
			MainLogic(MainMenuDisplay());
		} while (switchOn);

	}

	private void MainLogic(String result) {
		switch (result) {
		case "1":
			String option = CustomerMenuDisplay();
			switch (option) {
			case "1":
				Customer ct = CustomerLogin();
				String ctQuery ="select * from customer";
				if(ValidateLogin(ct.getUsername(), ct.getPassword(), ctQuery)) {			
					BankingMenu();					
				}
				break;
			case "2":
				Customer ct1 = SignupCustomerAccount();
				CreateCtAccount(ct1.getFullName(),ct1.getUsername(),ct1.getPassword());
				break;
			case "3":
				break;
			default:
				break;
			}
			break;
		case "2":
			Employee emp = EmpLogin();
			System.out.println(emp.getEmpUsername() + "///"+emp.getEmpPassword());
			String empQuery="select * from employee";
			if(ValidateLogin(emp.getEmpUsername(), emp.getEmpPassword(), empQuery)) {
				EmpLoggedMenu();				
			}
			break;
		case "3":
			System.out.println("Program Terminated");
			System.out.println("``````````````````````````````````");
			System.exit(0);
			break;
		default:
			break;
		}

	}
	
	private void CreateCtAccount(String fullName, String accountName, String accountPass) {
		String autopk="Autopk1.nextval";
		String insertQuery ="insert into customer values('"+fullName+"','"+accountName+"','"+accountPass+"',"+autopk+")";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ctDao.InsertCustomer(insertQuery);
		switch(CustomerDaoImp.count) {
		case 0:
			System.out.println("   This account name already exists. Please choose another one ");
			System.out.println("````````````````````````````````````````````````````````````````````");
			break;
		case 1:
			System.out.println("     Account created successfully");
			System.out.println("``````````````````````````````````");
			break;
		default:
			break;
		}
		
	}

}

//dwdaw//dwadwa
