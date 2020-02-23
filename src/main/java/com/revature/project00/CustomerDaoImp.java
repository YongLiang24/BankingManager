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

	public static int count =0;

	@Override
	public void InsertCustomer(String query) {

		Connection conn = DBConnection.getInstance().getConnect();
		PreparedStatement preSt=null;
		try {
			preSt=conn.prepareStatement(query);
			count =preSt.executeUpdate();//count returns 1 when insert successfully	
		} catch (SQLException e) {
		}
	}
	@Override
	public ResultSet SelectAccount(String query) {
		ResultSet tempResult=null;
		PreparedStatement preSt=null;
		ResultSet resultSet=null;
		Connection conn = DBConnection.getInstance().getConnect();
		try {
			preSt=conn.prepareStatement(query);
			resultSet = preSt.executeQuery();
			tempResult = resultSet;
			resultSet =null;
			System.out.println(tempResult.getString(1));
			conn.close();
		} catch (SQLException e) {
		
		}
		return tempResult;
	}
}
