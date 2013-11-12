package br.com.zaul.manager.quote.exception.handler;

/**
 * 
 * @author thiago.fonseca
 *
 */
public final class DefaultExceptionHandler implements ApplicationExceptionHandler {
	
	private final Exception exception;

	public DefaultExceptionHandler(Exception exception) {
		this.exception = exception;
	}

	/**
	 * {@inheritDoc}
	 */
	public void handle() {
		System.out.println("Falha ao executar o procedimento.");
	}

}
