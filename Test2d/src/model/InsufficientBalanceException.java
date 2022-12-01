package model;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String s) {
		super(s);
	}
}
