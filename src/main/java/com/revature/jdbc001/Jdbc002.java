package com.revature.jdbc001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc002 {

	public static void main(String[] args) {
		
		Connection conn =null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		String name = "ACCOUNTING";

		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:yong", "HR", "HR");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query = "select * from Department where DEPT_NAME =? or DEPT_ID>?";//? is a parameter
		
		String insertQuery = "INSERT INTO Department VALUES (?, ?, ?)";
		
		
		try {
			pStatement = conn.prepareStatement(query);
			pStatement.setString(1, "ACCOUNTING");
			pStatement.setDouble(2, 500);
			resultSet = pStatement.executeQuery();
			
			
			 while(resultSet.next()) {
				 System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
			 }
			 
				String query2 = "select * from Department";//? is a parameter
				pStatement=conn.prepareStatement(query2);
				resultSet = pStatement.executeQuery();
				 while(resultSet.next()) {
					 System.out.println(resultSet.getInt("DEPT_ID")+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
				 }

			/*
			 * pStatement = conn.prepareStatement(insertQuery); pStatement.setInt(1, 5);
			 * pStatement.setString(2, "HR"); pStatement.setDouble(3, 3000); resultSet =
			 * pStatement.executeQuery();
			 */
			/*
			 * while(resultSet.next()) {
			 * System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "
			 * +resultSet.getDouble(3)); System.out.println("hello2"); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
