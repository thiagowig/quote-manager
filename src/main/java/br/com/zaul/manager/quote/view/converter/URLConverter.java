package br.com.zaul.manager.quote.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.zaul.manager.quote.business.parser.Parser;
import br.com.zaul.manager.quote.factory.ServiceLocator;

@FacesConverter(value="urlConverter")
public class URLConverter implements Converter {
	
	private Parser parser;
	
	public URLConverter() {
		parser = ServiceLocator.getParser();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return parser.deparse(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		return parser.parse(object.toString());
	}

}
