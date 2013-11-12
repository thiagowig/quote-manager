package br.com.zaul.manager.quote.exception.handler;

import br.com.zaul.manager.quote.exception.ApplicationException;

/**
 * 
 * @author thiago.fonseca
 */
public final class EJBExceptionHandler implements ApplicationExceptionHandler {
	
	/** */
	private final Exception exception;
	
	/**
	 * 
	 * @param exception
	 */
	public EJBExceptionHandler(Exception exception) {
		this.exception = exception;
	}

	/**
	 * {@inheritDoc}
	 */
	public void handle() {
		if (exception.getCause() != null && exception.getCause() instanceof ApplicationException) {
			System.out.println(exception.getCause().getMessage());
			
		} else {
			System.out.println("Falha ao executar o procedimento.");
		}

	}

}
