package rw.obd.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class Text extends ResourceBundle {

    protected static final String BUNDLE_NAME = "rw.obd.beans.messages";
    protected static final String BUNDLE_EXTENSION = "properties";
    protected static final String CHARSET = "UTF-8";
    protected static final Control UTF8_CONTROL = new UTF8Control();
    private Properties props;
    public Text() throws UnsupportedEncodingException, FileNotFoundException, IOException {
//    	System.err.println("In Text");
//    	String bundleName = BUNDLE_NAME + "_" +
//        FacesContext.getCurrentInstance().getViewRoot().getLocale().toString()+".properties";
//    	System.err.println(bundleName);
//    	PropertyResourceBundle bundle = 
//            new PropertyResourceBundle(new InputStreamReader(new FileInputStream(new File(bundleName)),CHARSET));
//    	setParent(bundle);

//    	Enumeration<String> list = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "rw.odb.beans.Text").getKeys();
//		while(list.hasMoreElements()) {
//			System.err.print(list.nextElement() + ",");
//		}
    	System.err.println("In Text");
    	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	System.err.println(locale.toString());
    	InputStream is = getClass().getResourceAsStream("message_ru.properties");
//    	int a;
//    	while ((a=is.read()) > 0){
//    		System.err.print((char)a);
//    	}
    	ResourceBundle bundle = new PropertyResourceBundle(new InputStreamReader(is, CHARSET));
//    	ResourceBundle bundle = getBundle("rw.obd.beans.text",locale, new UTF8Control());
    	System.err.print(bundle.getString("heading"));
    	setParent(bundle);
    	System.err.print("In Text2");
    }
//    public Text(InputStream stream) throws IOException {
//    	System.err.print("In Text constructor(stream)");
//    	props = new Properties();
//    	props.load(stream);
//    }

    @Override
    protected Object handleGetObject(String key) {
    	Object obj = parent.getObject(key);
    	System.err.println("Key = " + key + "Object = " + obj.toString());
        return obj;
    }

    
	@Override
    public Enumeration<String> getKeys() {
		Enumeration<String> list = parent.getKeys();
		while(list.hasMoreElements()) {
			System.err.print(list.nextElement() + ",");
		}
        return parent.getKeys();
    }

    protected static class UTF8Control extends Control {
    	public UTF8Control() {
    		System.err.println("In control constructor");
    	}
        public ResourceBundle newBundle
            (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException
        {
        	System.err.println("In newBundle");
            // The below code is copied from default Control#newBundle() implementation.
            // Only the PropertyResourceBundle line is changed to read the file as UTF-8.
            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, BUNDLE_EXTENSION);
            ResourceBundle bundle = null;
            InputStream stream = null;
            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        stream = connection.getInputStream();
                    }
                }
            } else {
                stream = loader.getResourceAsStream(resourceName);
            }
            if (stream != null) {
                try {
                	System.err.println("Stream != null");                 		
                	
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, CHARSET));
                } finally {
                    stream.close();
                }
            }
            return bundle;
        }
    }
}
