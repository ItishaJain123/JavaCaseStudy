/**
 * The CaseView class provides a menu-driven interface for interacting with the Case Management module.
 * Users can perform various operations such as creating cases, retrieving case details, updating case details, and getting all case details.
 * 
 * Usage:
 * ```
 * // Instantiate the CaseView and call displayMenu() to start interacting with the Case Management module
 * CaseView caseView = new CaseView();
 * caseView.displayMenu();
 * ```
 * 
 * Note: Ensure that the referenced controller is implemented and handles user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.CaseController;
import com.hexaware.controller.Constants;

public class CaseView {
	Scanner scan = new Scanner(System.in);
	CaseController caseController = new CaseController();

	/**
	 * Displays the menu options for interacting with the Case Management module.
	 * Users can choose from different options to perform operations on cases.
	 */
	public void displayMenu() {
		String ch = null;

		do {
			System.out.println("1. Create a new case");
			System.out.println("2. Get details of a specific case");
			System.out.println("3. Update case details");
			System.out.println("4. Get Case Details");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				caseController.createCase();
				break;

			case 2:
				System.out.println("Enter case Id: ");
				caseController.getCaseDetails(scan.nextInt());
				break;

			case 3:
				System.out.println("Enter case Id: ");
				caseController.updateCaseDetails(scan.nextInt());
				break;

			case 4:
				caseController.getAllCases();
				break;

			default:
				System.out.println("Enter a valid option!!");
				break;

			}
			Constants.loadValueInList();
			System.out.println("Do you want to continue? Y | y");

			ch = scan.next();

		} while (ch.equals("Y") || ch.equals("y"));
	}
}
