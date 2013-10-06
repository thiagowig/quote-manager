package br.com.zaul.manager.quote.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class QuoteController {

	private String quote;
	
	private String krai;
	
	public void create() {
		System.out.println("Vai danada!!!");
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
