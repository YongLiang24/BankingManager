package com.revature.project00;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImp implements CustomerDao{

	Customer ct;//declare a customer object
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
