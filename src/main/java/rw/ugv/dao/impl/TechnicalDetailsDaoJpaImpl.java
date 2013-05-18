package rw.ugv.dao.impl;

import java.sql.Timestamp;

import javax.ejb.Stateful;

import rw.ugv.dao.TechnicalDetailsDAO;
import rw.ugv.dto.UgvTechnicalDetails;

@Stateful(name = "technicalDetailsDao")
public class TechnicalDetailsDaoJpaImpl extends GenericDaoJpaImpl<UgvTechnicalDetails, Timestamp> implements TechnicalDetailsDAO {

}
