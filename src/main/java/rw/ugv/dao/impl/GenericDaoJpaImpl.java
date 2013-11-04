package rw.ugv.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.PostConstruct;
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




import rw.ugv.dao.GenericDAO;
import rw.ugv.qualifiers.UgvDatabase;

//@ManagedBean
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
//@SessionScoped
//@Stateless
public class GenericDaoJpaImpl<T,PK extends Serializable> implements GenericDAO<T,PK>,Serializable {
	@Inject
	private transient Logger logger;
	/**
	 * 
	 */
	private static final long serialVersionUID = 9208010251414413491L;

	@Inject @UgvDatabase
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
//		System.err.println("rly? i am in postConstruct. Here is entityManager" + entityManagerFactory);
//		
//		System.err.println("Here is builder" + entityManagerFactory.getCriteriaBuilder());
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		

		
		
	}
	@Override
	public void create(T t) throws Exception {
//		try {
//			try {
//				userTransaction.begin();
//				EntityManager entityManager = entityManagerFactory.createEntityManager();
		logger.debug("In create. Object to persist" +t.toString());
//				entityManager.joinTransaction();
				entityManager.getTransaction().begin();
				entityManager.persist(t);
				entityManager.flush();
//				entityManager.close();
//				entityManager.getTransaction().commit();

				

//			} finally {
//				userTransaction.commit();
//			}
//		} catch (Exception e) {
//				userTransaction.rollback();
//				throw e;
//		} 
	}

	@Override
	public T update(T t) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.merge(t);
	}

	@Override
	public T read(PK pk) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(entityClass, pk);
	}

	@Override
	public void delete(T t) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		t = entityManager.merge(t);
		entityManager.remove(t);
	}
	
	@Override
	public List<T> pagination(int firstResult, int maxResults, String fieldName, boolean ascending, Map<String, String> filters) throws Exception {
//		logger.debug(String.format("EntityManagerFactory in pagination is %s", entityManagerFactory));
//		logger.debug(String.format("EntityManagerFactory.getCriteriaBuilder in pagination is %s", entityManagerFactory.getCriteriaBuilder()));
//		try {
//			try {
//				userTransaction.begin();
//				EntityManager entityManager = entityManagerFactory.createEntityManager();
//				logger.debug(String.format("User transaction status is %d", userTransaction.getStatus()));
		// Создаем ч
//				entityManager.joinTransaction();
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
		Predicate predicate = cb.or(predicates);
		query.where(predicates);
		if (fieldName != null) {
			query = query.orderBy(ascending ? cb.asc(rootFrom.get(fieldName)) : cb.desc(rootFrom.get(fieldName)));
		}
		TypedQuery<T> entityQuery = entityManager.createQuery(query);
		entityQuery.setFirstResult(firstResult);
		entityQuery.setMaxResults(maxResults);
		List<T> list = entityQuery.getResultList();
		
		return list;
//			} finally {
//				userTransaction.commit();
//			}
//		} catch (Exception e) {
//			int transactionState = userTransaction.getStatus();  
//			   if ( transactionState == javax.transaction.Status.STATUS_ACTIVE) {  
//			     userTransaction.rollback();    
//			   }  
//				throw e;
//		} 
	}
	@Override
	public long rowsNumber() {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<T> rootFrom = query.from(entityClass);
		query.select(cb.count(rootFrom));
		return entityManager.createQuery(query).getSingleResult();
		
	}
	@Override
	public long rowsNumber(String sortField, Map<String, String> filters)
			throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<T> rootFrom = query.from(entityClass);
		// Создаем массив предикейтов
		Predicate[] predicates = new Predicate[filters.size()];

		Set<Entry<String,String>> filtersEntries = filters.entrySet();
		int i = 0;
		for (Entry<String, String> entry : filtersEntries) {
			Expression<String> literal = cb.literal("%"+entry.getValue() +"%");
			predicates[i++] = cb.like(rootFrom.<String>get(entry.getKey()), literal);
		}
		query.where(predicates);
		query.select(cb.count(rootFrom));
		return entityManager.createQuery(query).getSingleResult();
		
	}

    @Override
    public List<T> getAll() throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> rootFrom = query.from(entityClass);
        TypedQuery<T> entityQuery = entityManager.createQuery(query);
        List<T> list = entityQuery.getResultList();
        return list;
    }


}
