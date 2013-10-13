package br.com.zaul.manager.quote.business.storage.converter;

import java.lang.reflect.Method;

import br.com.zaul.manager.quote.exception.DatabaseException;

import com.mongodb.DBObject;

public class MongoEntityConverter<T> {
	
	private Class<T> entityClass; 
	
	public MongoEntityConverter(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T convertDBObjectInTypeObject(DBObject dbObject) {
		T newType;
		
		try {
			newType = (T) entityClass.newInstance();
			Method[] declaredMethods = entityClass.getDeclaredMethods();
			
			for (Method method : declaredMethods) {
				//Persistent persistent = method.getAnnotation(Persistent.class);
				
				//if (persistent != null) {
				//	method.invoke(newType, dbObject.get(persistent.name()));
				//}
			}
			
			return newType;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException();
		}
		
	}
}
