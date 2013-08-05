package rw.ugv.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDAO<T,PK extends Serializable> {
	
	void create(T t) throws Exception;
	T update(T t) throws Exception;
	T read(PK pk) throws Exception;
	void delete(T t) throws Exception;
	List<T> pagination(int firstResult, int maxResults, String orderByfieldName, boolean ascending, Map<String, String> filters) throws Exception;
	long rowsNumber() throws Exception;
	long rowsNumber(String sortField, Map<String, String> filters) throws Exception;
	
}
