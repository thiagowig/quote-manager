package br.com.zaul.manager.quote.controller.type;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;

@ManagedBean
@SessionScoped
public class SaveTypeController {

	private Type type;
	
	//@EJB
	//private TypeService service;
	
	public void save() {
		//this.service.save(this.type);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo inserido com sucesso"));
	}

	public Type getType() {
		if (type == null) {
			type = new Type();
		}
		
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}
