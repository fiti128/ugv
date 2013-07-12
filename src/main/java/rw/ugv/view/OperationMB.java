package rw.ugv.view;

import java.io.Serializable;


import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dao.impl.OperationDaoJpaImpl;
import rw.ugv.dto.UgvOperation;

@Named
@SessionScoped
public class OperationMB implements Serializable {
	private static Logger logger = Logger.getLogger(OperationMB.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -3637216621138713877L;
	@Inject
	private LazyDataModel<UgvOperation> operations;
	private UgvOperation ugvOperation;
	private LazyDataModel<UgvOperation> filteredOperations = null;


	public LazyDataModel<UgvOperation> getOperations() {
		logger.debug("In OperationMB getOperations()");
		return operations;
	}

//	public LazyDataModel<UgvOperation> getOperations() {
//		if (operations == null) {
//			operations = new LazyOperationList();
//		}
//		return operations;
//	}
	public UgvOperation getUgvOperation() {
		System.err.println("In OperationMB getUgvOperation()");
		if (ugvOperation == null) {
			ugvOperation = new UgvOperation();
		}
		return ugvOperation;
	}

	public void setUgvOperation(UgvOperation ugvOperation) {
		System.err.println("In OperationMB setUgvOperation()");
		this.ugvOperation = ugvOperation;
	}

	public LazyDataModel<UgvOperation> getFilteredOperations() {
		return filteredOperations;
	}

	public void setFilteredOperations(LazyDataModel<UgvOperation> filteredOperations) {
		this.filteredOperations = filteredOperations;
	}




	
	
	
	
}
