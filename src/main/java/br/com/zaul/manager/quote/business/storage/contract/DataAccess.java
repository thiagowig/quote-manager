package br.com.zaul.manager.quote.business.storage.contract;

import java.util.List;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;
import br.com.zaul.manager.quote.business.service.entity.SortType;

public interface DataAccess {

	void save(MongoObject mongoObject);
	
	void delete(MongoObject mongoObject);
	
	<T extends MongoObject> List<T > find(Class<T> classFromObject);
	
	<T extends MongoObject> List<T > find(Class<T> classFromObject, String sortColumn, SortType sortType);
	
	<T extends MongoObject, V> T findOneBy(Class<T > classFromObject, String key, V value);
	
	<T extends MongoObject, V> List<T> findBy(Class<T > classFromObject, String key, V value);
}
