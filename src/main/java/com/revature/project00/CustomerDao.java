package com.revature.project00;

import java.sql.Connection;
import java.sql.ResultSet;

public interface CustomerDao {
	public void InsertCustomer(Connection conn, String query);
	public ResultSet SelectAccount(Connection conn, String query);
}
