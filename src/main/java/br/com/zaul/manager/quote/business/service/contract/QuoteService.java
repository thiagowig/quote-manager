package br.com.zaul.manager.quote.business.service.contract;

import java.util.List;

import javax.ejb.Local;

import br.com.zaul.manager.quote.business.service.entity.Quote;

@Local
public interface QuoteService {

	List<Quote> listAll();
	
	void save(Quote quote);
	
	void delete(Quote quote);
}
