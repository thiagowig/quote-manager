package br.com.zaul.manager.quote.business.storage.converter;

import org.junit.Assert;
import org.junit.Test;

import br.com.zaul.manager.quote.business.service.entity.Type;

import com.mongodb.BasicDBObject;

public class MongoEntityConverterTest {

	@Test
	public void test() {
		MongoEntityConverter<Type> converter = new MongoEntityConverter<Type>(Type.class);
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.append("_id", "123");
		dbObject.append("name", "123");
		
		Type quoteType = converter.convertDBObjectInTypeObject(dbObject);
		
		Assert.assertEquals(dbObject.get("_id"), quoteType.getId());
		Assert.assertEquals(dbObject.get("name"), quoteType.getName());
	}
}
