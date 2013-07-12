package rw.ugv.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.Stateful;

import rw.ugv.dao.TechnicalDetailsDAO;
import rw.ugv.dto.UgvTechnicalDetails;

@Stateful(name = "technicalDetailsDao")
public class TechnicalDetailsDaoJpaImpl extends GenericDaoJpaImpl<UgvTechnicalDetails, Timestamp> implements TechnicalDetailsDAO,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -770758334105826473L;

}
