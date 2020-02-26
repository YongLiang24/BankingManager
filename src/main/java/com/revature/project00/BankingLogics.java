package com.revature.project00;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Need refactoring codes in this class.
 * @author yongl
 *
 */
public class BankingLogics extends Menus {	
	boolean switchOn = true;
	boolean isCtLogged = true;
	boolean isEmpLogged =true;
	public BankingLogics() {
		super();
	

	}
	
	public void runApp() {
		do {
			mainLogic(mainMenuDisplay());
		} while (switchOn);
	}

	//testing constructor
	public BankingLogics(int t) {
		
	}
	private void mainLogic(String result) {
		switch (result) {
		case "1":

			isCtLogged =true;
			String option = customerMenuDisplay();
			switch (option) {
			case "1":
				Customer ct = customerLogin();
				validLoginCt(ct.getUsername(), ct.getPassword());
				logger.info("A customer logged in the transaction log");
				break;
			case "2":
				Customer ct1 = signupCustomerAccount();
				createCtAccount(ct1.getFullName(),ct1.getUsername(),ct1.getPassword());
				logger.info("Customer create an account");
				break;
			case "3":
				break;
			default:
				break;
			}
			break;
		case "2":
			isEmpLogged = true;
			System.out.println("     Test Account: admin   Password: 123");
			Employee emp = empLogin();
			validLoginEmp(emp.getEmpUsername(), emp.getEmpPassword());
			logger.info("An employee signed in");
			break;
		case "3":
			System.out.println("      Program Terminated");
			System.out.println("``````````````````````````````````");
			System.exit(0);
			break;
		default:
			break;
		}

	}
	
	private void createCtAccount(String fullName, String accountName, String accountPass) {
		String autopk="Autopk1.nextval";
		String insertQuery ="insert into customer values('"+fullName+"','"+accountName+"','"+accountPass+"',"+autopk+")";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ctDao.insertCustomer(insertQuery);
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
	
	private void createBkAccount(int customerId,String accountName, double accountBalance, String accountType ) {
		String autopk="Autopk1.nextval";
		String status ="false";
		String insertQuery ="insert into accounts values('"+customerId+"',"+autopk+",'"+accountName+"',"+accountBalance+",'"+accountType+"','"+status+"')";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ctDao.insertCustomer(insertQuery);
		switch(CustomerDaoImp.count) {
		case 0:
			System.out.println("   Error occurred, account was not created ");
			System.out.println("`````````````````````````````````````````````");
			break;
		case 1:
			System.out.println("     Account created successfully, approval from the bank is required before using it");
			System.out.println("``````````````````````````````````");
			break;
		default:
			break;
		}
		
	}
	
	private void validLoginCt(String username, String userpass) {
		  String query ="select * from Customer";  
		  CustomerDaoImp ctDao = new CustomerDaoImp();	  
		  ResultSet result =ctDao.selectAccount(query);
		  boolean isCtLogged=false;
		  
		  try { while(result.next()) {
			  if(username.equals(result.getString("account_name")) &&  userpass.equals(result.getString("account_pass"))) {
				  System.out.println("        login success");
				  System.out.println("````````````````````");
				  System.out.println("        Greeting "+result.getString("full_name"));
				  isCtLogged = true;					 
				  int ctId = result.getInt("customer_id");
				  while(isCtLogged) {
				  String ctOption =bankingMenu();			
				  switch(ctOption) {
				  case"1":
					  BankAccount bk =applyForAccount();
					  createBkAccount(ctId,bk.getBankAccountName(), bk.getBalance(), bk.getAccountType());
					  logger.info("customer  created a banking account");
					  break;
				  case "2":
					  viewAccountBalance(ctId);
					  logger.info("customer viewd balance");
					  break;
				  case"3":
					  accountWithdraw(ctId);
					  logger.info("customer withdraw balance");
					  break;
				  case "4":
					  accountDeposite(ctId);
					  logger.info("customer made a deposite");
					  break;
				  case "5":
					  accountTransfer(ctId);
					  logger.info("customer made a transfer");
					  break;
				  case "6":
					  isCtLogged=false;
					  break;
				  default: break;
				  }
				  }
			  }
		  }
		  if(isCtLogged == false) {
			  System.out.println("      Error: Incorrect username or password\n");
			  System.out.println("``````````````````````````````````````````````````");
		  }
//		  System.out.println("   Account name or password does not match");
//		  System.out.println("````````````````````````````````````````````");
			  } 
			  catch
			  (SQLException e) { 
				  e.printStackTrace(); 
				  }
	}
	
	private void validLoginEmp(String username, String userpass) {
		  String query ="select * from Employee";  
		  CustomerDaoImp ctDao = new CustomerDaoImp();		  
		  ResultSet result =ctDao.selectAccount(query);		
		  try { while(result.next()) {
			  if(username.equals(result.getString("account_name")) &&  userpass.equals(result.getString("account_pass"))) {
				  System.out.println("            login success");
				  while(isEmpLogged) {
				  String empOption = empLoggedMenu();
				  switch(empOption) {
				  case"1":
					  System.out.println("**************Pending Accounts**************\n");
					  approveAccounts();	
					  logger.info("An employee approves an account");
					  break;
				  case "2":
					  rejectAccounts();
					  break;
				  case"3":
					  empViewAccounts();
					  logger.info("an employee views all bank accounts");
					  break;
				  case"4":
					  displayTfLogs();
					  System.out.println("              *Enter any key to return");
					  input.nextLine();
					  break;
				  case"5":
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
	
	void approveAccounts() {
		String allAccountQuery ="Select * from accounts";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result =ctDao.selectAccount(allAccountQuery);
		boolean isPendingEmpty=false;
		try {
			while(result.next()) {
				
				if(result.getString(6).equals("false")) {
					isPendingEmpty=true;
					System.out.println("CustomerID: "+result.getInt(1)+" | AccountID: "+result.getInt(2)+" | AccountName: "+result.getString(3) + " | Balance: "+result.getDouble(4)+" | Type:"+result.getString(5)+" | Status: "+result.getString(6)+"\n");
				}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isPendingEmpty==false) {
			System.out.println("       No accounts are pending. Press any keys to return\n");
		}		
		System.out.println("      Please enter an AccountID to change the status and approve the account.");
		String empInput = input.nextLine();
		String updateStatusQuery="update Accounts set status='true' where account_id ="+empInput;
//		CustomerDaoImp ctDao1 = new CustomerDaoImp();
		ctDao.insertCustomer(updateStatusQuery);
		if(CustomerDaoImp.count ==1) {
			System.out.println("     Account Approved Successfully");
			System.out.println("`````````````````````````````````````````");
		}else {
			System.out.println("     Incorrect Account ID, Try again");
			System.out.println("`````````````````````````````````````");
		}
	}
	
	void rejectAccounts() {
		String allAccountQuery ="Select * from accounts";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result =ctDao.selectAccount(allAccountQuery);
		boolean isPendingEmpty=false;
		try {
			while(result.next()) {
				
				if(result.getString(6).equals("false")) {
					isPendingEmpty=true;
					System.out.println("CustomerID: "+result.getInt(1)+" | AccountID: "+result.getInt(2)+" | AccountName: "+result.getString(3) + " | Balance: "+result.getDouble(4)+" | Type:"+result.getString(5)+" | Status: "+result.getString(6)+"\n");
				}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isPendingEmpty==false) {
			System.out.println("       No accounts are pending. Press any keys to return\n");
		}		
		System.out.println("      Please enter an AccountID to reject an account");
		String empInput = input.nextLine();
		String updateStatusQuery="delete from accounts where account_id ="+empInput;
//		CustomerDaoImp ctDao1 = new CustomerDaoImp();
		ctDao.insertCustomer(updateStatusQuery);
		if(CustomerDaoImp.count ==1) {
			System.out.println("     Account Rejected");
			System.out.println("`````````````````````````````````````````");
		}else {
			System.out.println("     Incorrect Account ID, Try again");
			System.out.println("`````````````````````````````````````");
		}
	}
	
	
	void empViewAccounts() {
		String trueAccountsQuery = "select full_name, bkaccount_name, Balance, account_type from customer inner join accounts using (customer_id) where status='true' order by full_name";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result=ctDao.selectAccount(trueAccountsQuery);
		boolean isBkAccountEmpty=false;
		try {
			while(result.next()) {
				if(!result.getString(1).isEmpty()) {
					isBkAccountEmpty=true;
				}
				System.out.println("Name: "+result.getString(1)+" | Account: "+result.getString(2)+" | Balance: $"+result.getDouble(3) + " | Type: "+result.getString(4)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(isBkAccountEmpty==false) {
			System.out.println("      No Bank Accounts Available\n");
			System.out.println("      Enter Any Key to Return");
			input.nextLine();
		}
	}
	
	void viewAccountBalance(int customerId) {
		String viewBalanceQuery="select account_id, bkaccount_name, Balance, account_type, status from customer inner join accounts using (customer_id) where customer_id="+customerId;
		CustomerDaoImp ctDao = new CustomerDaoImp();
		boolean isAccountEmpty = true;
		ResultSet result = ctDao.selectAccount(viewBalanceQuery);
		try {
				System.out.println("************My Accounts**********\n");
			while(result.next()) {	
				if(result.getString(5).equals("true")) {
				System.out.println("Account: "+result.getString(2)+" | Balance: "+result.getDouble(3)+" | Type: "+result.getString(4)+"\n");
					isAccountEmpty = false;
				}
			}
			if(isAccountEmpty) {
				System.out.println("      No accounts available\n");
			}
				System.out.println("*********************************");
				System.out.println("    Enter any key to return");
				input.nextLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	void accountWithdraw(int customerId) {
		String viewBalanceQuery="select account_id, bkaccount_name, Balance, account_type, status from customer inner join accounts using (customer_id) where customer_id="+customerId;
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.selectAccount(viewBalanceQuery);
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
		int accId = validateAccountId();
		double withdrawAmount = validateWithdrawAmount();
		double difference;

		ResultSet result2 = ctDao.selectAccount(viewBalanceQuery);
		try {
			while(result2.next()) {
				if(result2.getInt(1)==accId && result2.getDouble(3)>=withdrawAmount && result2.getString("status").equals("true")) {
					isWithdrawValid = false;
					difference = result2.getDouble(3)- withdrawAmount;				
					String updateBalQuery="update accounts set balance="+difference+"where account_id="+result2.getInt(1);
					CustomerDaoImp ctDao1 = new CustomerDaoImp();
					ctDao1.insertCustomer(updateBalQuery);
					System.out.println("$"+withdrawAmount+" has been withdrawn from account with id: "+result2.getInt(1)+"\n");	
					System.out.println("The new balance is now $"+difference);
					System.out.println("````````````````````````````````````````````````````````````````````````");
				}
			}
			if(isWithdrawValid) {
				System.out.println("      The Transaction has been cancelled due to account information mismatch\n");
				System.out.println("`````````````````````````````````````````````````````````````````");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	void accountDeposite(int customerId) {
		String viewBalanceQuery="select account_id, bkaccount_name, Balance, account_type, status from customer inner join accounts using (customer_id) where customer_id="+customerId;
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.selectAccount(viewBalanceQuery);
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
		
		int accId=validateAccountId();
		double depositeAmount = validateDepositeAmount();
		double sum;
		boolean isWithdrawValid = true;
		ResultSet result2 = ctDao.selectAccount(viewBalanceQuery);
		try {
			while(result2.next()) {
				if(result2.getInt(1)==accId && result2.getString("status").equals("true")) {
					isWithdrawValid = false;
					sum = result2.getDouble(3) + depositeAmount;				
					String updateBalQuery="update accounts set balance="+sum+"where account_id="+result2.getInt(1);
					CustomerDaoImp ctDao1 = new CustomerDaoImp();
					ctDao1.insertCustomer(updateBalQuery);
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
	
	void accountTransfer(int customerId) {
		
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		String viewAccountQuery="select * from accounts where status = 'true'";
		CustomerDaoImp ctDao1 = new CustomerDaoImp();
		ResultSet result1 = ctDao1.selectAccount(viewAccountQuery);
		try {
			System.out.println("************Transfer**********\n");
			while(result1.next()) {
				BankAccount bkInfo = new BankAccount(result1.getInt(2), result1.getString(3), result1.getDouble(4), result1.getString(5), result1.getInt(1));
				accountList.add(bkInfo);
				//System.out.println("Customer name: "+result.getString(1)+" | Account Name: " +result.getString(2)+" | Customer Id:"+result.getInt(3)+"\n");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String tranOption = transferMenu();
		boolean isSearchValid = true;
		switch(tranOption) {
		case "1":
			System.out.println("      Search by name:\n");
			String searchInput= input.nextLine();
			for(BankAccount bk: accountList) {
				
				if(bk.getBankAccountName().toLowerCase().contains(searchInput)) {
					System.out.println("   Account Name: "+bk.getBankAccountName()+" | Account ID: "+bk.getAccountId()+" | Account Type: "+bk.getAccountType()+"\n");
					isSearchValid = false;
				}
			}
			
			if(isSearchValid) {
				System.out.println("            No Account Found");
			}else {
				int actId =validateTransferAccId();//transfer to account Id
				double tfAmount =validateTransferAmount();
				for(BankAccount bk: accountList) {
					if(bk.getCustomerId() == customerId) {
					System.out.println("    Your Banking Accounts:\n");
					System.out.println("    Account ID: "+bk.getAccountId()+" | Account Name: "+bk.getBankAccountName()+" | Balance: "+bk.getBalance()+" | Account Type: "+bk.getAccountType()+"\n");
					
					}
				}
				int bkAccountId =validateTransferId();//transfer from account id
				
				boolean isTransferFrom = false;
				boolean isTransferTo = false;
				double tfDifference=0;
				double tfSum=0;
				for(BankAccount bk: accountList) {
					if(bk.getAccountId() == bkAccountId && bk.getBalance() >= tfAmount) {
						 tfDifference = bk.getBalance() -tfAmount;
						isTransferFrom = true;
						
					}
					
					if(bk.getAccountId() == actId) {
						tfSum=bk.getBalance() + tfAmount;
						isTransferTo = true;
					}				
				}
				
				if(isTransferFrom && isTransferTo) {
					//perform the update and success message
					System.out.println("      $"+tfAmount+" has successfully transferred\n");
					String updateTransferFrom="update accounts set balance= "+tfDifference+" where account_id="+bkAccountId;
					String updateTransferTo="update accounts set balance = "+tfSum+" where account_id="+actId;
					ctDao1.insertCustomer(updateTransferFrom);
					ctDao1.insertCustomer(updateTransferTo);
					
				}else {
					System.out.println("      Incorrect information, the transaction has been cancelled");
				}			
			}		
			break;
		case"2":
			break;
		default:break;
		}
		
	}
		
}


