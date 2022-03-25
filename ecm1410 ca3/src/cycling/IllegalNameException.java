package cycling;

public class IllegalNameException extends Exception {
	public IllegalNameException() {}
	/**
	 * Constructs an instance of the exception with no message
	 */

public IllegalNameException(String message) {
	super(message);
	/**
	 * @param message
	 * message containing details regarding the exception cause
	 */
}
