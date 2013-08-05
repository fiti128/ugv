package rw.ugv.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;



import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvOperation;


public interface OperationDAO extends GenericDAO<UgvOperation,Timestamp>{

	List<UgvOperation> docDependentPagination(UgvDocument ugvDocument,
			int first, int pageSize, String sortField, boolean ascending,
			Map<String, String> filters);

	long rowsNumber(UgvDocument ugvDocument, String sortField,
			Map<String, String> filters);

	
	
}
