package com.revature.project00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection instanceObj;//declare instance of this class
	private static Connection connect =null;
	
	private DBConnection() {};//private constructor
	
	public static DBConnection getInstance() {
		if(instanceObj==null) {
			instanceObj = new DBConnection();
		}
		return instanceObj;
	}
	
	public static Connection getConnect() {
		if(connect == null) {
			try {
				String hostURL = "jdbc:oracle:thin:@localhost:1521:yong";
				String username ="HR";
				String password="HR";
				connect = DriverManager.getConnection(hostURL, username, password);
			} catch (SQLException e) {
			//e.printStackTrace();
			}
		}
		return connect;
	}
		
}
