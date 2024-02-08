
/**
 * The DbPropertyUtil class provides utility methods to establish a database connection
 * using properties loaded from a configuration file.
 * 
 * Usage:
 * ```
 * // Call getMyDbConnection() to obtain a database connection
 * Connection connection = DbPropertyUtil.getMyDbConnection();
 * ```
 * 
 * Note: Ensure that the properties file contains the necessary database connection details (url, username, password).
 *       Also, handle SQLException and IOException appropriately.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbPropertyUtil {

	static Connection connection;

	/**
	 * Retrieves a database connection using properties loaded from the
	 * configuration file.
	 * 
	 * @return A Connection object representing the database connection.
	 */
	public static Connection getMyDbConnection() {

		// Specify the path to the properties file
		String filename = "src/main/resources/db.properties";

		// Load properties from the file
		Properties props = new Properties();
		FileInputStream fis;

		try {
			fis = new FileInputStream(filename);
			props.load(fis);

			// Retrieve database connection properties from the loaded properties
			String url = props.getProperty("db.url");
			String un = props.getProperty("db.username");
			String pass = props.getProperty("db.password");

			// connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/CrimeReport",
			// "root", "Dinosaur@861");

			connection = DriverManager.getConnection(url, un, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void main(String[] args) {
		System.out.println(getMyDbConnection());
	}
}
