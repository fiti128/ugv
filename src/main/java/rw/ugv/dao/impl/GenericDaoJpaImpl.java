package rw.ugv.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import rw.ugv.dao.GenericDAO;

@Named
public abstract class GenericDaoJpaImpl<T,PK extends Serializable> implements GenericDAO<T,PK> {
	
	@PersistenceContext(unitName = "sample",type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDaoJpaImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
        .getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
        .getActualTypeArguments()[0];
	}
	
	@Override
	public void create(T t) {
		entityManager.persist(t);
	}

	@Override
	public T update(T t) {
		return entityManager.merge(t);
	}

	@Override
	public T read(PK pk) {
		return entityManager.find(entityClass, pk);
	}

	@Override
	public void delete(T t) {
		t = this.entityManager.merge(t);
		entityManager.remove(t);
	}
	
	@Override
	public List<T> pagination(int firstResult, int maxResults, String fieldName, boolean ascending) {
		// Создаем ч
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(entityClass);
		Root<T> rootFrom = query.from(entityClass);
		query = query.select(rootFrom);
		if (fieldName != null) {
			query = query.orderBy(ascending ? cb.asc(rootFrom.get(fieldName)) : cb.desc(rootFrom.get(fieldName)));
		}
		TypedQuery<T> entityQuery = entityManager.createQuery(query);
		entityQuery.setFirstResult(firstResult);
		entityQuery.setMaxResults(maxResults);
		List<T> list = entityQuery.getResultList();
		return list;
	}

	
}
