package com.revature.project00;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = DBConnection.getInstance().getConnect();
	
		String query2 = "select * from Department where DEPT_ID >0";//? is a parameter
	
		ResultSet result = QueryAction.SelectQuery(conn, query2);
		
		 try {
			while(result.next()) {
				 System.out.println(result.getInt("DEPT_ID")+" "+result.getString(2)+" "+result.getDouble(3));
			 }
		} catch (SQLException e) {
			//e.printStackTrace();
		}

		String query3 ="insert into Department values (12,'home', 4000)";
		
		QueryAction.InsertUpdateDeleteQuery(conn, query3);
	}

}
