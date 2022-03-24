package cycling;

public class InvalidNameException extends Exception {
	public InvalidNameException() {}
	/**
	 * Constructs an instance of the exception with no message
	 */

public InvalidNameException(String message) {
	super(message);
	/**
	 * @param message
	 * message containing details regarding the exception cause
	 */
}
