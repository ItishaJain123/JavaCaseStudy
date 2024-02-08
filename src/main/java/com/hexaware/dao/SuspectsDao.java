/**
 * The SuspectsDao class provides methods to interact with the Suspects database table.
 * It includes a method for retrieving suspects and populating them into a list.
 * 
 * Usage:
 * ```
 * SuspectsDao suspectsDao = new SuspectsDao();
 * suspectsDao.putSuspectsToList();
 * ```
 * 
 * Note: Ensure that the necessary database connection is established before calling these methods.
 *       Also, handle SQLException appropriately.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.hexaware.controller.Constants;
import com.hexaware.entity.Suspects;
import com.hexaware.util.DbPropertyUtil;

public class SuspectsDao {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	/**
	 * Retrieves and populates Suspects data into the SuspectsList.
	 */
	public void putSuspectsToList() {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Suspects");
			while (resultSet.next()) {

				// Extract Suspect details from the database
				int suspectId = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				LocalDate dob = resultSet.getDate(4) != null ? resultSet.getDate(4).toLocalDate() : LocalDate.now();
				String gender = resultSet.getString(5);
				String contactInfo = resultSet.getString(6);

				// Create a Suspects object with the extracted details
				Suspects s = new Suspects(suspectId, firstName, lastName, dob, gender, contactInfo);

				// Add the Suspects object to the SuspectsList in Constants class
				Constants.suspectsList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

