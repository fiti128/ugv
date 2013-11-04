package rw.ugv.dao.impl;

import javax.ejb.Stateless;

import rw.ugv.dao.SpFormDocDAO;
import rw.ugv.dto.SpFormDoc;

/**
 * User: Siarhei Yanusheusky
 * Date: 23.10.13
 * Time: 13:29
 */
@Stateless(name = "spFormDao")
public class SpFormDocDaoJpaImpl extends GenericDaoJpaImpl<SpFormDoc,String> implements SpFormDocDAO {
}
