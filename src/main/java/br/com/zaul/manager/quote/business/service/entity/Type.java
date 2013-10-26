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
	public void setDbObject(DBObject dbObject) {
		this.dbObject = dbObject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
	
	
}
