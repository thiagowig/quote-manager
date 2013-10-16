package br.com.zaul.manager.quote.factory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;

public class LoggerFactory {

	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		Logger logger = org.slf4j.LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
		return logger;
	}
}
