package br.com.zaul.manager.quote.business.storage.contract;

import java.util.List;

public interface DataAccess<T> {

	void save(T type);
	
	List<T> listAll();
}
