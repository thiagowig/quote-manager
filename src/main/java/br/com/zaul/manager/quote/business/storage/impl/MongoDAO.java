package br.com.zaul.manager.quote.business.storage.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;
import br.com.zaul.manager.quote.business.storage.contract.DataAccess;
import br.com.zaul.manager.quote.exception.DatabaseException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoDAO<T extends MongoObject> implements DataAccess<T> {
	
	@Inject
	private DB db;
	@Inject
	private static Logger LOGGER;
	
	@Override
	public void save(MongoObject mongoObject) {
		DBCollection collection = this.db.getCollection(mongoObject.getCollectionName());
		collection.save(mongoObject.getDbObject());
	}

	@Override
	public List<T> listAll(Class<T> classFromObject, String collectionName) {
		DBCursor cursor = this.db.getCollection(collectionName).find();
		
		try {
			List<T> list = new ArrayList<T>();
			
			while(cursor.hasNext()) {
				T object = classFromObject.newInstance();
				object.setDbObject(cursor.next());
				list.add(object);
			}
			
			return list;
			
		} catch(Exception e) {
			LOGGER.error("Erro ao recuperar a lista do tipo: " + collectionName, e);
			throw new DatabaseException();
			
		} finally {
			cursor.close();
		}
		
	}
	
	

}
