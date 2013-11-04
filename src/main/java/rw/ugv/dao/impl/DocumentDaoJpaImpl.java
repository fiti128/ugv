package rw.ugv.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;

import rw.ugv.dao.DocumentDAO;
import rw.ugv.dto.UgvDocument;

@Stateless(name = "documentDao")
@Named(value = "documentDao")
public class DocumentDaoJpaImpl extends GenericDaoJpaImpl<UgvDocument,Timestamp> implements
		DocumentDAO,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6880376946784369463L;

	@Override
	public List<UgvDocument> paginationWithoutPriznak(int first, int pageSize,
			String sortField, boolean ascending, Map<String, String> filters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
