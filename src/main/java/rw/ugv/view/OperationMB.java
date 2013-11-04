package rw.ugv.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import rw.ugv.dto.UgvOperation;
import rw.ugv.qualifiers.LazyOperationModel;
import rw.ugv.qualifiers.Selected;


@Named
@RequestScoped
public class OperationMB implements Serializable {
	@Inject
	private transient Logger logger;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3637216621138713877L;
	@Inject @LazyOperationModel
	private LazyDataModel<UgvOperation> operations;
	private UgvOperation ugvOperation;
	private LazyDataModel<UgvOperation> filteredOperations = null;


	public LazyDataModel<UgvOperation> getOperations() {
		logger.debug(String.format("Injecting logger with giving name %s",logger.getName()));
		logger.debug("In OperationMB getOperations()");
		return operations;
	}
	@Produces @Selected
	public UgvOperation getUgvOperation() {
		logger.debug("In OperationMB getUgvOperation()");
		if (ugvOperation == null) {
			ugvOperation = new UgvOperation();
		}
		return ugvOperation;
	}

	public void setUgvOperation(UgvOperation ugvOperation) {
		logger.debug("In OperationMB setUgvOperation()");
		this.ugvOperation = ugvOperation;
	}

	public LazyDataModel<UgvOperation> getFilteredOperations() {
		return filteredOperations;
	}

	public void setFilteredOperations(LazyDataModel<UgvOperation> filteredOperations) {
		this.filteredOperations = filteredOperations;
	}


	
}
