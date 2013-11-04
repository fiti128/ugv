package rw.ugv.events;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import rw.ugv.dao.SpFormDocDAO;

/**
 * User: Siarhei Yanusheusky
 * Date: 25.10.13
 * Time: 8:19
 */
public class HelloEvent {
	@Inject
	private transient Logger logger;
	
    public void onAnyFormFactoryEnect(@Observes SpFormDocDAO spFormDao) {
    	Integer i = new Integer(5);
    	logger.info("Hello my first event\n"+i.toString());
    }
}
