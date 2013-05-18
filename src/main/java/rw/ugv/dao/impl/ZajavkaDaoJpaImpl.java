package rw.ugv.dao.impl;

import java.sql.Timestamp;

import javax.ejb.Stateful;

import rw.ugv.dao.ZajavkaDAO;
import rw.ugv.dto.UgvZajavka;

@Stateful(name = "zajavkaDao")
public class ZajavkaDaoJpaImpl extends GenericDaoJpaImpl<UgvZajavka, Timestamp> implements
		ZajavkaDAO {
}
