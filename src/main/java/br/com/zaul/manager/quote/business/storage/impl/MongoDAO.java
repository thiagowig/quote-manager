package br.com.zaul.manager.quote.business.storage.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.zaul.manager.quote.business.storage.contract.DataAccess;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class MongoDAO<T> implements DataAccess<T> {

	@Inject
	private DB db;
	
	@Override
	public void save(T type) {
		DBCollection collection = this.db.getCollection(type.getClass().getSimpleName());
		collection.save((DBObject) type);
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
