package br.com.zaul.manager.quote.business.mail.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import br.com.zaul.manager.quote.business.mail.contract.EmailSender;

/**
 * 
 * @author thiago.fonseca
 *
 */
public class MailGunMessageSender implements EmailSender {
	
	/** */
	@Inject
	private MultivaluedMapImpl formData;
	@Inject
	private WebResource webResource;
	
	/**
	 * 
	 */
	public EmailSender from(String from) {
		formData.add("from", from);
		
		return this;
	}

	/**
	 * 
	 */
	public EmailSender to(String to) {
		formData.add("to", to);
		
		return this;
	}

	/**
	 * 
	 */
	public EmailSender withTheSubject(String subject) {
		formData.add("subject", subject);
		
		return this;
	}

	/**
	 * 
	 */
	public EmailSender withTheText(String text) {
		formData.add("text", text);
		
		return this;
	}

	/**
	 * 
	 */
	public boolean send() {
		postMail();
		
		return true;
	}
	
	/**
	 * 
	 */
	public void sendAsync() {
		Callable<ClientResponse> asyncCall = new Callable<ClientResponse>() {
			public ClientResponse call() throws Exception {
				return postMail();
			}
		};
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(asyncCall);
	}
	
	/**
	 * 
	 */
	private ClientResponse postMail() {
		return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
	}

}
