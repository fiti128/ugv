package rw.ugv.beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;



public class MyBundle extends ResourceBundle {
	private static Logger logger = Logger.getLogger(MyBundle.class);
	private static final String UNDER_SCORE = "_";
	protected static final String BUNDLE = "message";
	protected static final String BUNDLE_EXTENSION = "properties";
	protected static final String CHARSET= "UTF-8";
	public MyBundle() throws UnsupportedEncodingException, IOException{
		
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	String bundleName = "/"+BUNDLE + UNDER_SCORE + locale.toString() +"."+ BUNDLE_EXTENSION;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		String bundleName = "/" +BUNDLE + UNDER_SCORE + "ru" + "." + BUNDLE_EXTENSION;
    	InputStream is = loader.getResource(bundleName).openStream();
    	ResourceBundle bundle = new PropertyResourceBundle(new InputStreamReader(is, CHARSET));
    	logger.debug(String.format("changing bungle to %s locale",locale.toString()));
    	setParent(bundle);
    	
	}
	
	@Override
    protected Object handleGetObject(String key) {
    	Object obj = parent.getObject(key);
        return obj;
    }

    
	@Override
    public Enumeration<String> getKeys() {
		Enumeration<String> list = parent.getKeys();
        return parent.getKeys();
    }

    
    
}
