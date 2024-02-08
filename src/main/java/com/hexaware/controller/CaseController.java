/**
 * The CaseController class handles operations related to cases.
 * 
 * Usage:
 * 1. Create an instance of CaseController.
 * 2. Use methods to perform operations like creating a case, retrieving case details, updating case details, or getting all cases.
 * 3. Ensure that Constants class has the necessary lists initialized with data before using methods that depend on Constants.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.hexaware.dao.CasesDao;
import com.hexaware.entity.Cases;
import com.hexaware.entity.Incidents;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.IncidentNumberNotFoundException;
import com.hexaware.exception.InvalidDataException;

public class CaseController {
	private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private BufferedReader bufferReader = new BufferedReader(inputStreamReader);
	private CasesDao caseDao = new CasesDao();
	private Cases cases;

	/**
	 * Initializes the cases array from CasesDao.
	 */
	public void putCasesToArray() {
		caseDao.putCaseToArray();
	}

	/**
	 * Creates a new case.
	 * 
	 * @throws InvalidDataException            if invalid data is entered.
	 * @throws IncidentNumberNotFoundException if the related incident ID is not
	 *                                         found.
	 * @throws DuplicateDataException          if duplicate case ID is detected.
	 */
	public void createCase() {
		StringBuffer str = new StringBuffer("");
		cases = new Cases();
		try {
			System.out.println("Enter Case Id:");
			str = str.append(bufferReader.readLine());
			if (str.toString().equals("") || str.toString().contains("-"))
				throw new InvalidDataException();
			cases.setCaseId(Integer.parseInt(str.toString()));

			System.out.println("Enter Case Description:");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals(""))
				throw new InvalidDataException();
			cases.setCaseDescription(str.toString());

			System.out.println("Enter Related Incident Id:");
			str.setLength(0);
			str = str.append(bufferReader.readLine());
			if (str.toString().equals("") || str.toString().contains("-"))
				throw new InvalidDataException();

			boolean isIncidentAvailable = false;
			for (Incidents i : Constants.incidentsList) {
				if (i.getIncidentId() == Integer.parseInt(str.toString())) {
					isIncidentAvailable = true;
					cases.setRelatedIncidents(i);
					break;
				}
			}
			if (!isIncidentAvailable)
				throw new IncidentNumberNotFoundException();

			for (Cases c : Constants.casesList) {
				if (c.getCaseId() == cases.getCaseId()) {
					throw new DuplicateDataException();
				}
			}

			caseDao.addCase(cases);
			System.out.println("Case Added Succesfully!!");

		} catch (InvalidDataException e) {
			System.err.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IncidentNumberNotFoundException e) {
			System.err.println(e);
		} catch (DuplicateDataException e) {
			System.err.println(e);
		}
	}

	/**
	 * Retrieves details of a specific case by its ID.
	 * 
	 * @param id The ID of the case to retrieve details for.
	 */
	public void getCaseDetails(int id) {
		caseDao.getCaseDetails(id);
	}


	/**
	 * Updates details of a specific case by its ID.
	 * 
	 * @param id The ID of the case to update details for.
	 * 
	 * @throws InvalidDataException            if invalid data is entered.
	 * @throws IncidentNumberNotFoundException if the related incident ID is not
	 *                                         found.
	 */
	public void updateCaseDetails(int id) {
		StringBuffer str = new StringBuffer("");
		cases = new Cases();
		char ch;
		Scanner sc = new Scanner(System.in);
		try {
			for (Cases cases : Constants.casesList) {
				if (cases.getCaseId() == id) {
					System.out.println("Update Incident? (y/n)");
					ch = sc.next().charAt(0);
					if (ch == 'y') {
						System.out.println("Enter Related Incident Id:");
						str = str.append(bufferReader.readLine());
						if (str.toString().equals("") || str.toString().contains("-"))
							throw new InvalidDataException();

						boolean isIncidentAvailable = false;
						for (Incidents i : Constants.incidentsList) {
							if (i.getIncidentId() == Integer.parseInt(str.toString())) {
								isIncidentAvailable = true;
								cases.setRelatedIncidents(i);
								break;
							}
						}
						if (!isIncidentAvailable)
							throw new IncidentNumberNotFoundException();

					}

					System.out.println("Update Case Description? (y/n)");
					ch = sc.next().charAt(0);
					if (ch == 'y') {
						System.out.println("Enter Case Description:");
						str.setLength(0);
						str = str.append(bufferReader.readLine());
						if (str.toString().equals(""))
							throw new InvalidDataException();
						cases.setCaseDescription(str.toString());
					}
					caseDao.updateCaseDetails(cases);
					break;
				}
			}
		} catch (IncidentNumberNotFoundException e) {
			System.out.println(e);
		} catch (InvalidDataException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves all cases.
	 */
	public void getAllCases() {
		caseDao.getAllCases();

	}

}

