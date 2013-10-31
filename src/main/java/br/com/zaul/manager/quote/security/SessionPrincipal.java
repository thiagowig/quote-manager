package br.com.zaul.manager.quote.security;

import java.security.Principal;

public class SessionPrincipal implements Principal {

	private String name;
	private boolean destroyed = false;

	public SessionPrincipal	( String name )
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

}
