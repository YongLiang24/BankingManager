package com.revature.jdbc001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTesting {

	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String name = "ACCOUNTING";
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:yong", "HR", "HR");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			stmt=conn.createStatement();
			String query = "select * from Department where DEPT_NAME='"+name+"'";
			 rs=stmt.executeQuery(query);
			 
			 while(rs.next()) {
				 //System.out.println(rs.getInt(1)+""+rs.getString(2));
				 //1 indicates the first column, 2 for second column and so on
				 //column index starts from 1
				 //also works with column name rs.getString("column name")
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
				 System.out.println("hello");
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
