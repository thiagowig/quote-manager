package br.com.zaul.manager.quote.business.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.zaul.manager.quote.business.service.contract.QuoteService;
import br.com.zaul.manager.quote.business.service.entity.Quote;
import br.com.zaul.manager.quote.business.storage.contract.DataAccess;

@Stateless
public class QuoteServiceImpl implements QuoteService {

	@Inject
	private DataAccess dataAccess;
	
	@Override
	public List<Quote> listAll() {
		return this.dataAccess.find(Quote.class);
	}

	@Override
	public void save(Quote quote) {
		this.dataAccess.save(quote);
	}

	@Override
	public void delete(Quote quote) {
		dataAccess.delete(quote);
	}

	
}
