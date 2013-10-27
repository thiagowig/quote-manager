package br.com.zaul.manager.quote.business.service.entity;

import java.io.Serializable;
import java.util.Date;

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
		Object id = this.dbObject.get("_id");
		
		if (id != null) {
			return id.toString();
		}
		
		return null;
	}

	public String getDescription() {
		return (String) this.dbObject.get("description");
	}

	public void setDescription(String description) {
		this.getDbObject().put("description", description);
	}
	
	public String getQuote() {
		return (String) this.dbObject.get("quote");
	}

	public void setQuote(String quote) {
		this.getDbObject().put("quote", quote);
	}
	
	public String getType() {
		return (String) this.getDbObject().get("Type");
	}

	public void setType(String type) {
		this.getDbObject().put("Type", type);
	}
	
	public Date getCreatedTime() {
		return (Date) this.dbObject.get("createdTime");
	}

	public void setCreatedTime(Date createdTime) {
		this.getDbObject().put("createdTime", createdTime);
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
