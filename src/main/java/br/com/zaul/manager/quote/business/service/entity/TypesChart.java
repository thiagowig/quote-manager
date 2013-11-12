package br.com.zaul.manager.quote.business.service.entity;

import java.io.Serializable;

public final class TypesChart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6834946355470806500L;

	private final String typeName;
	
	private final Integer quotesAmount;
	
	public TypesChart(String typeName, Integer quotesAmount) {
		this.typeName = typeName;
		this.quotesAmount = quotesAmount;
	}

	public String getTypeName() {
		return typeName;
	}

	public Integer getQuotesAmount() {
		return quotesAmount;
	}
}
