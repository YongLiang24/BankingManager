package com.revature.project00;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankingLogics extends Menus {


	Connection conn = DBConnection.getInstance().getConnect();	
	Customer ct;
	boolean switchOn = true;

	public BankingLogics() {
		super();
		do {
			MainLogic(MainMenuDisplay());
		} while (switchOn);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void MainLogic(String result) {
		switch (result) {
		case "1":
			String option = CustomerMenuDisplay();
			switch (option) {
			case "1":
				Customer ct = CustomerLogin();
				if(ValidateCustomerLogin(ct.getUsername(), ct.getPassword())) {
					System.out.println("         ***************");
					System.out.println("           Login Success. ");
					System.out.println("         ***************");
					BankingMenu();
					
				}else {

					System.out.println("****************************************************");
					System.out.println("  Incorrect username or password. Please try again. ");
					System.out.println("****************************************************");
					
				}
				break;
			case "2":
				break;
			case "3":
				break;
			default:
				break;
			}
			break;
		case "2":
			EmpLogin();
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

	/*
	 * private boolean ValidateCustomerLogin(String username, String password) {
	 * String query="select * from Customer"; result = ctDao.SelectAccount(conn,
	 * query); try { while(result.next()) {
	 * System.out.println(result.getString("account_name"));
	 * 
	 * if(!username.equals(result.getString("account_name"))) {
	 * System.out.println("Account not found, please register a new one."); } else
	 * if(!password.equals(result.getString("account_pass"))) {
	 * System.out.println("Password does not match, please try again."); } else
	 * if(username.equals(result.getString("account_name")) &&
	 * password.equals(result.getString("account_pass")) ) { BankingMenu(); }else {
	 * System.out.println("Errors occur"); }
	 * 
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { } return false; }
	 */
	private boolean ValidateCustomerLogin(String username, String password) {
		String query ="select * from customer";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet resultSet = ctDao.SelectAccount(conn, query);
		try {
			while(resultSet.next()) {
				 if(!(username.equals(resultSet.getString("account_name"))|| password.equals(resultSet.getString("account_pass"))))
				 	{
					 return false;
					} 
				 else if(username.equals(resultSet.getString("account_name")) &&  password.equals(resultSet.getString("account_pass")) )
				 	{
					 return true;
					}
			}
		} catch (SQLException e) {
		}
		return false;
	}
}

//dwdaw//dwadwa
