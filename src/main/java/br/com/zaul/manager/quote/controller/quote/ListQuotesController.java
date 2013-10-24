package br.com.zaul.manager.quote.controller.quote;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.zaul.manager.quote.business.service.contract.QuoteService;
import br.com.zaul.manager.quote.business.service.entity.Quote;

@ManagedBean
public class ListQuotesController {

	@EJB
	private QuoteService quoteService;
	
	public List<Quote> list() {
		return quoteService.listAll();
	}

	public List<Quote> getQuotes() {
		return quoteService.listAll();
	}

}
