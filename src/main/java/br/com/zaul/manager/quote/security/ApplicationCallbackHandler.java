package br.com.zaul.manager.quote.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class ApplicationCallbackHandler implements CallbackHandler {

	private String username = null;
	private char[] password = null;

	public void handle(Callback[] callbacks) 
			throws IOException, UnsupportedCallbackException
			{

		for ( int i = 0; i < callbacks.length; i++ )
		{
			Callback callback = callbacks[i];

			if ( callback instanceof NameCallback )
			{
				NameCallback ncb = (NameCallback) callback;
				ncb.setName( username );
			}
			else if ( callback instanceof PasswordCallback )
			{
				PasswordCallback pcb = (PasswordCallback) callback;
				pcb.setPassword( password );
			}
			else
			{
				System.out.println( 
						"Unsupported callback: " + 
								callback.getClass().getName() );
				throw new UnsupportedCallbackException( callback );
			}
		}
			}
}
