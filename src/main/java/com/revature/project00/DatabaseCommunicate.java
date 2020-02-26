package com.revature.project00;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DatabaseCommunicate implements ScannerInput {


	
	public ResultSet displayTfLogs() {
		String tfLog = "select * from account_balance_log order by updated_time";
		CustomerDaoImp ctDao = new CustomerDaoImp();
		int i=0;
		logger.info("An employee views the transaction log");
		ResultSet result = ctDao.selectAccount(tfLog);
		ResultSet testResult = result;
		boolean isLogEmpty =false;
		try {

			System.out.println("           **********Transaction Logs**********\n");
			while(result.next()) {
				if(!result.getString(1).isEmpty()) {
					isLogEmpty=true;
				}
				i++; 
				double transAmount =result.getDouble(3)-result.getDouble(5);
				System.out.println(i+".Account Name: "+result.getString(1)+"\t ID: "+result.getInt(2)+"\t Amount Transferred: $"+transAmount+"\t Time: $"+result.getString(4)+"\t Previous Balance: $"+result.getDouble(5)+" \t New Balance: "+result.getDouble(3)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(isLogEmpty==false) {
			System.out.println("                     Empty Log\n");
		}
		
		return testResult;
	}
	
	
}
