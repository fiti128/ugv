package rw.ugv.dao;

import java.sql.Timestamp;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rw.ugv.dto.UgvTechnicalDetails;

public interface TechnicalDetailsDAO extends GenericDAO<UgvTechnicalDetails,Timestamp> {

}
