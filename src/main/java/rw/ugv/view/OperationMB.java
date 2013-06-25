package rw.ugv.view;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dao.impl.OperationDaoJpaImpl;
import rw.ugv.dto.UgvOperation;

@ManagedBean
@ViewScoped
public class OperationMB implements Serializable {
	private static Logger logger = Logger.getLogger(OperationMB.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -3637216621138713877L;
	private LazyDataModel<UgvOperation> operations = null;
	private UgvOperation ugvOperation;
	private LazyDataModel<UgvOperation> filteredOperations = null;

	public LazyDataModel<UgvOperation> getOperations() {
		logger.debug("In OperationMB getOperations()");
		if (operations == null) { 
			OperationDAO operationDao = new OperationDaoJpaImpl();
			operations = new LazyOperationList(operationDao); 
		}
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
