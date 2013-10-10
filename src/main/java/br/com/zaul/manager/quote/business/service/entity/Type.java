package br.com.zaul.manager.quote.business.service.entity;

import com.mongodb.BasicDBObject;

public class Type extends BasicDBObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5163942329463265811L;

	public String getId() {
		return super.getString("_id");
	}

	public void setId(String id) {
		super.append("_id", id);
	}

	public String getName() {
		return super.getString("name");
	}

	public void setName(String name) {
		super.append("name", name);
	}
	
	
}
