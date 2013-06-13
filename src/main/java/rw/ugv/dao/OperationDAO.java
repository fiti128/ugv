package rw.ugv.dao;

import java.sql.Timestamp;

import javax.inject.Named;

import rw.ugv.dto.UgvOperation;

@Named(value="operationDao")
public interface OperationDAO extends GenericDAO<UgvOperation,Timestamp>{
	
}
