package com.revature.project00;

public class BankingLogics {

	Customer ct;
	CustomerDaoImp ctDao;
	
	public BankingLogics() {
		super();
		Menus menu = new Menus();
		//menu.MainMenuDisplay();
		//menu.CustomerMenuDisplay();
		Customer me =menu.SignupMenuDisplay();
		
		System.out.println(me.getFullName());
		
	}
	
	
}
