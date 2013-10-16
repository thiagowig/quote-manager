package br.com.zaul.manager.quote.business.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;
import br.com.zaul.manager.quote.business.storage.contract.DataAccess;

@Stateless
public class TypeServiceImpl implements TypeService {

	@Inject
	private DataAccess<Type> dataAccess;
	
	@Override
	public List<Type> listTypes() {
		return this.dataAccess.listAll(Type.class, Type.COLLECTION_NAME);
	}

	@Override
	public void save(Type type) {
		this.dataAccess.save(type);
	}

	
}
