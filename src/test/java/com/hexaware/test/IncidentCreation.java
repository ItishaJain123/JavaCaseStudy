/**
 * This class contains JUnit test cases for testing the functionality of the insertIncident method
 * in the IncidentDao class.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.IncidentDao;

public class IncidentCreation {
	private static IncidentDao testIncidentDao;

	/**
	 * Sets up the test environment by initializing the testIncidentDao instance
	 * before each test case.
	 */
	@Before
	public void setUp() {
		testIncidentDao = new IncidentDao(); // Initialize the testIncidentDao
	}

	/**
	 * Test case to verify the insertion of an incident into the database.
	 * 
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void testInsertIncident() {
		assertEquals(true, testIncidentDao.insertIncident(10, "Test", LocalDate.parse("2024-09-09"), "testlocation",
				"testDescr", "CLOSED", 1, 2));
	}
}
