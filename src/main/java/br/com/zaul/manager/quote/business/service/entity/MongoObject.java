package br.com.zaul.manager.quote.business.service.entity;

import java.util.Date;

import com.mongodb.DBObject;

public interface MongoObject {

	DBObject getDbObject();
	
	void setDbObject(DBObject dBObject);

	String getId();
	
	void setCreatedTime(Date date);
	
	
}
