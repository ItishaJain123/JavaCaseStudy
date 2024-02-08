/**
 * The Constants class provides static lists to store victims, suspects, cases, and incidents.
 * It also contains a method to load values into these lists from the database using DAO classes.
 * 
 * Usage:
 * ```
 * Constants.loadValueInList();
 * ```
 * 
 * Note: Ensure that the necessary database connection is established before calling this method.
 *       Also, handle any potential exceptions appropriately.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.CasesDao;
import com.hexaware.dao.IncidentDao;
import com.hexaware.dao.SuspectsDao;
import com.hexaware.dao.VictimsDao;
import com.hexaware.entity.Cases;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;

public class Constants {

	// Lists to store victims, suspects, cases, and incidents
	public static List<Victims> victimList = new ArrayList();
	public static List<Suspects> suspectsList = new ArrayList();
	public static List<Cases> casesList = new ArrayList();
	public static List<Incidents> incidentsList = new ArrayList();

	/**
	 * Loads values into the lists from the database.
	 */
	public static void loadValueInList() {

		// Method to load values into the lists
		VictimsDao victimsDao = new VictimsDao();
		victimsDao.putVictimsToList();

		SuspectsDao suspectsDao = new SuspectsDao();
		suspectsDao.putSuspectsToList();

		CasesDao casesDao = new CasesDao();
		casesDao.putCaseToArray();

		IncidentDao incidentsDao = new IncidentDao();
		incidentsDao.putIncidentsToArray();
	}
}
