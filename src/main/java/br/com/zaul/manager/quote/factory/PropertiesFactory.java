package br.com.zaul.manager.quote.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.zaul.manager.quote.exception.GenericApplicationException;

public class PropertiesFactory {

	@Inject
	private static Logger LOGGER;
	
	@Produces
	public Properties producePropertiesFile() {
		
		try (InputStream inputStream =  getClass().getResourceAsStream("/application.properties")) {
			Properties propertiesFile = new Properties();
			propertiesFile.load(inputStream);
			return propertiesFile;
			
		} catch (IOException e) {
			LOGGER.error("Erro ao recuperar arquivo de propriedades", e);
			throw new GenericApplicationException("Ocorreu um erro na aplicação.");
		}
	}
}
