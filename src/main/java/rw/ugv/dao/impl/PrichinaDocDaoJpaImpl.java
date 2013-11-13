package rw.ugv.dao.impl;

import rw.ugv.dao.PrichinaDocDAO;
import rw.ugv.dto.UgvPrichinaDoc;
import rw.ugv.dto.UgvPrichinaDoc_;
import rw.ugv.qualifiers.FormKod;
import rw.ugv.qualifiers.UgvDatabase;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: Siarhei Yanusheusky
 * Date: 24.10.13
 * Time: 14:44
 */
public class PrichinaDocDaoJpaImpl implements PrichinaDocDAO {
    @Inject
    private transient org.apache.log4j.Logger logger;
 
    @Inject @UgvDatabase
    protected javax.persistence.EntityManager entityManager;

    @Override
    public List<UgvPrichinaDoc> getPrichinaDocByKodForm(String kodForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UgvPrichinaDoc> query = cb.createQuery(UgvPrichinaDoc.class);
        Root<UgvPrichinaDoc> rootFrom = query.from(UgvPrichinaDoc.class);
        Predicate[] predicates = new Predicate[1];
        Expression<String> literal = cb.literal(kodForm);
        predicates[0] = cb.like(rootFrom.<String>get(UgvPrichinaDoc_.kodForm), literal);
        query.where(predicates);
        TypedQuery<UgvPrichinaDoc> entityQuery = entityManager.createQuery(query);

        List<UgvPrichinaDoc> list = entityQuery.getResultList();
        return list;
    }
}
