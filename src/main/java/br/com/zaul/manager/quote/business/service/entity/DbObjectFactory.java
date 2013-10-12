package br.com.zaul.manager.quote.business.service.entity;

import javax.enterprise.inject.Produces;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class DbObjectFactory {

	@Produces
	public DBObject produceDbObject() {
		return new BasicDBObject();
	}
}
