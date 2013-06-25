package rw.ugv.dao.impl;


import java.sql.Timestamp;

import javax.ejb.Stateful;
import javax.inject.Named;



import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvOperation;


@Named(value="operationDao")
public class OperationDaoJpaImpl extends GenericDaoJpaImpl<UgvOperation,Timestamp> implements OperationDAO {
  
}
