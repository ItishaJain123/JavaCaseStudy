/**
 * The DuplicateDataException class represents an exception that is thrown when duplicate data is encountered.
 * It extends the Exception class.
 * 
 * Usage:
 * ```
 * try {
 *     // Code that may throw DuplicateDataException
 * } catch (DuplicateDataException e) {
 *     // Handle the exception
 *     System.out.println(e.toString());
 * }
 * ```
 * 
 * Note: This exception is typically thrown when attempting to insert duplicate data into a system.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.exception;

public class DuplicateDataException extends Exception {

	/**
     * Constructs a new DuplicateDataException with a default message.
     */
	public DuplicateDataException() {
		System.out.println("Duplicate Data Exception");
	}

	/**
	 * Returns a string representation of this DuplicateDataException.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "Duplicate Data Entered!!";
	}
}
