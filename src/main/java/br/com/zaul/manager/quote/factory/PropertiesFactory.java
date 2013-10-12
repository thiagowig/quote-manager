package br.com.zaul.manager.quote.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.inject.Produces;

import br.com.zaul.manager.quote.exception.GenericApplicationException;

public class PropertiesFactory {

	@Produces
	public Properties producePropertiesFile() {
		//TODO: Change the version of Java to support try-with-resources and multi catch statement
		InputStream inputStream = null;
		
		try  {
			inputStream = getClass().getResourceAsStream("/application.properties");
			Properties propertiesFile = new Properties();
			propertiesFile.load(inputStream);
			return propertiesFile;
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new GenericApplicationException("Ocorreu um erro na aplicação.");
			
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
		
	}
}
