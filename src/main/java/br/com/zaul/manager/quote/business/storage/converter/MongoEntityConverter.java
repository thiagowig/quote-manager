package br.com.zaul.manager.quote.business.storage.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;
import br.com.zaul.manager.quote.exception.GenericApplicationException;

import com.mongodb.DBCursor;

/**
 * 
 * @author thiago
 *
 */
public class MongoEntityConverter implements EntityConverter {

	/**
	 * 
	 */
	@Override
	public <T extends MongoObject> List<T> convertCursorInList(Class<T> classFromObject, DBCursor cursor) {
		try {
			List<T> list = new ArrayList<T>();
			
			while(cursor.hasNext()) {
				T object = classFromObject.newInstance();
				object.setDbObject(cursor.next());
				list.add(object);
			}
			
			return list;
			
		}catch (Exception e) {
			throw new GenericApplicationException("");
		}
	}
	
}
