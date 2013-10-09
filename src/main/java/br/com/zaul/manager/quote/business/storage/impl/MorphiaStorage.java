package br.com.zaul.manager.quote.business.storage.impl;

import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import br.com.zaul.manager.quote.business.storage.contract.Storage;

import com.mongodb.MongoClient;

public class MorphiaStorage<T> implements Storage<T> {

	private Datastore datastore;
	
	private static final String URL_PATTERN = "mongodb://$%s:$%s/";
	
	private static final String MONGO_HOST = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
	
	private static final String MONGO_PORT = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
	
	public MorphiaStorage() {
		try {
			this.datastore = new Morphia().createDatastore(new MongoClient(String.format(URL_PATTERN, MONGO_HOST, MONGO_PORT)), "db");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(T type) {
		this.datastore.save(type);
	}

	@Override
	public List<T> listAll() {
		Query<T> find = this.datastore.find(null);
		
		return find.asList();
	}

}
