package br.com.zaul.manager.quote.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;

@FacesConverter(value="typeConverter", forClass=Type.class)
public class TypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			TypeService typeService = (TypeService) new InitialContext().lookup("global/quotemanager/TypeServiceImpl");
			Type type = typeService.findByName(value);
			return type;
		} catch (NamingException e) {
			throw new ConverterException();
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null && object instanceof Type) {
			return ((Type) object).getName();
		}

		throw new ConverterException();
	}

}
