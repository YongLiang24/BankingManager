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
	private  PreparedStatement preSt = null;
	private  ResultSet resultSet = null;

	Connection conn = DBConnection.getInstance().getConnect();
	public static int count =0;

	@Override
	public void InsertCustomer(String query) {
		
		try {
			preSt=conn.prepareStatement(query);
			count =preSt.executeUpdate();//count returns 1 when insert successfully
		} catch (SQLException e) {
			count =0;//count returns 0 when insert fails
		}
	}

	@Override
	public ResultSet SelectAccount(String query) {
		try {
			preSt=conn.prepareStatement(query);
			resultSet = preSt.executeQuery();
		} catch (SQLException e) {
		
		}
		return resultSet;
	}


}
