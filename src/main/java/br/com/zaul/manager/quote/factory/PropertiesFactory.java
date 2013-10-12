package br.com.zaul.manager.quote.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.inject.Produces;

import br.com.zaul.manager.quote.exception.GenericApplicationException;

public class PropertiesFactory {

	@Produces
	public Properties producePropertiesFile() {
		try (InputStream fileInputStream = getClass().getResourceAsStream("/application.properties")) {
			Properties propertiesFile = new Properties();
			propertiesFile.load(fileInputStream);
			return propertiesFile;
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new GenericApplicationException("Ocorreu um erro na aplicação.");
		}
		
	}
}
