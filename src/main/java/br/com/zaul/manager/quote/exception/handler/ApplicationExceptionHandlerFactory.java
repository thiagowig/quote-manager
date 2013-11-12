package br.com.zaul.manager.quote.exception.handler;

import javax.ejb.EJBException;

/**
 * 
 * @author thiago.fonseca
 */
public final class ApplicationExceptionHandlerFactory {
	
	/**
	 * 
	 * @param exception
	 * @return
	 */
	public static ApplicationExceptionHandler createHandler(Exception exception) {
		if (exception instanceof EJBException) {
			return new EJBExceptionHandler(exception);
			
		} else {
			return new DefaultExceptionHandler(exception);
		}
	}
	
}
