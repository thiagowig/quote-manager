package br.com.zaul.manager.quote.exception;

public class DatabaseException extends RuntimeException implements ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908467608419938730L;
	
	public DatabaseException() {
	}

	public DatabaseException(String message) {
		super(message);
	}
}
