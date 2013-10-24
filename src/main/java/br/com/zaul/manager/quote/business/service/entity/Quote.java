package br.com.zaul.manager.quote.business.service.entity;

import java.io.Serializable;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Quote implements MongoObject, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4940432282177744433L;

	public static final String COLLECTION_NAME = "quote";

	private DBObject dbObject;
	
	private Type type;
	
	public Quote() {
		this.dbObject = new BasicDBObject();
	}
	
	public String getId() {
		return this.dbObject.get("_id").toString();
	}

	public String getDescription() {
		return (String) this.dbObject.get("description");
	}

	public void setDescription(String description) {
		this.getDbObject().put("description", description);
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
		this.getDbObject().put(type.getCollectionName(), type.getDbObject());
	}

	@Override
	public DBObject getDbObject() {
		return this.dbObject;
	}

	@Override
	public void setDbObject(DBObject dBObject) {
		this.dbObject = dBObject;
	}

	@Override
	public String getCollectionName() {
		return COLLECTION_NAME;
	}

}
