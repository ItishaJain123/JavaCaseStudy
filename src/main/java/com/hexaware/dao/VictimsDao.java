/**
 * The VictimsDao class provides methods to interact with the Victims database table.
 * It includes a method for retrieving victims and populating them into a list.
 * 
 * Usage:
 * ```
 * VictimsDao victimsDao = new VictimsDao();
 * victimsDao.putVictimsToList();
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
import com.hexaware.entity.Victims;
import com.hexaware.util.DbPropertyUtil;

public class VictimsDao {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	/**
	 * Retrieves and populates Victims data into the VictimList.
	 */
	public void putVictimsToList() {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Victims");
			while (resultSet.next()) {

				int victimId = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				LocalDate dob = resultSet.getDate(4) != null ? resultSet.getDate(4).toLocalDate() : LocalDate.now();
				String gender = resultSet.getString(5);
				String address = resultSet.getString(6);
				String phone = resultSet.getString(7);

				// Create a Victims object with the extracted details
				Victims v = new Victims(victimId, firstName, lastName, dob, gender, address, phone);

				// Add the Victims object to the VictimList in Constants class
				Constants.victimList.add(v);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
