package br.com.zaul.manager.quote.business.parser;

public interface Parser {

	String parse(String value);
	
	String deparse(String value);
}
