package rw.ugv.dao.impl;


import java.sql.Timestamp;

import javax.ejb.Stateful;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvOperation;


@Stateful(name="operationDao")
public class OperationDaoJpaImpl extends GenericDaoJpaImpl<UgvOperation,Timestamp> implements OperationDAO {

}
