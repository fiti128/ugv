package rw.ugv.view;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Main implements Serializable {
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
	  
}
