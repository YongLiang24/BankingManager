package com.revature.project00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * String query2 = "select * from Department where DEPT_ID >0";//? is a
		 * parameter
		 * 
		 * ResultSet result = QueryAction.SelectQuery(conn, query2);
		 * 
		 * try { while(result.next()) {
		 * System.out.println(result.getInt("DEPT_ID")+" "+result.getString(2)+" "
		 * +result.getDouble(3)); } } catch (SQLException e) { //e.printStackTrace(); }
		 * 
		 * String query3 ="insert into Department values (12,'home', 4000)";
		 * 
		 * QueryAction.InsertUpdateDeleteQuery(conn, query3);
		 * 
		 */

		 BankingLogics test = new BankingLogics();

		/*
		 * Connection conn =null; PreparedStatement pStatement = null; ResultSet
		 * resultSet = null;
		 * 
		 * try { conn =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:yong",
		 * "yongliang", "yl"); } catch (SQLException e) { e.printStackTrace(); } String
		 * query2 = "select * from Customer";//? is a parameter try {
		 * pStatement=conn.prepareStatement(query2); resultSet =
		 * pStatement.executeQuery(); while(resultSet.next()) {
		 * System.out.println(resultSet.getString(1)); } } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * try { conn.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		
		
		/*
		 * Connection conn = DBConnection.getInstance().getConnect();
		 * 
		 * String query ="select account_name from Customer";
		 * 
		 * CustomerDaoImp ctDao = new CustomerDaoImp();
		 * 
		 * ResultSet result =ctDao.SelectAccount(conn, query);
		 * 
		 * try { while(result.next()) {
		 * System.out.println(result.getString("account_name")); } conn.close(); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */
		 
		 

	}

}
