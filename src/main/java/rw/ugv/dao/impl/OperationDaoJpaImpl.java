package rw.ugv.dao.impl;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.apache.log4j.Logger;

import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvDocument_;
import rw.ugv.dto.UgvOperation;
import rw.ugv.dto.UgvOperation_;
import rw.ugv.qualifiers.UgvDatabase;


@Stateless(name = "operationDao")
public class OperationDaoJpaImpl extends GenericDaoJpaImpl<UgvOperation,Timestamp> implements OperationDAO, Serializable {

	@Inject
	private transient Logger logger;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8046489267741149158L;

	@Inject @UgvDatabase
	protected EntityManager entityManager;
	
	@Override
	public List<UgvOperation> docDependentPagination(UgvDocument ugvDocument,
			int first, int pageSize, String sortField, boolean ascending,
			Map<String, String> filters) {
		logger.debug(String.format("In OperationDaoJpaImpl docDependenPagination. Document is %s", ugvDocument.toString()));
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UgvOperation> query = cb.createQuery(entityClass);
		Root<UgvOperation> rootFrom = query.from(entityClass);
		
		// Создаем массив предикейтов
		Predicate[] predicates = new Predicate[filters.size()+1];
		EntityType<UgvOperation> type = entityManager.getMetamodel().entity(entityClass);
		Set<Entry<String,String>> filtersEntries = filters.entrySet();
		int i = 0;
		for (Entry<String, String> entry : filtersEntries) {
			Expression<String> literal = cb.literal("%"+entry.getValue() +"%");
//			predicates[i++] = cb.like(rootFrom.get(
//					type.getDeclaredSingularAttribute(
//							entry.getKey(),String.class)), literal);
			predicates[i++] = cb.like(rootFrom.<String>get(entry.getKey()), literal);
		}
//		query.select(rootFrom);
//		Root<UgvDocument> docRoot = query.from(UgvDocument.class);
		predicates[filters.size()] = cb.equal(rootFrom.get("ugvDocId"), ugvDocument.getId());
		query.where(predicates);
		if (sortField != null) {
			query = query.orderBy(ascending ? cb.asc(rootFrom.get(sortField)) : cb.desc(rootFrom.get(sortField)));
		}
		TypedQuery<UgvOperation> entityQuery = entityManager.createQuery(query);
		entityQuery.setFirstResult(first);
		entityQuery.setMaxResults(pageSize);
		List<UgvOperation> list = entityQuery.getResultList();
		
		return list;
	}

	@Override
	public long rowsNumber(UgvDocument ugvDocument, String sortField,
			Map<String, String> filters) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<UgvOperation> rootFrom = query.from(entityClass);
		// Создаем массив предикейтов
		Predicate[] predicates = new Predicate[filters.size()+1];
//		EntityType<UgvOperation> type = entityManager.getMetamodel().entity(entityClass);
		Set<Entry<String,String>> filtersEntries = filters.entrySet();
		int i = 0;
		for (Entry<String, String> entry : filtersEntries) {
			Expression<String> literal = cb.literal("%"+entry.getValue() +"%");
			predicates[i++] = cb.like(rootFrom.<String>get(entry.getKey()), literal);
		}
		
		predicates[filters.size()] = cb.equal(rootFrom.get(UgvOperation_.ugvDocId), ugvDocument.getId());
		query.where(predicates);
		query.select(cb.count(rootFrom));
		
//		SetJoin<UgvDocument,UgvOperation> setJoin = rootFrom.join
		return entityManager.createQuery(query).getSingleResult();
	
	}
  
}
