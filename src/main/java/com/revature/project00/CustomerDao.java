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
	public void insertCustomer(String query);
	public ResultSet selectAccount(String query);
}
