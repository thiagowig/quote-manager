package br.com.zaul.manager.quote.exception;

public class ValidationException extends RuntimeException implements ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 743691739230826731L;

	public ValidationException(String message) {
		super(message);
	}

}
