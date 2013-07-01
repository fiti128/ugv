package rw.ugv.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import rw.ugv.dao.GenericDAO;


public abstract class GenericDaoJpaImpl<T,PK extends Serializable> implements GenericDAO<T,PK> {
	
	@PersistenceContext(unitName="sample")
	protected EntityManager entityManager;
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDaoJpaImpl() {
//		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("sample");
//		entityManager = entityFactory.createEntityManager();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
        .getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
        .getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init() {
		System.err.println("rly? i am in postConstruct");
		
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
	public List<T> pagination(int firstResult, int maxResults, String fieldName, boolean ascending, Map<String, String> filters) {
		// Создаем ч
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(entityClass);
		Root<T> rootFrom = query.from(entityClass);
		// Создаем массив предикейтов
		Predicate[] predicates = new Predicate[filters.size()];
		EntityType<T> type = entityManager.getMetamodel().entity(entityClass);
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
		query.where(predicates);
		if (fieldName != null) {
			query = query.orderBy(ascending ? cb.asc(rootFrom.get(fieldName)) : cb.desc(rootFrom.get(fieldName)));
		}
		TypedQuery<T> entityQuery = entityManager.createQuery(query);
		entityQuery.setFirstResult(firstResult);
		entityQuery.setMaxResults(maxResults);
		List<T> list = entityQuery.getResultList();
		return list;
	}
	@Override
	public long rowsNumber() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<T> rootFrom = query.from(entityClass);
		query.select(cb.count(rootFrom));
		return entityManager.createQuery(query).getSingleResult();
		
	}
	
	

	
}
