package br.com.zaul.manager.quote.business.service.entity;

import java.io.Serializable;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Type implements MongoObject, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DBObject dbObject;
	
	public static final String COLLECTION_NAME = "type";
	
	public Type() {
		this.dbObject = new BasicDBObject();
	}
	
	public String getId() {
		return this.dbObject.get("_id").toString();
	}

	public String getName() {
		return (String) this.dbObject.get("name");
	}

	public void setName(String name) {
		this.getDbObject().put("name", name);
	}

	@Override
	public DBObject getDbObject() {
		return this.dbObject;
	}

	@Override
	public String getCollectionName() {
		return Type.COLLECTION_NAME;
	}

	@Override
	public void setDbObject(DBObject dbObject) {
		this.dbObject = dbObject;
	}
}
