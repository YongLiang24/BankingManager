package com.revature.project00;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCommunicate {

	public void displayTfLogs() {
		String tfLog = "select * from account_balance_log";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		ResultSet result = ctDao.SelectAccount(tfLog);
		try {
			while(result.next()) {
				double transAmount =result.getDouble(3)-result.getDouble(5);
				System.out.println("                   **********Transaction Logs**********\n");
				System.out.println(" Account Name: "+result.getString(1)+" | ID: "+result.getInt(2)+" | Trans Amount: $"+transAmount+" | New Balance: $"+result.getDouble(3)+" | Previous Balance: $"+result.getDouble(5)+" | Time: "+result.getString(4)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
