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

	@Override
	public void InsertCustomer(Connection conn, String query) {
		try {
			preSt=conn.prepareStatement(query);
			preSt.executeUpdate();
		} catch (SQLException e) {
		}
		
	}

	@Override
	public ResultSet SelectAccount(Connection conn, String query) {
		try {
			preSt=conn.prepareStatement(query);
			resultSet = preSt.executeQuery();
		} catch (SQLException e) {
		
		}
		return resultSet;
	}


}
