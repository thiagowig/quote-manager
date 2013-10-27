package br.com.zaul.manager.quote.view.controller.type;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.SortType;
import br.com.zaul.manager.quote.business.service.entity.Type;

@ManagedBean
@SessionScoped
public class ListTypesController {

	@EJB
	private TypeService typeService;
	
	public List<Type> getTypes() {
		return typeService.listAllOrdered("createdTime", SortType.DESC);
	}
	
}
