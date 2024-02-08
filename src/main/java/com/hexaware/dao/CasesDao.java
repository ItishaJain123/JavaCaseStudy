/**
 * The CasesDao class provides methods to interact with the Cases database table.
 * It includes methods for fetching cases, adding a new case, updating case details, and retrieving case details.
 * 
 * Usage:
 * ```
 * CasesDao casesDao = new CasesDao();
 * casesDao.putCaseToArray();
 * casesDao.addCase(cases);
 * casesDao.updateCaseDetails(cases);
 * casesDao.getAllCases();
 * casesDao.getCaseDetails(caseId);
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
import java.util.ArrayList;
import java.util.List;

import com.hexaware.controller.Constants;
import com.hexaware.entity.Cases;
import com.hexaware.entity.Incidents;
import com.hexaware.util.DbPropertyUtil;

public class CasesDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Cases casess;

	/**
	 * Fetches cases from the database and stores them in Constants.casesList.
	 */
	public void putCaseToArray() {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Cases");
			while (resultSet.next()) {
				casess = new Cases();
				casess.setCaseId(resultSet.getInt(1));

				// Find the related incident from the incident list
				for (Incidents i : Constants.incidentsList) {
					if (i.getIncidentId() == resultSet.getInt(3)) {
						casess.setRelatedIncidents(i);
						break;
					}
				}

				casess.setCaseDescription(resultSet.getString(3));
				Constants.casesList.add(casess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new case to the database.
	 * 
	 * @param cases The Cases object representing the case to be added.
	 * @return true if the case is added successfully, false otherwise.
	 */
	public boolean addCase(Cases cases) {
		boolean isCreated = false;
		try {

			connection = DbPropertyUtil.getMyDbConnection();
			preparedStatement = connection.prepareStatement("insert into Cases values(?,?,?)");
			preparedStatement.setInt(1, cases.getCaseId());
			preparedStatement.setString(2, cases.getCaseDescription());
			preparedStatement.setInt(3, cases.getRelatedIncidents().getIncidentId());

			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows != 0)
				isCreated = true;
			System.out.println(noOfRows + " Case Added!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	/**
	 * Updates case details in the database.
	 * 
	 * @param cases The Cases object representing the updated case details.
	 * @return true if the case details are updated successfully, false otherwise.
	 */
	public boolean updateCaseDetails(Cases cases) {
		boolean isUpdated = false;
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			String sql = "update Cases set incidentId=" + cases.getRelatedIncidents().getIncidentId()
					+ ", caseDescription='" + cases.getCaseDescription() + "' where caseId=" + cases.getCaseId();

			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);

			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows != 0)
				isUpdated = true;
			System.out.println(noOfRows + " Case Updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	/**
	 * Fetches and displays all cases from the database.
	 */
	public void getAllCases() {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Cases");

			while (resultSet.next()) {
				System.out.println("Case Id: " + resultSet.getInt(1));
				System.out.println("Case Description: " + resultSet.getString(2));
				System.out.println("Incident Id: " + resultSet.getInt(3));

				System.out.println("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fetches and displays case details based on caseId.
	 * 
	 * @param caseId The case Id for which details are to be fetched.
	 */
	public void getCaseDetails(int caseId) {
		List<Cases> res = new ArrayList();

		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			String query = "select * from Cases where caseid = " + caseId;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				casess = new Cases();
				casess.setCaseId(resultSet.getInt(1));
				casess.setCaseDescription(resultSet.getString(2));

				// Find the related incident from the incident list
				for (Incidents i : Constants.incidentsList) {
					if (i.getIncidentId() == resultSet.getInt(3)) {
						casess.setRelatedIncidents(i);
					}
				}

				res.add(casess);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Cases c : res) {
			System.out.println(c);
		}

		if (res.size() == 0) {
			System.out.println("No data present in database.");
		}
	}

}
