package com.revature.project00;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DatabaseCommunicateTest {
	DatabaseCommunicate dc = new DatabaseCommunicate();
	@Test
	void testDisplayTfLogs() {
		List myList = new ArrayList();
		ResultSet result =dc.displayTfLogs();
		try {
			while(result.next()) {
				myList.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(myList.size() <1);
		
	}

}
