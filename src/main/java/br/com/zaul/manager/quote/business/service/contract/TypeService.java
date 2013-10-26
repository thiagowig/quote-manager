package br.com.zaul.manager.quote.business.service.contract;

import java.util.List;

import javax.ejb.Local;

import br.com.zaul.manager.quote.business.service.entity.Type;

@Local
public interface TypeService {

	List<Type> listTypes();
	
	void save(Type type);
	
	Type findByName(String name);
}
