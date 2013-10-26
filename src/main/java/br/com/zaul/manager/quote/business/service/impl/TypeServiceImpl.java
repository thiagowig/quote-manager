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
	private DataAccess dataAccess;
	
	@Override
	public List<Type> listTypes() {
		return this.dataAccess.find(Type.class);
	}

	@Override
	public void save(Type type) {
		this.dataAccess.save(type);
	}

	@Override
	public Type findByName(String name) {
		return dataAccess.findOneBy(Type.class, "name", name);
	}

	
}
