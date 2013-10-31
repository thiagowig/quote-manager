package br.com.zaul.manager.quote.business.storage.converter;

import java.util.List;

import br.com.zaul.manager.quote.business.service.entity.MongoObject;

import com.mongodb.DBCursor;

public interface EntityConverter {

	<T extends MongoObject> List<T> convertCursorInList(Class<T> classFromObject, DBCursor cursor);
}
