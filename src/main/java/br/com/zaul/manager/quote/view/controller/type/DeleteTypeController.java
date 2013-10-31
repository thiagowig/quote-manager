package br.com.zaul.manager.quote.view.controller.type;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;

@ManagedBean
public class DeleteTypeController {

	@EJB
	private TypeService service;

	public void delete(Type type) {
		try {
			this.doDelete(type);
			
		}catch (EJBException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro genérico", null));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro assustador", null));
		}
	}
	
	private void doDelete(Type type) {
		this.service.delete(type);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo deletado com sucesso", null));
	}
	
}
