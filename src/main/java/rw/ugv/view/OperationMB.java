package rw.ugv.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dao.impl.OperationDaoJpaImpl;
import rw.ugv.dto.UgvOperation;

@ViewScoped
@ManagedBean
public class OperationMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3637216621138713877L;
	private LazyDataModel<UgvOperation> operations = null;
	private UgvOperation ugvOperation;

	public LazyDataModel<UgvOperation> getOperations() {
		if (operations == null) {
			OperationDAO operationDao = new OperationDaoJpaImpl();
			operations = new LazyOperationList(operationDao);
		}
		return operations;
	}

	public UgvOperation getUgvOperation() {
		if (ugvOperation == null) {
			ugvOperation = new UgvOperation();
		}
		return ugvOperation;
	}

	public void setUgvOperation(UgvOperation ugvOperation) {
		this.ugvOperation = ugvOperation;
	} 


	
	
	
	
}
