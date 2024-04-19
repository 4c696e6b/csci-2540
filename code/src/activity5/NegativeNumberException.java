package activity5;

public class NegativeNumberException extends Exception {

	public NegativeNumberException() {
		super("error: number is negative");
	}

	public NegativeNumberException(String msg) {
		super(msg);
	}
}
