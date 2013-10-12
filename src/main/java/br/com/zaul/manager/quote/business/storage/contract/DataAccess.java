package br.com.zaul.manager.quote.business.storage.contract;

import java.util.List;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;

public interface DataAccess<T extends MongoObject> {

	void save(MongoObject mongoObject);
	
	List<T> listAll(Class<T> classFromObject, String collectionName);
}
