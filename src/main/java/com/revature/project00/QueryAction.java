package com.revature.project00;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryAction {

	private static PreparedStatement pStatement = null;
	private static ResultSet resultSet = null;
	
	public static ResultSet SelectQuery(Connection conn, String query) {
		try {
			pStatement=conn.prepareStatement(query);
			resultSet = pStatement.executeQuery();
		} catch (SQLException e) {
		
		}
		return resultSet;
	}
	
	public static int InsertUpdateDeleteQuery(Connection conn, String query) {
		int result=0;		
		try {
			pStatement=conn.prepareStatement(query);
			pStatement.executeUpdate();
		} catch (SQLException e) {
		}
		return result;
	}

}
