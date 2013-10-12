package br.com.zaul.manager.quote.business.storage.factory;

import java.net.UnknownHostException;
import java.util.Properties;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import br.com.zaul.manager.quote.exception.DatabaseException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoConfigFactory {
	
	@Inject
	private Properties propertiesConfig;

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
			e.printStackTrace();
			throw new DatabaseException("Erro ao conectar no banco");
		}
		
	}
}

