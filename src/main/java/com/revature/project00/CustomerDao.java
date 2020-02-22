package com.revature.project00;

import java.sql.Connection;
import java.sql.ResultSet;

public interface CustomerDao {
	/**
	 * This interface is part of the customer DAO pattern design and has defined 
	 * two methods to perform the CRUD operations.
	 * @param conn
	 * @param query
	 */
	public void InsertCustomer(Connection conn, String query);
	public ResultSet SelectAccount(Connection conn, String query);
}
