package br.com.zaul.manager.quote.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Quote;
import br.com.zaul.manager.quote.business.service.entity.SortType;
import br.com.zaul.manager.quote.business.service.entity.Type;
import br.com.zaul.manager.quote.business.service.entity.TypesChart;
import br.com.zaul.manager.quote.business.storage.contract.DataAccess;
import br.com.zaul.manager.quote.exception.ValidationException;

@Stateless
public class TypeServiceImpl implements TypeService {

	@Inject
	private DataAccess dataAccess;
	
	@Override
	public List<Type> listAll() {
		return this.dataAccess.find(Type.class);
	}
	
	@Override
	public List<Type> listAllOrdered(String columnName, SortType sortType) {
		return dataAccess.find(Type.class, columnName, sortType);
	}

	@Override
	public void save(Type type) {
		
		if (findByName(type.getName()) != null) {
			throw new ValidationException("Este tipo já existe.");
		}
		
		this.dataAccess.save(type);
	}
	
	@Override
	public void delete(Type type) {
		List<Quote> quotes = dataAccess.findBy(Quote.class, "Type", type.getName());
		
		if (quotes.isEmpty()) {
			this.dataAccess.delete(type);
			
		} else {
			throw new ValidationException("Fudeu");
		}
	}

	@Override
	public Type findByName(String name) {
		return dataAccess.findOneBy(Type.class, "name", name);
	}

	@Override
	public List<TypesChart> listTypeChart() {
		List<TypesChart> typesCharts = new ArrayList<>();
		List<Type> types = listAll();
		
		for (Type type : types) {
			Integer quoteAmount = dataAccess.countBy(Quote.class, Type.class.getSimpleName(), type.getName());
			TypesChart typesChart = new TypesChart(type.getName(), quoteAmount);
			
			typesCharts.add(typesChart);
		}
		
		return typesCharts;
	}
	
}
