package br.com.zaul.manager.quote.business.service.entity;

public enum SortType {

	ASC(1),
	DESC(-1);
	
	private int value;
	
	private SortType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
