/**
 * The InvalidDataException class represents an exception that is thrown when invalid data is encountered.
 * It extends the Exception class.
 * 
 * Usage:
 * ```
 * try {
 *     // Code that may throw InvalidDataException
 * } catch (InvalidDataException e) {
 *     // Handle the exception
 *     System.out.println(e.toString());
 * }
 * ```
 * 
 * Note: This exception is typically thrown when attempting to process invalid data.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.exception;

public class InvalidDataException extends Exception {
	/**
	 * Constructs a new InvalidDataException with a default message.
	 */
	public InvalidDataException() {
		System.err.println("InvalidDataException");
	}

	/**
	 * Returns a string representation of this InvalidDataException.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "Invalid Data!!!";
	}
}
