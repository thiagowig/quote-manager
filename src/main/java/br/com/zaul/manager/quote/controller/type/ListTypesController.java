package br.com.zaul.manager.quote.controller.type;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;

@ManagedBean
public class ListTypesController {

	private List<Type> types;
	@EJB
	private TypeService typeService;
	
	public List<Type> list() {
		return typeService.listTypes();
	}

	public List<Type> getTypes() {
		return typeService.listTypes();
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
	
}
