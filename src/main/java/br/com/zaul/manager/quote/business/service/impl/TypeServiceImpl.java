package br.com.zaul.manager.quote.business.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;
import br.com.zaul.manager.quote.business.storage.contract.Storage;

@Stateless
public class TypeServiceImpl implements TypeService {

	@Inject
	private Storage<Type> storage;
	
	@Override
	public List<Type> listTypes() {
		return this.storage.listAll();
	}

	@Override
	public void save(Type type) {
		this.storage.save(type);
	}

	
}