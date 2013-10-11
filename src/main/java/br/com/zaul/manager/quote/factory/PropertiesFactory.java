package br.com.zaul.manager.quote.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.enterprise.inject.Produces;

public class PropertiesFactory {

	private static final String PROPERTIES_FILE_NAME = "application.properties";
	
	@Produces
	public Properties producePropertiesFile() {
		Properties propertiesFile = null;
		
		try {
			propertiesFile = new Properties();
			FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_NAME);
			
			propertiesFile.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return propertiesFile;
	}
}
