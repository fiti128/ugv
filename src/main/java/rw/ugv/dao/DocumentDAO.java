package rw.ugv.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import rw.ugv.dto.UgvDocument;

public interface DocumentDAO extends GenericDAO<UgvDocument,Timestamp>{

	List<UgvDocument> paginationWithoutPriznak(int first, int pageSize,
			String sortField, boolean ascending, Map<String, String> filters);

}
