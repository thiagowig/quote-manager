package br.com.zaul.manager.quote.business.storage.factory;

import java.net.UnknownHostException;
import java.util.Properties;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zaul.manager.quote.exception.DatabaseException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoConfigFactory {
	
	@Inject
	private Properties propertiesConfig;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfigFactory.class);

	@Produces
	public DB produceDB(InjectionPoint injectionPoint) {	
		try {
			String mongoHost = System.getenv(propertiesConfig.getProperty("database.mongo.host"));
			int mongoPort = Integer.parseInt(System.getenv(propertiesConfig.getProperty("database.mongo.port")));
			String databaseName = propertiesConfig.getProperty("database.mongo.name");
			String user = propertiesConfig.getProperty("database.mongo.user");
			char[] pass = propertiesConfig.getProperty("database.mongo.pass").toCharArray();
			
			MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
			DB db = mongoClient.getDB(databaseName);
			db.authenticate(user, pass);
			return db;
			
		} catch (UnknownHostException e) {
			LOGGER.error("Erro ao iniciar o banco de dados", e);
			throw new DatabaseException();
		}
		
	}
}

