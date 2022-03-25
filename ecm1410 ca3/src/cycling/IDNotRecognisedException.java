package cycling;

/**
 * this exception class will be thrown when an ID is used that is not in the system.
 * @author marcusconnolly
 *
 */

public class IDNotRecognisedException extends Exception {
	public IDNotRecognisedException() {}
		/**
		 * Constructs an instance of the exception with no message
		 */
	
	public IDNotRecognisedException(String message) {
		super(message);
		/**
		 * @param message
		 * message containing details regarding the exception cause
		 */
	}
}

