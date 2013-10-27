package br.com.zaul.manager.quote.view.controller.quote;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.zaul.manager.quote.business.service.contract.QuoteService;
import br.com.zaul.manager.quote.business.service.entity.Quote;

@ManagedBean
@SessionScoped
public class ListQuotesController {

	@EJB
	private QuoteService quoteService;
	
	public List<Quote> getQuotes() {
		return quoteService.listAll();
	}

}
