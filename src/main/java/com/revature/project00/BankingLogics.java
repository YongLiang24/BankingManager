package com.revature.project00;

public class BankingLogics {

	Customer ct;
	CustomerDaoImp ctDao;
	
	public BankingLogics() {
		super();
		Menus menu = new Menus();
		//menu.MainMenuDisplay();
		/*
		 * //menu.CustomerMenuDisplay(); Customer me =menu.SignupMenuDisplay();
		 * 
		 * System.out.println(me.getFullName());
		 */
		
		 // Customer you = menu.CustomerLogin(); 
		 // System.out.println(you.getPassword());
		 
		//menu.BankingMenu();
		
		menu.ApplyForAccount();
	}
	
	
}
