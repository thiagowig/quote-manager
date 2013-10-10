package br.com.zaul.manager.quote.business.storage.impl;

import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import br.com.zaul.manager.quote.business.storage.contract.DataAccess;

import com.mongodb.MongoClient;

public class MorphiaDAO<T> { 
	
	/*implements DataAccess<T> {
	
	
}

	private Datastore datastore;
	
	private Morphia morphia;
	
	private static final String MONGO_HOST = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
	
	private static final Integer MONGO_PORT = Integer.valueOf(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
	
	public MorphiaDAO() {
		try {
			this.morphia = new Morphia();
			this.datastore = morphia.createDatastore(new MongoClient(MONGO_HOST, MONGO_PORT), "db");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(T type) {
		this.morphia.map(type.getClass());
		this.datastore.save(type);
	}

	@Override
	public List<T> listAll() {
		Query<T> find = this.datastore.find(null);
		
		return find.asList();
	}
*/
}
