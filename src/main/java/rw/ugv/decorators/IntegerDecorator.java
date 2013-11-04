package rw.ugv.decorators;

import java.util.List;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import rw.ugv.dao.PrichinaDocDAO;
import rw.ugv.dao.SpFormDocDAO;
import rw.ugv.dto.SpFormDoc;

/**
 * User: Siarhei Yanusheusky
 * Date: 25.10.13
 * Time: 8:51
 */
@Decorator
public abstract class IntegerDecorator   {
	
	
	@Inject
	@Delegate
	@Any
	SpFormDocDAO spFormDocDao;

	
	public List<SpFormDoc> getAll() throws Exception {
		System.err.println("Hello from decorator");
//		List<SpFormDoc> list = spFormDocDao.getAll();
//		if (list != null && list.size() > 1) {
//			
//			SpFormDoc sp = new SpFormDoc();
//			sp.setShortNameForm("Вуаля");
//			list.add(sp);
//		}
		return spFormDocDao.getAll();
	}
	
	
}
