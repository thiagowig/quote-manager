package br.com.zaul.manager.quote.view.controller.quote;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.zaul.manager.quote.business.service.contract.QuoteService;
import br.com.zaul.manager.quote.business.service.entity.Quote;
import br.com.zaul.manager.quote.exception.DatabaseException;
import br.com.zaul.manager.quote.exception.GenericApplicationException;

@ManagedBean
public class DeleteQuoteController {

	@EJB
	private QuoteService service;

	public void delete(Quote quote) {
		try {
			this.doDelete(quote);
			
		} catch (DatabaseException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no banco de dados", null));
			
		} catch (GenericApplicationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro genérico", null));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro assustador", null));
		}
	}
	
	private void doDelete(Quote quote) {
		this.service.delete(quote);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Citação deletada com sucesso", null));
	}
	
}
