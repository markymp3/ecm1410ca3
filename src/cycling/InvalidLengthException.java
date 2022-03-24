package cycling;

public class InvalidLengthException extends Exception {
	public InvalidLengthException() {}
	/**
	 * Constructs an instance of the exception with no message
	 */

public InvalidLengthException(String message) {
	super(message);
	/**
	 * @param message
	 * message containing details regarding the exception cause
	 */
}
