package br.com.zaul.manager.quote.business.storage.factory;

import java.net.UnknownHostException;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DataAccessFactory {

	private static final String MONGO_HOST = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
	
	private static final Integer MONGO_PORT = Integer.valueOf(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
	
	private MongoClient mongoClient;
	
	private DB db;
	
	@Produces
	public DB produceDB(InjectionPoint injectionPoint) {	
		try {
			this.mongoClient = new MongoClient(MONGO_HOST, MONGO_PORT);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.db = this.mongoClient.getDB("db");
		
		return this.db;
	}
}

