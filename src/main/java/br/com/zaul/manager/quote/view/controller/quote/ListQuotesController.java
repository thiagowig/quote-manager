package br.com.zaul.manager.quote.view.controller.quote;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.zaul.manager.quote.business.mail.contract.EmailSender;
import br.com.zaul.manager.quote.business.service.contract.QuoteService;
import br.com.zaul.manager.quote.business.service.entity.Quote;

@ManagedBean
@SessionScoped
public class ListQuotesController {
	
	@Inject
	private EmailSender sender;

	@EJB
	private QuoteService quoteService;
	
	public List<Quote> getQuotes() {
		sender.from("thiago.fonseca@arkhi.com.br").to("dev.thiago@gmail.com").withTheSubject("Test").withTheText("Texto").sendAsync();
		return quoteService.listAll();
	}

}
