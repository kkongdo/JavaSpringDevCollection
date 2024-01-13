package web0817mvc.exception;

public class DuplicatedIdException extends Exception {
	public DuplicatedIdException() {
		
	}
	
	public DuplicatedIdException(String message) {
		super(message);
	}
}
