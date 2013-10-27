package br.com.zaul.manager.quote.business.storage.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.slf4j.Logger;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;
import br.com.zaul.manager.quote.business.service.entity.SortType;
import br.com.zaul.manager.quote.business.storage.contract.DataAccess;
import br.com.zaul.manager.quote.exception.DatabaseException;
import br.com.zaul.manager.quote.exception.GenericApplicationException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 * 
 * @author thiago
 */
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
		mongoObject.setCreatedTime(new Date());
		
		if (mongoObject.getId() == null) {
			collection.save(mongoObject.getDbObject());
			
		} else {
			collection.update(new BasicDBObject("_id", new ObjectId(mongoObject.getId())), mongoObject.getDbObject());
		}
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
		return this.find(classFromObject, null, null);
	}
	
	/**
	 * 
	 */
	@Override
	public <T extends MongoObject> List<T> find(Class<T> classFromObject, String sortColumn, SortType sortType) {
		try (DBCursor cursor = this.db.getCollection(classFromObject.getSimpleName()).find()) {
			
			if (sortColumn != null) {
				cursor.sort(new BasicDBObject(sortColumn, sortType.getValue()));
			}
			
			return this.generateListFromCursor(classFromObject, cursor);
			
			
		} catch(Exception e) {
			LOGGER.error("Erro ao recuperar a lista do tipo: " + classFromObject.getSimpleName(), e);
			throw new DatabaseException();
		}
	}
	
	/*
	 * 
	 */
	private <T extends MongoObject> List<T> generateListFromCursor(Class<T> classFromObject, DBCursor cursor) throws InstantiationException, IllegalAccessException {
		List<T> list = new ArrayList<T>();
		
		while(cursor.hasNext()) {
			T object = classFromObject.newInstance();
			object.setDbObject(cursor.next());
			list.add(object);
		}
		
		return list;
	}
	
	/**
	 * 
	 */
	@Override
	public <T extends MongoObject, V> T findOneBy(Class<T > classFromObject, String key, V value) {
		try {
			return performFindOneBy(classFromObject, key, value);
			
		} catch (IllegalAccessException | InstantiationException e) {
			LOGGER.error("Erro ao instanciar o objeto: " + classFromObject.getSimpleName(), e);
			throw new GenericApplicationException(":( ERRO");
			
		} catch (Exception e) {
			LOGGER.error("Erro na busca por um elemento", e);
			throw new DatabaseException(":( ERRO");
		}
	}

	/*
	 * 
	 */
	private <T extends MongoObject, V> T performFindOneBy(Class<T> classFromObject, String key, V value)throws InstantiationException, IllegalAccessException {
		DBCollection collection = this.db.getCollection(classFromObject.getSimpleName());
		DBObject dBObject = collection.findOne(new BasicDBObject(key, value));
		
		if (dBObject != null) {
			T object = classFromObject.newInstance();
			object.setDbObject(dBObject);
			
			return object;
		}
		
		return null;
	}
	
	/**
	 * 
	 */
	@Override
	public <T extends MongoObject, V> List<T> findBy(Class<T > classFromObject, String key, V value) {
		try {
			DBCollection collection = this.db.getCollection(classFromObject.getSimpleName());
			DBCursor cursor = collection.find(new BasicDBObject(key, value));
			
			return generateListFromCursor(classFromObject, cursor);
			
		} catch (IllegalAccessException | InstantiationException e) {
			LOGGER.error("Erro ao instanciar o objeto: " + classFromObject.getSimpleName(), e);
			throw new GenericApplicationException(":( ERRO");
			
		} catch (Exception e) {
			LOGGER.error("Erro na busca por um elemento", e);
			throw new DatabaseException(":( ERRO");
		}
	}
}
