/**
 * This class contains JUnit test cases for testing the functionality of the updateIncidentStatus method
 * in the IncidentDao class.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.IncidentDao;

public class IncidentStatusUpdateTest {
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
	 * Test case to verify the update of incident status in the database.
	 * 
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void testUpdateIncidentStatus() {
		assertEquals(true, testIncidentDao.updateIncidentStatus(3, "UNDER_INVESTIGATION"));
	}
}
