package com.revature.project00;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ScannerInput {
/**
 * This interface provides a scanner object for any class which implements this
 */
	Scanner input = new Scanner(System.in);
	static final Logger logger = LogManager.getLogger(DatabaseCommunicate.class);
}
