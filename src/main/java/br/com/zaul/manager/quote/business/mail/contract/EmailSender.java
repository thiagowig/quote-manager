package br.com.zaul.manager.quote.business.mail.contract;

/**
 * 
 * @author thiago.fonseca
 *
 */
public interface EmailSender {
	
	/**
	 * 
	 * @param from
	 * @return
	 */
	EmailSender from(String from);
	
	/**
	 * 
	 * @param to
	 * @return
	 */
	EmailSender to(String to);
	
	/**
	 * 
	 * @param subject
	 * @return
	 */
	EmailSender withTheSubject(String subject);
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	EmailSender withTheText(String text);	

	/**
	 * 
	 * @return
	 */
	boolean send();
	
	/**
	 * 
	 * @return
	 */
	void sendAsync();
	
}
