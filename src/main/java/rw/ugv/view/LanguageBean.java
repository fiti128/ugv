package rw.ugv.view;
import java.io.Serializable;

import java.util.Locale;

 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

 
@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable{
 
	/**
	 * 
	 */
	@PersistenceContext(unitName="sample")
	private EntityManager entityManager;
	private static final long serialVersionUID = 8073730549184420714L;
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        System.err.println(entityManager);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
 
}