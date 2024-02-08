/**
 * The InvalidStatusException class represents an exception that is thrown when an invalid status or ID is encountered.
 * It extends the Exception class.
 * 
 * Usage:
 * ```
 * try {
 *     // Code that may throw InvalidStatusException
 * } catch (InvalidStatusException e) {
 *     // Handle the exception
 *     System.out.println(e.toString());
 * }
 * ```
 * 
 * Note: This exception is typically thrown when attempting to process an invalid status or ID.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-07
 */

package com.hexaware.exception;

public class InvalidStatusException extends Exception {
	/**
	 * Constructs a new InvalidStatusException with a default message.
	 */
	public InvalidStatusException() {
		System.err.println("InvalidStatusException");
	}

	/**
	 * Returns a string representation of this InvalidStatusException.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "Invalid Status or Id Entered";
	}

}
