/**
 * The RecordNotFoundException class represents an exception that is thrown when
 * a record is not found in the database. It extends the Exception class.
 * 
 * Usage: ``` try { // Code that may throw RecordNotFoundException } catch
 * (RecordNotFoundException e) { // Handle the exception
 * System.out.println(e.toString()); } ```
 * 
 * Note: This exception is typically thrown when attempting to retrieve a record
 * from the database, but the record is not found.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.exception;

public class RecordNotFoundException extends Exception {

	/**
	 * Constructs a new RecordNotFoundException with a default message.
	 */
	public RecordNotFoundException() {
		System.err.println("RecordNotFoundException");
	}

	/**
	 * Returns a string representation of this RecordNotFoundException.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "Record Not Found in the Database!!!";
	}
}
