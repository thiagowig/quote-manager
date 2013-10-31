package br.com.zaul.manager.quote.view.controller.type;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

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

	private PieChartModel pieModel;

	public ListTypesController() {
        createPieModel();
	}

    public PieChartModel getPieModel() {
        return pieModel;
    }

    private void createPieModel() {
        pieModel = new PieChartModel();

        pieModel.set("Brand 1", 540);
        pieModel.set("Brand 2", 325);
        pieModel.set("Brand 3", 702);
        pieModel.set("Brand 4", 421);
    }
	
}
