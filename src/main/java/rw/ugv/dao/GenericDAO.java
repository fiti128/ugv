package rw.ugv.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,PK extends Serializable> {
	
	void create(T t);
	T update(T t);
	T read(PK pk);
	void delete(T t);
	List<T> pagination(int firstResult, int maxResults, String orderByfieldName, boolean ascending);
	
}
