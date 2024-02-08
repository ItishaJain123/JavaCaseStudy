/**
* The MainClass serves as the main entry point for the Crime Analysis and Reporting System (C.A.R.S.).
 * It provides a menu-driven program allowing users to navigate through different modules,
 * including Incident Management and Case Management.
 * Users can select a module by entering the corresponding number and interact with the system's functionalities.
 * The program runs in a loop, allowing users to continue using the system until they choose to exit.
 * 
 * Usage:
 * ```
 * // Run the main method to start the Crime Analysis and Reporting System
 * public static void main(String[] args) {
 *     MainClass mainClass = new MainClass();
 *     mainClass.startSystem();
 * }
 * ```
 * 
 * Note: Ensure that the referenced views and controllers are implemented and handle user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.Constants;

public class MainClass {
	static Scanner scan = new Scanner(System.in);

	/**
	 * The main method serves as the entry point for the Crime Analysis and
	 * Reporting System. It initializes the system and provides a menu-driven
	 * program to interact with different modules.
	 * 
	 * @param args The command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		System.out.println("===============================================================");
		System.out.println("===============================================================");
		System.out.println("======== Crime Analysis and Reporting System (C.A.R.S.) =======");
		System.out.println("========================== Case Study =========================");
		System.out.println("===============================================================");
		System.out.println("===============================================================");

		// Load values into Constants before entering the loop
		Constants.loadValueInList();

		// Menu-driven program using a do-while loop
		String input = null;
		do {
			System.out.println("Select a Module ");
			System.out.println("1. Incident Management");
			System.out.println("2. Case Management");

			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				IncidentView incidentView = new IncidentView();
				incidentView.displayMenu();
				break;
			}
			case 2: {
				CaseView caseView = new CaseView();
				caseView.displayMenu();
				break;
			}
//			
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
			}
			System.out.println("To Continue - Press 'C' | 'c'");
			input = scan.next();

			// Reload values into Constants for the next iteration
			Constants.loadValueInList();

		} while (input.equals("c") || input.equals("C"));

		System.out.println("===============================================================");
		System.out.println("===============================================================");
		System.out.println("================== THANKS FOR USING OUR SYSTEM=================");
		System.out.println("===============================================================");
		System.out.println("===============================================================");
	}

}
