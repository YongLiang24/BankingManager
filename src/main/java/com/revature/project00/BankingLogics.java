package com.revature.project00;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankingLogics extends Menus {	
	boolean switchOn = true;
	boolean isCtLogged = true;
	boolean isEmpLogged =true;
	public BankingLogics() {
		super();
		do {
			MainLogic(MainMenuDisplay());
		} while (switchOn);

	}

	private void MainLogic(String result) {
		switch (result) {
		case "1":
			isCtLogged =true;
			String option = CustomerMenuDisplay();
			switch (option) {
			case "1":
				Customer ct = CustomerLogin();
				ValidLoginCt(ct.getUsername(), ct.getPassword());
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
			isEmpLogged = true;
			Employee emp = EmpLogin();
			ValidLoginEmp(emp.getEmpUsername(), emp.getEmpPassword());
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
	
	private void CreateBkAccount(int customerId,String accountName, double accountBalance, String accountType ) {
		String autopk="Autopk1.nextval";
		String status ="false";
		String insertQuery ="insert into accounts values('"+customerId+"',"+autopk+",'"+accountName+"',"+accountBalance+",'"+accountType+"','"+status+"')";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ctDao.InsertCustomer(insertQuery);
		switch(CustomerDaoImp.count) {
		case 0:
			System.out.println("   Error occurred, account was not created ");
			System.out.println("`````````````````````````````````````````````");
			break;
		case 1:
			System.out.println("     Bank account created successfully, approve from the bank is required before using");
			System.out.println("``````````````````````````````````");
			break;
		default:
			break;
		}
		
	}
	
	public void ValidLoginCt(String username, String userpass) {
		  String query ="select * from Customer";
	  
		  CustomerDaoImp ctDao = new CustomerDaoImp();
		  
		  ResultSet result =ctDao.SelectAccount(query);
		  
		  try { while(result.next()) {
			  if(username.equals(result.getString("account_name")) &&  userpass.equals(result.getString("account_pass"))) {
				  System.out.println("     login success");
				  System.out.println("````````````````````");
				  System.out.println("            Greeting "+result.getString("full_name"));
				  while(isCtLogged) {
				  String ctOption =BankingMenu();				 
				  int ctId = result.getInt("customer_id");
				  switch(ctOption) {
				  case"1":
					  BankAccount bk =ApplyForAccount();
					  CreateBkAccount(ctId,bk.getBankAccountName(), bk.getBalance(), bk.getAccountType());					  
					  break;
				  case "2":
					  break;
				  case"3":
					  break;
				  case "4":
					  break;
				  case "5":
					  break;
				  case "6":
					  isCtLogged=false;
					  break;
				  default: break;
				  }
				  }
			  }
		  }; 
//		  System.out.println("   Account name or password does not match");
//		  System.out.println("````````````````````````````````````````````");
			  } 
			  catch
			  (SQLException e) { 
				  e.printStackTrace(); 
				  }
	}
	
	public void ValidLoginEmp(String username, String userpass) {
		  String query ="select * from Employee";
	  
		  CustomerDaoImp ctDao = new CustomerDaoImp();
		  
		  ResultSet result =ctDao.SelectAccount(query);
		  
		  try { while(result.next()) {
			  if(username.equals(result.getString("account_name")) &&  userpass.equals(result.getString("account_pass"))) {
				  System.out.println("           login success");
				  while(isEmpLogged) {
				  String empOption = EmpLoggedMenu();
				  switch(empOption) {
				  case"1":
					  System.out.println("**************Pending Accounts**************\n");
					  ApproveAccounts();
					  
					  break;
				  case"2":
					  EmpViewAccounts();
					  break;
				  case"3":
					  break;
				  case"4":
					  isEmpLogged = false;
					  break;
				  default:break;
				  }
			  }
			  }
		  }; 
		  System.out.println("  Account name or password does not match");
			  } 
			  catch
			  (SQLException e) { 
				  e.printStackTrace(); 
				  }
	}
	
	void ApproveAccounts() {
		String allAccountQuery ="Select * from accounts";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result =ctDao.SelectAccount(allAccountQuery);
		try {
			while(result.next()) {
				if(result.getString(6).equals("false"))
				System.out.println("CustomerID: "+result.getInt(1)+" | AccountID: "+result.getInt(2)+" | AccountName: "+result.getString(3) + " | Balance: "+result.getDouble(4)+" | Type:"+result.getString(5)+" | Status: "+result.getString(6)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Please enter an AccountID to change the status and approve the account.");
		String empInput = input.nextLine();
		String updateStatusQuery="update Accounts set status='true' where account_id ="+empInput;
		CustomerDaoImp ctDao1 = new CustomerDaoImp();
		ctDao.InsertCustomer(updateStatusQuery);
		if(CustomerDaoImp.count ==1) {
			System.out.println("     Account Approved Successfully");
			System.out.println("````````````````````````````````````");
		}else {
			System.out.println("     Incorrect Account ID, Try again");
			System.out.println("`````````````````````````````````````");
		}
	}
	
	void EmpViewAccounts() {
		String TrueAccountsQuery = "select full_name, bkaccount_name, Balance, account_type from customer inner join accounts using (customer_id) order by full_name";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result=ctDao.SelectAccount(TrueAccountsQuery);
		try {
			while(result.next()) {
				System.out.println("Name: "+result.getString(1)+" | Account: "+result.getString(2)+" | Balance: $"+result.getDouble(3) + " | Type: "+result.getString(4)+"\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


