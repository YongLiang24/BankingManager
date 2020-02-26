package com.revature.project00;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankingLogicsTest {

	BankingLogics bk = new BankingLogics(5);
	@Test
	void testValidateBalance() {
		
		double x =bk.validateBalance();
		assertTrue(x == 10);
	}
	
	@Test
	void testValidateId() {
		
		int x =bk.validateAccountId();
		assertTrue(x == 10);
	}
	
	

}
