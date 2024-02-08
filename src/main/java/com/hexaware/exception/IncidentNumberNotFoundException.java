/**
 * The IncidentNumberNotFoundException class represents an exception that is thrown when an incident number is not found in the database.
 * It extends the Exception class.
 * 
 * Usage:
 * ```
 * try {
 *     // Code that may throw IncidentNumberNotFoundException
 * } catch (IncidentNumberNotFoundException e) {
 *     // Handle the exception
 *     System.out.println(e.toString());
 * }
 * ```
 * 
 * Note: This exception is typically thrown when attempting to retrieve an incident by its number, but the number is not found in the database.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.exception;

public class IncidentNumberNotFoundException extends Exception {
	/**
	 * Constructs a new IncidentNumberNotFoundException with a default message.
	 */
	public IncidentNumberNotFoundException() {
		System.err.println("IncidentNumberNotFoundException");
	}

	/**
	 * Returns a string representation of this IncidentNumberNotFoundException.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "Incident Number Not Found in the Database!!!";
	}

}
