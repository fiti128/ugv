package rw.ugv.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.Stateful;

import rw.ugv.dao.DocumentDAO;
import rw.ugv.dto.UgvDocument;

@Stateful(name = "documentDao")
public class DocumentDaoJpaImpl extends GenericDaoJpaImpl<UgvDocument,Timestamp> implements
		DocumentDAO,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6880376946784369463L;

}
