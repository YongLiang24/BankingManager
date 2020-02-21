package com.revature.banking_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;
public class CallableDemo {
	public static void main(String[] args) {
		Connection con=null;
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setServerName("localhost");
			ods.setServiceName("yong");
			ods.setDriverType("thin");
			ods.setPortNumber(1521);
			ods.setUser("yongliang");
			ods.setPassword("yl");
			 con = ods.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CallableStatement cstmt = null;
		//emp_name
		String sql = "{call emp_name (?, ?)}";
	      try {
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, 107);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();
			String empName = cstmt.getString(2);
			System.out.println("Employee Name : "+empName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
