package br.com.zaul.manager.quote.business.service.entity;

import com.mongodb.DBObject;

public interface MongoObject {

	DBObject getDbObject();
	
	void setDbObject(DBObject dBObject);
	
}
