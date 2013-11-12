package br.com.zaul.manager.quote.exception;

public class GenericApplicationException extends RuntimeException implements ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 743691739230826731L;

	public GenericApplicationException(String message) {
		super(message);
	}

}
