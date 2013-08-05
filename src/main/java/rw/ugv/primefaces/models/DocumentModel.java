package rw.ugv.primefaces.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModelListener;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import rw.ugv.dao.DocumentDAO;
import rw.ugv.dto.UgvDocument;
import rw.ugv.qualifiers.LazyDocumentModel;
import rw.ugv.qualifiers.Priznak;

@LazyDocumentModel
@SessionScoped
public class DocumentModel extends LazyDataModel<UgvDocument> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262441003721490567L;
	@Inject
	private transient Logger logger;
	
	
	List<UgvDocument> list;
	
//	@Inject @Priznak
//	char priznak;
	
	@Inject
	DocumentDAO documentDao;
	
	@Override
	public List<UgvDocument> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		
		logger.debug("in LazyDocumentModel load()");
		Set<String> keys = filters.keySet();
		for (String string : keys) {
			logger.debug(string);
		}
		Collection<String> values = filters.values();
		for (String string : values) {
			logger.debug(string);
		}
		logger.debug(String.format("in load(), first = %d, pageSize = %d, sortField = %s",first,pageSize,sortField));
		if (documentDao == null) {
			logger.debug("Document Dao wan not injected");
		}
		boolean ascending = (sortOrder == SortOrder.ASCENDING) ? true : false;
		
		try {
			list = documentDao.pagination(first, pageSize, sortField, ascending, filters);
//			list = documentDao.paginationWithoutPriznak(first,pageSize, sortField, ascending,filters);
			for (UgvDocument ugvDocument : list) {
				logger.debug(ugvDocument);
			}
			long rowCount = documentDao.rowsNumber();
			int rowCountInt = (int) ((rowCount < Integer.MAX_VALUE)
				? rowCount : Integer.MAX_VALUE);
			if (rowCountInt == Integer.MAX_VALUE) {
				logger.debug(String.format("There are too much rows for the table. First %d will be taken", Integer.MAX_VALUE));
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
	public UgvDocument getRowData(String rowKey) {
		logger.error(String.format("In documentModel getRowData(String rowKey) %n rowKey = %s",rowKey));
		UgvDocument Document = null;

		if (list.size() > 0) {
			Document = list.get(0);
		}
		try {
				Timestamp timestamp = Timestamp.valueOf(rowKey);
				for (UgvDocument ugvDocument : list) {
					if (ugvDocument.getId().equals(timestamp)) {
						Document = ugvDocument;
						break;
					}
				}
		} catch (IllegalArgumentException e) {
			logger.error("rowKey is not timestamp",e);
		}
		if (Document == null) {
			Document = new UgvDocument();
		}
		
			return Document;
	}
	@Override
	public UgvDocument getRowData() {
		UgvDocument ugvDocument = super.getRowData();
		logger.debug("In documentModel getRowData() /n " + ugvDocument);
		return ugvDocument;
	}

	@Override
	public void setRowIndex(int rowIndex) {
		int myIndex = rowIndex;
		logger.info(String.format("In documentModel setRowIndex, rowIndex = %d%n",rowIndex));
		if (getPageSize() == 0) {
			setPageSize(1);
		}
//		if (getPageSize() > 0 && rowIndex == -1) {
//			myIndex = 0;
//		}
		super.setRowIndex(myIndex);
	}

	@Override
	public Object getRowKey(UgvDocument object) {
		logger.debug("In documentModel getRowKey()");
		return object.getId();
	}

	@Override
	public boolean isRowAvailable() {
		boolean available = super.isRowAvailable();
		logger.info(String.format("In documentModel isRowAvailable() %b%n",available));
		return available;
	}

	@Override
	public int getRowCount() {
		int rowCount = super.getRowCount();
		logger.info(String.format("In documentModel getRowCount(), rowCount = %d%n",rowCount));
		return super.getRowCount();
	}


	@Override
	public int getRowIndex() {
		logger.debug("In documentModel getRowIndex()");
		return super.getRowIndex();
	}

	@Override
	public Object getWrappedData() {
		logger.debug("In documentModel getWrappedData()");
		return super.getWrappedData();
	}

	@Override
	public void setWrappedData(Object list) {
		
		logger.debug("In documentModel setWrappedData()");
		super.setWrappedData(list);
	}

	@Override
	public int getPageSize() {
		int pageSize = super.getPageSize();
		logger.info(String.format("In documentModel getPageSize() %d%n",pageSize));
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		logger.info(String.format("In documentModel setPageSize(), pageSize = %d%n", pageSize));
		super.setPageSize(pageSize);
	}

	@Override
	public void setRowCount(int rowCount) {
		logger.info(String.format("In documentModel setRowCount() %d%n",rowCount));
		super.setRowCount(rowCount);
	}

	@Override
	public List<UgvDocument> load(int first, int pageSize,
			List<SortMeta> multiSortMeta, Map<String, String> filters) {
		logger.debug("In documentModel load(int first, int pageSize," +
				"List<SortMeta> multiSortMeta, Map<String, String> filters)");
		return super.load(first, pageSize, multiSortMeta, filters);
	}

	@Override
	public void addDataModelListener(DataModelListener listener) {
		logger.debug("In documentModel addDataModelListener()");
		super.addDataModelListener(listener);
	}

	@Override
	public DataModelListener[] getDataModelListeners() {
		logger.debug("In documentModel getDataModelListeners()");
		return super.getDataModelListeners();
	}

	@Override
	public Iterator<UgvDocument> iterator() {
		logger.debug("In documentModel iterator()");
		return super.iterator();
	}

	@Override
	public void removeDataModelListener(DataModelListener listener) {
		logger.debug("In documentModel removeDataModelListener()");
		super.removeDataModelListener(listener);
	}
}
