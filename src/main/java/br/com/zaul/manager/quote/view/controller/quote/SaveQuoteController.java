package br.com.zaul.manager.quote.view.controller.quote;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.zaul.manager.quote.business.service.contract.QuoteService;
import br.com.zaul.manager.quote.business.service.contract.TypeService;
import br.com.zaul.manager.quote.business.service.entity.Quote;
import br.com.zaul.manager.quote.business.service.entity.Type;
import br.com.zaul.manager.quote.exception.DatabaseException;
import br.com.zaul.manager.quote.exception.GenericApplicationException;

@ManagedBean
public class SaveQuoteController {

	private Quote quote;
	
	private Type type;
	
	@EJB
	private QuoteService service;

	@EJB
	private TypeService typeService;

	public void save(AjaxBehaviorEvent event) {
		try {
			this.doSave();
			
		} catch (DatabaseException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no banco de dados", null));
			
		} catch (GenericApplicationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro genérico", null));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro assustador", null));
		}
	}
	
	private void doSave() {
		this.quote.setType(type.getName());
		this.service.save(this.quote);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Citação inserido com sucesso", null));
	}
	
	public List<Type> getTypes() {
		return this.typeService.listTypes();
	}

	public Quote getQuote() {
		if (quote == null) {
			quote = new Quote();
		}
		
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	
}
