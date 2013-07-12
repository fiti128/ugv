package rw.ugv.dao.impl;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;





import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvOperation;


@Stateful(name = "operationDao")
@TransactionManagement(TransactionManagementType.BEAN)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class OperationDaoJpaImpl extends GenericDaoJpaImpl<UgvOperation,Timestamp> implements OperationDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8046489267741149158L;
  
}
