package br.com.zaul.manager.quote.business.storage.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;
import br.com.zaul.manager.quote.business.storage.contract.DataAccess;
import br.com.zaul.manager.quote.exception.DatabaseException;
import br.com.zaul.manager.quote.exception.GenericApplicationException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoDAO implements DataAccess {
	
	@Inject
	private DB db;
	@Inject
	private static Logger LOGGER;
	
	/**
	 * 
	 */
	@Override
	public void save(MongoObject mongoObject) {
		DBCollection collection = this.db.getCollection(mongoObject.getClass().getSimpleName());
		collection.save(mongoObject.getDbObject());
	}
	
	/**
	 * 
	 */
	@Override
	public void delete(MongoObject mongoObject) {
		DBCollection collection = this.db.getCollection(mongoObject.getClass().getSimpleName());
		collection.remove(mongoObject.getDbObject());
	}

	/**
	 * 
	 */
	@Override
	public <T extends MongoObject> List<T> find(Class<T> classFromObject) {
		DBCursor cursor = this.db.getCollection(classFromObject.getSimpleName()).find();
		
		try {
			List<T> list = new ArrayList<T>();
			
			while(cursor.hasNext()) {
				T object = classFromObject.newInstance();
				object.setDbObject(cursor.next());
				list.add(object);
			}
			
			return list;
			
		} catch(Exception e) {
			LOGGER.error("Erro ao recuperar a lista do tipo: " + classFromObject.getSimpleName(), e);
			throw new DatabaseException();
			
		} finally {
			cursor.close();
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public <T extends MongoObject, V> T findOneBy(Class<T > classFromObject, String key, V value) {
		try {
			T object = classFromObject.newInstance();
			DBCollection collection = this.db.getCollection(classFromObject.getSimpleName());
			object.setDbObject(collection.findOne(new BasicDBObject(key, value)));
			
			return object;
			
		} catch (IllegalAccessException | InstantiationException e) {
			LOGGER.error("Erro ao instanciar o objeto: " + classFromObject.getSimpleName(), e);
			throw new GenericApplicationException(":( ERRO");
			
		} catch (Exception e) {
			LOGGER.error("Erro na busca por um elemento", e);
			throw new DatabaseException(":( ERRO");
		}
	}
	

}
