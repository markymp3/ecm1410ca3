package cycling;

public class InvalidStageStateException extends Exception {

	public InvalidStageStateException() {
		
	}
	
	public InvalidStageStateException(String message) {
		super(message);
	}
}
