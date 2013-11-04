package rw.ugv.factories;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import rw.ugv.dao.PrichinaDocDAO;
import rw.ugv.dao.SpFormDocDAO;
import rw.ugv.dto.SpFormDoc;
import rw.ugv.dto.UgvPrichinaDoc;
import rw.ugv.qualifiers.FormKod;
import rw.ugv.qualifiers.UgvForm;

/**
 * User: Siarhei Yanusheusky
 * Date: 23.10.13
 * Time: 13:34
 */
@ApplicationScoped
public class FormFactory {
    @Inject
    private transient org.apache.log4j.Logger logger;

    @Inject
    Event<SpFormDocDAO> spFormDaoEvent;
    
    @Inject
    private SpFormDocDAO spFormDao;
    
    @Inject
    private PrichinaDocDAO prichinaDocDao;


    @Produces @UgvForm
    @RequestScoped
    public java.util.List<SpFormDoc> getSpForms() throws Exception {
        logger.debug("Producing SpForms");
        spFormDaoEvent.fire(spFormDao);
        return spFormDao.getAll();
    }

    @Produces @UgvForm
    @RequestScoped
    public java.util.List<UgvPrichinaDoc> getPrichinaDocList(@FormKod String formKod) throws Exception {
    
        
        List<UgvPrichinaDoc> list = prichinaDocDao.getPrichinaDocByKodForm(formKod);
        for (UgvPrichinaDoc ugvPrichinaDoc : list) {
			logger.debug(ugvPrichinaDoc);
        	
		}
        return list;
    }
    
}
