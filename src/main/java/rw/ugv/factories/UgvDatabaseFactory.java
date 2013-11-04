package rw.ugv.factories;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;

import rw.ugv.qualifiers.UgvDatabase;

@ApplicationScoped
public class UgvDatabaseFactory {
	@Inject
	private transient Logger logger;
	
	@PersistenceUnit(name="ugv")
	private EntityManagerFactory entityManagerFactory;

	@Produces @UgvDatabase @RequestScoped
	public EntityManager getEntityManager() {
		logger.debug("Producing ugvDatabase EntityManager");
		return entityManagerFactory.createEntityManager();
	}
	
}
