package rw.ugv.primefaces.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModelListener;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvOperation;
import rw.ugv.qualifiers.LazyOperationModel;
import rw.ugv.qualifiers.Selected;

@Named(value="operations")
@SessionScoped @LazyOperationModel
public class OperationModel extends LazyDataModel<UgvOperation> implements Serializable {
	public static Logger logger = Logger.getLogger(OperationModel.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 411283559847593822L;
	

	@Inject
	OperationDAO operationDao;
	
	@Inject @Selected
	UgvDocument ugvDocument;
	
	@PostConstruct
	public void testDao() {
		logger.error("Dao = " + operationDao);
	}
	
	List<UgvOperation> list;
	
	@Override
	public List<UgvOperation> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		
		System.err.println("in LazyOperationModel load()");
		System.err.println(ugvDocument);
		Set<String> keys = filters.keySet();
		for (String string : keys) {
			logger.fatal(string);
		}
		Collection<String> values = filters.values();
		for (String string : values) {
			logger.error(string);
		}
		logger.fatal(String.format("in load(), first = %d, pageSize = %d, sortField = %s",first,pageSize,sortField));
		if (operationDao == null) {
			logger.debug("Operation Dao wan not injected");
		}
		boolean ascending = (sortOrder == SortOrder.ASCENDING) ? true : false;
		
		try {
			long rowCount = 0;
			if (ugvDocument.getForm() == null) {
				list = operationDao.pagination(first, pageSize, sortField, ascending, filters);
				rowCount = operationDao.rowsNumber(sortField,filters);
			}
			else{
				list = operationDao.docDependentPagination(ugvDocument,first, pageSize, sortField, ascending, filters);
				rowCount = operationDao.rowsNumber(ugvDocument,sortField,filters);
			}
			for (UgvOperation ugvOperation : list) {
				logger.debug(ugvOperation);
			}

			int rowCountInt = (int) ((rowCount < Integer.MAX_VALUE)
				? rowCount : Integer.MAX_VALUE);
			if (rowCountInt == Integer.MAX_VALUE) {
				logger.error(String.format("There are too much rows for the table. First %d will be taken", Integer.MAX_VALUE));
			}
			logger.debug(String.format("Number of rows = %d", rowCountInt));
			setRowCount(rowCountInt);
			setPageSize(pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public UgvOperation getRowData(String rowKey) {
		logger.error(String.format("In LazyList getRowData(String rowKey) %n rowKey = %s",rowKey));
		UgvOperation operation = null;
		if (list.size() > 0) {
			operation = list.get(0);
		}
		try {
				Timestamp timestamp = Timestamp.valueOf(rowKey);
				for (UgvOperation ugvOperation : list) {
					if (ugvOperation.getId().equals(timestamp)) {
						operation = ugvOperation;
						break;
					}
				}
		} catch (IllegalArgumentException e) {
			logger.error("rowKey is not timestamp",e);
		}
		if (operation == null) {
			operation = new UgvOperation();
		}
		
			return operation;
	}
	@Override
	public UgvOperation getRowData() {
		UgvOperation ugvOperation = super.getRowData();
		logger.debug("In LazyList getRowData() /n " + ugvOperation);
		return ugvOperation;
	}

	@Override
	public void setRowIndex(int rowIndex) {
		int myIndex = rowIndex;
		logger.info(String.format("In LazyList setRowIndex, rowIndex = %d%n",rowIndex));
		if (getPageSize() == 0) {
			setPageSize(1);
		}
//		if (getPageSize() > 0 && rowIndex == -1) {
//			myIndex = 0;
//		}
		super.setRowIndex(myIndex);
	}

	@Override
	public Object getRowKey(UgvOperation object) {
		logger.debug("In LazyList getRowKey()");
		return object.getId();
	}

	@Override
	public boolean isRowAvailable() {
		boolean available = super.isRowAvailable();
		logger.info(String.format("In LazyList isRowAvailable() %b%n",available));
		return available;
	}

	@Override
	public int getRowCount() {
		int rowCount = super.getRowCount();
		logger.info(String.format("In LazyList getRowCount(), rowCount = %d%n",rowCount));
		return super.getRowCount();
	}


	@Override
	public int getRowIndex() {
		logger.debug("In LazyList getRowIndex()");
		return super.getRowIndex();
	}

	@Override
	public Object getWrappedData() {
		logger.debug("In LazyList getWrappedData()");
		return super.getWrappedData();
	}

	@Override
	public void setWrappedData(Object list) {
		
		logger.debug("In LazyList setWrappedData()");
		super.setWrappedData(list);
	}

	@Override
	public int getPageSize() {
		int pageSize = super.getPageSize();
		logger.info(String.format("In LazyList getPageSize() %d%n",pageSize));
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		logger.info(String.format("In LazyList setPageSize(), pageSize = %d%n", pageSize));
		super.setPageSize(pageSize);
	}

	@Override
	public void setRowCount(int rowCount) {
		logger.info(String.format("In LazyList setRowCount() %d%n",rowCount));
		super.setRowCount(rowCount);
	}

	@Override
	public List<UgvOperation> load(int first, int pageSize,
			List<SortMeta> multiSortMeta, Map<String, String> filters) {
		logger.debug("In LazyList load(int first, int pageSize," +
				"List<SortMeta> multiSortMeta, Map<String, String> filters)");
		return super.load(first, pageSize, multiSortMeta, filters);
	}

	@Override
	public void addDataModelListener(DataModelListener listener) {
		logger.debug("In LazyList addDataModelListener()");
		super.addDataModelListener(listener);
	}

	@Override
	public DataModelListener[] getDataModelListeners() {
		logger.debug("In LazyList getDataModelListeners()");
		return super.getDataModelListeners();
	}

	@Override
	public Iterator<UgvOperation> iterator() {
		logger.debug("In LazyList iterator()");
		return super.iterator();
	}

	@Override
	public void removeDataModelListener(DataModelListener listener) {
		logger.debug("In LazyList removeDataModelListener()");
		super.removeDataModelListener(listener);
	}

	


	
	
	
	
}
