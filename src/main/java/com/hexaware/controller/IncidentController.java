/**
 * The IncidentController class provides methods to interact with incidents,
 * such as creating a new incident, updating incident status, searching for
 * incidents, and generating incident reports.
 * 
 * Usage:
 * ```
 * IncidentController incidentController = new IncidentController();
 * incidentController.createIncident();
 * ```
 * 
 * Note: Ensure that the necessary database connection is established before calling these methods.
 *       Also, handle IOException and other exceptions appropriately.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import com.hexaware.dao.IncidentDao;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;

public class IncidentController {
	private Incidents incident;
	private Victims victim;
	private IncidentDao incidentDao = new IncidentDao();
	private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private BufferedReader bufferReader = new BufferedReader(inputStreamReader);

	/**
	 * Initializes incidents array from IncidentDao.
	 */
	public void putIncidentsToArray() {
		incidentDao.putIncidentsToArray();
	}

	/**
	 * Creates a new incident.
	 */
	public void createIncident() {
		StringBuffer str = new StringBuffer("");
		try {
			incident = new Incidents();
			// Input validation and setting Incident Id
			System.out.print("Enter Incident Id: ");
			str = str.append(bufferReader.readLine());
			if (str.toString().equals("") || Integer.parseInt(str.toString()) < 0)
				throw new InvalidDataException();
			incident.setIncidentId(Integer.parseInt(str.toString()));

			// Input validation and setting Incident Type
			System.out.print("Enter Incident Type: ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals(""))
				throw new InvalidDataException();
			incident.setIncidentType(str.toString());

			// Input validation and setting Incident Date
			System.out.print("Enter Date of Incident: ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals(""))
				throw new InvalidDataException();
			incident.setIncidentDate(LocalDate.parse(str.toString()));

			// Input validation and setting Incident Location
			System.out.print("Enter Incident location: ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals(""))
				throw new InvalidDataException();
			incident.setLocation(str.toString());

			// Input validation and setting Incident Description
			System.out.print("Enter Incident Description: ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals(""))
				throw new InvalidDataException();
			incident.setDescription(str.toString());

			// Input validation and setting Incident Status
			System.out.println("Enter Incident status (OPEN/ CLOSED/ UNDER_INVESTIGATION): ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals(""))
				throw new InvalidDataException();
			String status = str.toString().toUpperCase().toString();
			incident.setStatus(status);

			// Input validation and setting Victim Id
			System.out.println("Enter Victim Id: ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals("") || Integer.parseInt(str.toString()) < 0)
				throw new InvalidDataException();

			// Searching and setting Victim for the incident
			for (Victims v : Constants.victimList) {
				if (v.getVictimId() == Integer.parseInt(str.toString())) {
					incident.setVictim(v);
					System.out.println(v);
					break;
				}
			}

			// Input validation and setting Suspect Id
			System.out.println("Enter Suspect Id: ");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals("") || Integer.parseInt(str.toString()) < 0)
				throw new InvalidDataException();

			// Searching and setting Suspect for the incident
			for (Suspects s : Constants.suspectsList) {
				if (s.getSuspectId() == Integer.parseInt(str.toString())) {
					incident.setSuspect(s);
					System.out.println(s);
					break;
				}
			}

			// Checking for duplicate incident Id
			for (Incidents inc : Constants.incidentsList) {
				if (inc.getIncidentId() == incident.getIncidentId()) {
					throw new DuplicateDataException();
				}
			}

			// Adding incident to the incidentsList and inserting into the database
			Constants.incidentsList.add(incident);
			if (incidentDao.insertIncident(incident.getIncidentId(), incident.getIncidentType(),
					incident.getIncidentDate(), incident.getLocation(), incident.getDescription(), incident.getStatus(),
					incident.getVictim().getVictimId(), incident.getSuspect().getSuspectId())) {
				System.out.println("Data inserted Successfully!!");
			} else {
				System.out.println("Data could not be inserted!!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			System.err.println(e);
		} catch (DuplicateDataException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid Status Type!!");
		}

	}

	/**
	 * Updates incident status by incident Id.
	 * 
	 * @param id The incident Id.
	 */
	public void updateIncidentStatus(int id) {
		try {
			StringBuffer str = new StringBuffer("");
			System.out.println("Enter Updated Status:");
			str = str.append(bufferReader.readLine());
			incidentDao.updateIncidentStatus(id, str.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves incidents within a date range and prints them.
	 * 
	 * @param s The start date of the range.
	 * @param e The end date of the range.
	 */
	public void getIncidentsInDateRange(LocalDate s, LocalDate e) {
		List<Incidents> res = incidentDao.getIncidentsInDateRange(s, e);
		for (Incidents i : res) {
			System.out.println(i);
		}
	}

	/**
	 * Searches incidents by incident type and prints them.
	 * 
	 * @param incidentType The incident type to search for.
	 */
	public void searchIncidents(String incidentType) {
		List<Incidents> list = incidentDao.searchIncidents(incidentType);

		for (Incidents i : list) {
			System.out.println(i);
		}
	}

	/**
	 * Generates a report of all incidents and prints them.
	 */
	public void generateIncidentReport() {
		incidentDao.displayAllIncidents();
	}

}
