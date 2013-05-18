package rw.ugv.dao.impl;

import java.sql.Timestamp;

import javax.ejb.Stateful;

import rw.ugv.dao.DocumentDAO;
import rw.ugv.dto.UgvDocument;

@Stateful(name = "documentDao")
public class DocumentDaoJpaImpl extends GenericDaoJpaImpl<UgvDocument,Timestamp> implements
		DocumentDAO {

}
