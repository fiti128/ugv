package rw.ugv.view;

import java.io.Serializable;
import java.util.Locale;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@SessionScoped
public class Main implements Serializable {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -6709742530902495376L;
	private String firstname;
	  public String viewDocument() {  
	        return "dialog:document";  
	    }
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String changeToEng() {
		logger.debug("changing locale to eng");
		logger.debug(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
		logger.debug(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		System.out.println("changed locale to eng");
		return null;
	}
	public String changeToRus() {
		logger.debug("changing locale to rus");
		logger.debug(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("ru"));
		logger.debug(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		logger.debug("changed locale to rus");
		return null;
	}
	public String sayHiToConsole() {
		logger.debug(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		logger.debug("Hi console");
		return null;
	}
	
}
