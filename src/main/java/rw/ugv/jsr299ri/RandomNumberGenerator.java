package rw.ugv.jsr299ri;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class RandomNumberGenerator {
private Random random;

@PostConstruct
public void  onConstruct() {
	random = new Random(System.currentTimeMillis());
}
@Produces
@Named
public int getRandomNumber() {
	return random.nextInt(100);
}
	
}
