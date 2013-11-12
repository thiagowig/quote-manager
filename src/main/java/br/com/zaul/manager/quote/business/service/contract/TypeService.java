package br.com.zaul.manager.quote.business.service.contract;

import java.util.List;

import javax.ejb.Local;

import br.com.zaul.manager.quote.business.service.entity.SortType;
import br.com.zaul.manager.quote.business.service.entity.Type;
import br.com.zaul.manager.quote.business.service.entity.TypesChart;

@Local
public interface TypeService {

	List<Type> listAll();
	
	List<Type> listAllOrdered(String columnName, SortType sortType);
	
	void save(Type type);

	void delete(Type type);
	
	Type findByName(String name);
	
	List<TypesChart> listTypeChart();
}
