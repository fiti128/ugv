package rw.ugv.jsr299ri;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;






@ApplicationScoped
public class RandomNumberGenerator {
private Random random;
private EntityManagerFactory entityManagerFactory;

@PostConstruct
public void  onConstruct() {
	random = new Random(System.currentTimeMillis());
	entityManagerFactory = Persistence.createEntityManagerFactory("sample");
}
@Produces
@Named
public int getRandomNumber() {
	return random.nextInt(100);
}

@Produces
public EntityManager getEntityManager() {
	return entityManagerFactory.createEntityManager();
}

}
