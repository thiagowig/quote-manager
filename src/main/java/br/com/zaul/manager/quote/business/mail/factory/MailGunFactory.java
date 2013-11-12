package br.com.zaul.manager.quote.business.mail.factory;

import javax.enterprise.inject.Produces;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 
 * @author thiago.fonseca
 *
 */
public class MailGunFactory {

	/**
	 * 
	 * @return
	 */
	@Produces
	public WebResource produceWebResource() {
		// TODO: Recuperar códigos do properties
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", "key-3u2mv7wfzl7aa6x1r5n3qjryo8wlzeh7"));
		
		return client.resource("https://api.mailgun.net/v2/samples.mailgun.org/messages");
	}
	
	@Produces
	public MultivaluedMapImpl produceMultivaluedMapImpl() {
		return new MultivaluedMapImpl();
	}
}
