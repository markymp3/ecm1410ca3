package cycling;

public class NameNotRecognisedException extends Exception {

	public NameNotRecognisedException() {
		
	}
	public NameNotRecognisedException(String message) {
		super(message);
	}
}
