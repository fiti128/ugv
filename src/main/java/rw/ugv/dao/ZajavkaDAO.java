package rw.ugv.dao;

import java.sql.Timestamp;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rw.ugv.dto.UgvZajavka;

public interface ZajavkaDAO extends GenericDAO<UgvZajavka,Timestamp> {

}
