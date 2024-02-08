/**
 * The IncidentView class provides a menu-driven interface for interacting with the Incident Management module.
 * Users can perform various operations such as creating incidents, updating incident status, retrieving incidents within a date range,
 * searching for incidents based on criteria, and generating incident reports.
 * 
 * Usage:
 * ```
 * // Instantiate the IncidentView and call displayMenu() to start interacting with the Incident Management module
 * IncidentView incidentView = new IncidentView();
 * incidentView.displayMenu();
 * ```
 * 
 * Note: Ensure that the referenced controllers and DAOs are implemented and handle user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.view;

import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.controller.Constants;
import com.hexaware.controller.IncidentController;
import com.hexaware.dao.IncidentDao;

public class IncidentView {
	Scanner scan = new Scanner(System.in);
	IncidentDao incidentDao = new IncidentDao();
	IncidentController incidentController = new IncidentController();

	/**
	 * Displays the menu options for interacting with the Incident Management
	 * module. Users can choose from different options to perform operations on
	 * incidents.
	 */
	public void displayMenu() {
		String ch = null;

		do {
			System.out.println("Enter your choice");
			System.out.println("1. Create a new incident");
			System.out.println("2. Update the status of an incident");
			System.out.println("3. Get a list of incidents within a date range");
			System.out.println("4. Search for incidents based on IncidentType");
			System.out.println("5. Generate incident reports");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				incidentController.createIncident();
				break;
			case 2:
				System.out.println("Enter incident id: ");
				int id = scan.nextInt();
				incidentController.updateIncidentStatus(id);
				break;
			case 3:
				System.out.println("Enter Start Date (yyyy-mm-dd): ");
				String startDate = scan.next();
				System.out.println("Enter End Date(yyyy-mm-dd): ");
				String endDate = scan.next();
				incidentController.getIncidentsInDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
				break;
			case 4:
				System.out.println("Enter IncidentType criteria (OPEN/ CLOSED/ UNDER_INVESTIGATION): ");
				System.out.println("Enter Incident number: ");
				incidentController.searchIncidents(scan.next());
				break;
			case 5:
				incidentController.generateIncidentReport();
				break;
			default:
				System.out.println("Choose a proper choice");
				break;
			}
			Constants.loadValueInList();

			System.out.println("Do you want to continue? Y | y");
			ch = scan.next();

		} while (ch.equals("Y") || ch.equals("y"));
	}
}
