package br.com.zaul.manager.quote.business.service.entity;

import java.io.Serializable;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Quote implements MongoObject, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4940432282177744433L;

	private DBObject dbObject;
	
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
	
	public String getType() {
		return (String) this.getDbObject().get("Type");
	}

	public void setType(String type) {
		this.getDbObject().put("Type", type);
	}

	@Override
	public DBObject getDbObject() {
		return this.dbObject;
	}

	@Override
	public void setDbObject(DBObject dBObject) {
		this.dbObject = dBObject;
	}

}
