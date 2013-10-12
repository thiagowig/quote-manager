package br.com.zaul.manager.quote.controller.type;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Type;
import br.com.zaul.manager.quote.exception.DatabaseException;
import br.com.zaul.manager.quote.exception.GenericApplicationException;

@ManagedBean
public class SaveTypeController {

	private Type type;
	
	@EJB
	private TypeService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveTypeController.class);
	
	public void save() {
		try {
			this.doSave();
			
		} catch (DatabaseException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no banco de dados", null));
			
		} catch (GenericApplicationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro genérico", null));
			
		} catch (Exception e) {
			LOGGER.error("Erro ao salvar o tipo", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro assustador", null));
		}
	}
	
	private void doSave() {
		this.service.save(this.type);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo inserido com sucesso", null));
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
