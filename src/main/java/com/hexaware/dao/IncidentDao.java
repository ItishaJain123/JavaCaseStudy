/**
 * The IncidentDao class provides methods to interact with the Incidents database table.
 * It includes methods for retrieving incidents, adding a new incident, updating incident status, and searching incidents.
 * 
 * Usage:
 * ```
 * IncidentDao incidentDao = new IncidentDao();
 * incidentDao.putIncidentsToArray();
 * incidentDao.insertIncident(id, type, date, location, description, status, victimId, suspectId);
 * incidentDao.searchIncidents(incidentType);
 * incidentDao.displayAllIncidents();
 * incidentDao.getIncidentsInDateRange(startDate, endDate);
 * incidentDao.updateIncidentStatus(id, status);
 * ```
 * 
 * Note: Ensure that the necessary database connection is established before calling these methods.
 *       Also, handle SQLException and InvalidDataException appropriately.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.controller.Constants;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.exception.InvalidStatusException;
import com.hexaware.util.DbPropertyUtil;

public class IncidentDao {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Incidents incident;

	/**
	 * Retrieves and populates Incidents data into an array.
	 */
	public void putIncidentsToArray() {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Incidents");
			while (resultSet.next()) {
				incident = new Incidents();
				incident.setIncidentId(resultSet.getInt(1));
				incident.setIncidentType(resultSet.getString(2));
				LocalDate ldate = resultSet.getDate(3).toLocalDate();
				incident.setIncidentDate(ldate);
				incident.setLocation(resultSet.getString(4));
				incident.setDescription(resultSet.getString(5));
				incident.setStatus(resultSet.getString(6));

				for (Victims v : Constants.victimList) {
					if (v.getVictimId() == resultSet.getInt(7)) {
						incident.setVictim(v);
					}
				}

				for (Suspects s : Constants.suspectsList) {
					if (s.getSuspectId() == resultSet.getInt(8)) {
						incident.setSuspect(s);
					}
				}

				Constants.incidentsList.add(incident);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inserts a new Incident into the database.
	 * 
	 * @param id          The incident Id.
	 * @param type        The incident type.
	 * @param date        The incident date.
	 * @param location    The incident location.
	 * @param description The incident description.
	 * @param status      The incident status.
	 * @param victimId    The victim Id.
	 * @param suspectId   The suspect Id.
	 * @return true if the incident is inserted successfully, false otherwise.
	 */
	public boolean insertIncident(int id, String type, LocalDate date, String location, String description,
			String status, int victimId, int suspectId) {
		boolean isInserted = false;
		try {
			// Validate input data
			if (id < 0 || victimId < 0 || suspectId < 0 || type.equals("") || date == null || location.equals("")
					|| description.equals(""))
				throw new InvalidDataException();

			// Validate incident status
			if (!status.equalsIgnoreCase("OPEN") && !status.equalsIgnoreCase("CLOSED")
					&& !status.equalsIgnoreCase("UNDER_INVESTIGATION"))
				throw new InvalidDataException();

			connection = DbPropertyUtil.getMyDbConnection();
			preparedStatement = connection.prepareStatement("insert into Incidents values(?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, type);
			preparedStatement.setDate(3, Date.valueOf(date));
			preparedStatement.setString(4, location);
			preparedStatement.setString(5, description);
			preparedStatement.setString(6, status);
			preparedStatement.setInt(7, victimId);
			preparedStatement.setInt(8, suspectId);
			int noOfRows = preparedStatement.executeUpdate();
			isInserted = noOfRows != 0;
			System.out.println(noOfRows + " inserted successfully !!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			System.err.println(e);
		}
		return isInserted;
	}

	/**
	 * Searches incidents based on incident type.
	 * 
	 * @param incidentType The incident type to search.
	 * @return A list of Incidents matching the given incident type.
	 */
	public List<Incidents> searchIncidents(String incidentType) {
		List<Incidents> res = new ArrayList<Incidents>();
		Incidents i;
		try {

			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			String query = "select * from Incidents where lower(status) like lower('" + incidentType + "')";

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				i = new Incidents();
				i.setIncidentId(resultSet.getInt(1));
				i.setIncidentType(resultSet.getString(2));
				i.setIncidentDate(resultSet.getDate(3).toLocalDate());
				i.setLocation(resultSet.getString(4));
				i.setDescription(resultSet.getString(5));
				i.setStatus(resultSet.getString(6));

				// Find the related victim from the victim list
				for (Victims v : Constants.victimList) {
					if (v.getVictimId() == resultSet.getInt(7)) {
						i.setVictim(v);
					}
				}

				// Find the related suspect from the suspect list
				for (Suspects s : Constants.suspectsList) {
					if (s.getSuspectId() == resultSet.getInt(8)) {
						i.setSuspect(s);
					}
				}

				res.add(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Displays details of all incidents in the database.
	 */
	public void displayAllIncidents() {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			String query = "select * from Incidents";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("Incident Id: " + resultSet.getInt(1));
				System.out.println("Incident Type: " + resultSet.getString(2));
				System.out.println("Incident Date: " + resultSet.getDate(3));
				System.out.println("Incident Location: " + resultSet.getString(4));
				System.out.println("Incident Description: " + resultSet.getString(5));
				System.out.println("Incident status: " + resultSet.getString(6));
				System.out.println("Victim Id: " + resultSet.getInt(7));
				System.out.println("Suspect Id: " + resultSet.getInt(8));
				System.out.println("\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves incidents within a specified date range.
	 * 
	 * @param startDate The start date of the range.
	 * @param endDate   The end date of the range.
	 * @return A list of Incidents within the specified date range.
	 */
	public List<Incidents> getIncidentsInDateRange(LocalDate startDate, LocalDate endDate) {
		List<Incidents> res = new ArrayList<Incidents>();
		Incidents i;
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			statement = connection.createStatement();
			String query = "select * from Incidents where incidentdate between '" + startDate + "' and '" + endDate
					+ "'";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				i = new Incidents();
				i.setIncidentId(resultSet.getInt(1));
				i.setIncidentType(resultSet.getString(2));
				i.setIncidentDate(resultSet.getDate(3).toLocalDate());
				i.setLocation(resultSet.getString(4));
				i.setDescription(resultSet.getString(5));
				i.setStatus(resultSet.getString(6));

				// Find the related victim from the victim list
				for (Victims v : Constants.victimList) {
					if (v.getVictimId() == resultSet.getInt(7)) {
						i.setVictim(v);
					}
				}

				// Find the related suspect from the suspect list
				for (Suspects s : Constants.suspectsList) {
					if (s.getSuspectId() == resultSet.getInt(8)) {
						i.setSuspect(s);
					}
				}

				res.add(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}


	/**
	 * Updates incident status in the database.
	 * 
	 * @param id     The incident Id.
	 * @param status The new status to be updated.
	 * @return true if the status is updated successfully, false otherwise.
	 */
	public boolean updateIncidentStatus(int id, String status) {
		boolean isUpdated = false;
		try {
			connection = DbPropertyUtil.getMyDbConnection();
			preparedStatement = connection
					.prepareStatement("update Incidents set status='" + status + "' where incidentId=" + id);
			int noOfRows = preparedStatement.executeUpdate();
			isUpdated = noOfRows != 0;
			System.out.println(noOfRows + " Status Updated successfully !!!");
			if (!isUpdated)
				throw new InvalidStatusException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			System.err.println(e);
		}

		return isUpdated;
	}
}
