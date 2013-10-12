package br.com.zaul.manager.quote.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zaul.manager.quote.exception.GenericApplicationException;

public class PropertiesFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesFactory.class);
	
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
			LOGGER.error("Erro ao recuperar arquivo de propriedades", e);
			throw new GenericApplicationException("Ocorreu um erro na aplicação.");
			
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
		
	}
}
