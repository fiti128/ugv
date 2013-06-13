package rw.ugv.view;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvOperation;

public class LazyOperationList extends LazyDataModel<UgvOperation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 411283559847593822L;
	
	public LazyOperationList(OperationDAO operationDao) {
		this.operationDao = operationDao;
	}
	OperationDAO operationDao;
	
	List<UgvOperation> list;
	
	@Override
	public List<UgvOperation> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		
		System.err.println("in LazyOperationModel load()");
		if (operationDao == null) {
			System.err.println("Operation Dao wan not injected");
		}
		list = operationDao.pagination(first, pageSize, sortField, true);
		for (UgvOperation ugvOperation : list) {
			System.err.println(ugvOperation);
		}
		setPageSize(pageSize);
		return list;
	}

	@Override
	public UgvOperation getRowData(String rowKey) {
			return list.get(0);
	}

	@Override
	public void setRowIndex(int rowIndex) {
		if (getPageSize() == 0) {
			setPageSize(1);
		}
		super.setRowIndex(rowIndex);
	}

	@Override
	public Object getRowKey(UgvOperation object) {
		return object.getId();
	}


	
	
	
	
}
