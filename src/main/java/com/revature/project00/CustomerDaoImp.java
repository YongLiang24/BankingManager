package com.revature.project00;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImp implements CustomerDao{

	/**
	 * This class implements the customerDAO interface and completes the methods.
	 * Both two methods takes a Connection object and a string query and executes
	 * prepared statements.
	 */
	Connection conn = DBConnection.getInstance().getConnect();
	public static int count =0;

	@Override
	public void insertCustomer(String query) {

		
		PreparedStatement preSt=null;
		try {
			preSt=conn.prepareStatement(query);
			count =preSt.executeUpdate();//count returns 1 when insert successfully	
		} catch (SQLException e) {
		}
	}
	@Override
	public ResultSet selectAccount(String query) {
		ResultSet tempResult=null;
		PreparedStatement preSt=null;
		ResultSet resultSet=null;
		try {
			preSt=conn.prepareStatement(query);
			resultSet = preSt.executeQuery();
			tempResult = resultSet;
			resultSet =null;
			tempResult.getString(1);
			conn.close();
		} catch (SQLException e) {
		
		}
		return tempResult;
	}
}
