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
	
	private void ValidLoginCt(String username, String userpass) {
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
					  ViewAccountBalance(ctId);
					  break;
				  case"3":
					  AccountWithdraw(ctId);
					  break;
				  case "4":
					  AccountDeposite(ctId);
					  break;
				  case "5":
					  AccountTransfer(ctId);
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
	
	private void ValidLoginEmp(String username, String userpass) {
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
					  //View Logs, yet to implement
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
		String trueAccountsQuery = "select full_name, bkaccount_name, Balance, account_type from customer inner join accounts using (customer_id) order by full_name";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result=ctDao.SelectAccount(trueAccountsQuery);
		try {
			while(result.next()) {
				if(result.getString("status").equals("true"))
				System.out.println("Name: "+result.getString(1)+" | Account: "+result.getString(2)+" | Balance: $"+result.getDouble(3) + " | Type: "+result.getString(4)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void ViewAccountBalance(int customerId) {
		String viewBalanceQuery="select account_id, bkaccount_name, Balance, account_type, status from customer inner join accounts using (customer_id) where customer_id="+customerId;
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.SelectAccount(viewBalanceQuery);
		try {
				System.out.println("************My Accounts**********\n");
			while(result.next()) {	
				if(result.getString(5).equals("true"))
				System.out.println("Account: "+result.getString(2)+" | Balance: "+result.getDouble(3)+" | Type: "+result.getString(4)+"\n");
			}
				System.out.println("*********************************");
				System.out.println("    Enter any keys to go back");
				input.nextLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	void AccountWithdraw(int customerId) {
		String viewBalanceQuery="select account_id, bkaccount_name, Balance, account_type, status from customer inner join accounts using (customer_id) where customer_id="+customerId;
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.SelectAccount(viewBalanceQuery);
		boolean isWithdrawValid = true;
		try {
			System.out.println("************Withdrawal**********\n");
			while(result.next()) {
				if(result.getString("status").equals("true"))
				System.out.println("Account ID: "+result.getString(1)+" | Account Name: " +result.getString(2)+" | Balance: "+result.getDouble(3)+" | Type: "+result.getString(4)+"\n");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int accId = ValidateAccountId();
		double withdrawAmount = ValidateWithdrawAmount();
		double difference;

		ResultSet result2 = ctDao.SelectAccount(viewBalanceQuery);
		try {
			while(result2.next()) {
				if(result2.getInt(1)==accId && result2.getDouble(3)>=withdrawAmount && result2.getString("status").equals("true")) {
					isWithdrawValid = false;
					difference = result2.getDouble(3)- withdrawAmount;
					
					String updateBalQuery="update accounts set balance="+difference+"where account_id="+result2.getInt(1);
					CustomerDaoImp ctDao1 = new CustomerDaoImp();
					ctDao1.InsertCustomer(updateBalQuery);
					System.out.println("$"+withdrawAmount+" has been withdrawn from account with id: "+result2.getInt(1)+"\n");	
					System.out.println("The new balance is now $"+difference);
					System.out.println("````````````````````````````````````````````````````````````````````````");
				}
			}
			if(isWithdrawValid) {
				System.out.println("      The Transaction has been cancelled due to account mismatch\n");
				System.out.println("`````````````````````````````````````````````````````````````````");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	void AccountDeposite(int customerId) {
		String viewBalanceQuery="select account_id, bkaccount_name, Balance, account_type, status from customer inner join accounts using (customer_id) where customer_id="+customerId;
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.SelectAccount(viewBalanceQuery);
		try {
			System.out.println("************Deposite**********\n");
			while(result.next()) {
				if(result.getString("status").equals("true"))
				System.out.println("Account ID: "+result.getString(1)+" | Account Name: " +result.getString(2)+" | Balance: "+result.getDouble(3)+" | Type: "+result.getString(4)+"\n");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	//implements userInput and performs the deposite calculation
		
		int accId=ValidateAccountId();
		double depositeAmount = ValidateDepositeAmount();
		double sum;
		boolean isWithdrawValid = true;
		ResultSet result2 = ctDao.SelectAccount(viewBalanceQuery);
		try {
			while(result2.next()) {
				if(result2.getInt(1)==accId && result2.getString("status").equals("true")) {
					isWithdrawValid = false;
					sum = result2.getDouble(3) + depositeAmount;				
					String updateBalQuery="update accounts set balance="+sum+"where account_id="+result2.getInt(1);
					CustomerDaoImp ctDao1 = new CustomerDaoImp();
					ctDao1.InsertCustomer(updateBalQuery);
					System.out.println("$"+depositeAmount+" has been deposited to account with id: "+result2.getInt(1)+"\n");	
					System.out.println("The new balance is now $"+sum);
					System.out.println("````````````````````````````````````````````````````````````````````````");
				}
			}
			if(isWithdrawValid) {
				System.out.println("      The Transaction has been cancelled due to account mismatch\n");
				System.out.println("`````````````````````````````````````````````````````````````````");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	void AccountTransfer(int customerId) {
		String viewCustomerQuery="select full_name, account_name,customer_id from customer order by full_name";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.SelectAccount(viewCustomerQuery);
		try {
			System.out.println("************Transfer**********\n");
			while(result.next()) {
				System.out.println("Customer name: "+result.getString(1)+" | Account Name: " +result.getString(2)+" | Customer Id:"+result.getInt(3)+"\n");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
		
}


