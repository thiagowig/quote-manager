package br.com.zaul.manager.quote.factory;

import br.com.zaul.manager.quote.business.parser.Parser;
import br.com.zaul.manager.quote.business.parser.URLParser;

public class ServiceLocator {

	public static Parser getParser() {
		return new URLParser();
	}
}
