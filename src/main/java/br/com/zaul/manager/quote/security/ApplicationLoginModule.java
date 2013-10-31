package br.com.zaul.manager.quote.security;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class ApplicationLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler handler;

	private String username = null;

	// Saves the state of phase 1, login().
	private boolean loginOk = false;  

	private SessionPrincipal usernameprincipal;
	private Object password;
	private Map sharedState;
	private Map options;

	public void initialize( Subject subject, 
			CallbackHandler callbackHandler, 
			Map sharedState, 
			Map options)
	{
		this.subject = subject;
		this.handler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	public boolean login() throws LoginException
	{
		NameCallback namecallback = 
				new NameCallback( "Enter username" );
		PasswordCallback passwordcallback = 
				new PasswordCallback( "Enter password", false );

		try
		{
			handler.handle( new Callback[]{ namecallback, 
					passwordcallback } );

			username = namecallback.getName();
			password = new String( passwordcallback.getPassword() );

			System.out.println( "TODO\t" + 
					this.getClass().getName() + 
					": Call Authentication Code." );

			loginOk = true;
			return true;
		}
		catch ( UnsupportedCallbackException e )
		{
		}
		catch ( java.io.IOException e )
		{
		}
		finally
		{
		}

		return false;
	}

	public boolean commit() throws LoginException
	{
		if ( ! loginOk )
			return false;

		usernameprincipal = new SessionPrincipal( username );
		password = new String( "idontusethis" );

		subject.getPrincipals().add( usernameprincipal );
		subject.getPublicCredentials().add( password );

		this.username = null;
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
