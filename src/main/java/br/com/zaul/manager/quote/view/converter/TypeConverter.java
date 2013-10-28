package br.com.zaul.manager.quote.view.converter;

import java.util.List;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.zaul.manager.quote.business.service.entity.Type;

@FacesConverter(value="typeConverter", forClass=Type.class)
public class TypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> l = component.getChildren();
		for (UIComponent uic : l) {
			if (uic.getFamily().equals("javax.faces.SelectItems")) {
				UISelectItems uis = (UISelectItems) uic;

				ValueExpression valueExpression = uis.getValueExpression("value");
				ELContext elContext = context.getELContext();

				List<Type> types = (List<Type>) valueExpression.getValue(elContext);

				for (Type type : types) {
					if (type.getName().equals(value)) {
						return type;
					}
				}
			}
		}
		return null;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null && object instanceof Type) {
			return ((Type) object).getName();
		}

		throw new ConverterException();
	}

}
