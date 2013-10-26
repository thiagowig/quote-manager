package br.com.zaul.manager.quote.business.storage.contract;

import java.util.List;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;

public interface DataAccess {

	void save(MongoObject mongoObject);
	
	void delete(MongoObject mongoObject);
	
	<T extends MongoObject> List<T > find(Class<T> classFromObject);
	
	<T extends MongoObject, V> T findOneBy(Class<T > classFromObject, String key, V value);
}
