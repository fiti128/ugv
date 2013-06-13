package rw.ugv.view;


import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Transient;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


@ManagedBean
@ViewScoped
public class DocumentForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1203352608230766258L;
	private Map<String,Map<String,Boolean>> map = new HashMap<String,Map<String,Boolean>> ();
	
	@Column(name = "FORM")
	private String form;

	public void handleFormChanged(String form) {
		this.form = form;
		if (this.form != null && this.form != "") {
		Map<String,Boolean> rendList = map.get(form);
		documentNumber = rendList.get("documentNumber");
		dataDocumenta = rendList.get("dataDocumenta");
		kodPrichiniDocumenta = rendList.get("kodPrichiniDocumenta");
		depoDocumenta = rendList.get("depoDocumenta");
		stanciaDocumenta = rendList.get("stanciaDocumenta");
		stanciaDislokacii = rendList.get("stanciaDislokacii");
		kodOperacii = rendList.get("kodOperacii");
		}
	}
	public List<String> getFormList(){
		return new ArrayList<String>(map.keySet());
	}
	@Transient
	private boolean documentNumber=false;
	@Transient
	private boolean dataDocumenta=true;
	@Transient
	private boolean kodPrichiniDocumenta;
	@Transient
	private boolean depoDocumenta;
	@Transient
	private boolean stanciaDocumenta;
	@Transient
	private boolean stanciaDislokacii;
	@Transient
	private boolean kodOperacii;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void init()  {
		ObjectMapper mapper = new ObjectMapper();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("forms.json");

		Map<String, Map<String, Boolean>> jsonMap;
		try {
			jsonMap = (Map<String, Map<String, Boolean>>)mapper.readValue(url, Map.class);
			map = jsonMap;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DocumentForm()  {
	}
	
	
	public Map<String, Map<String, Boolean>> getMap() {
		return map;
	}
	public void setMap(Map<String, Map<String, Boolean>> map) {
		this.map = map;
	}
	public boolean isDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(boolean documentNumber) {
		this.documentNumber = documentNumber;
	}
	public boolean isDataDocumenta() {
		return dataDocumenta;
	}
	public void setDataDocumenta(boolean dataDocumenta) {
		this.dataDocumenta = dataDocumenta;
	}
	public boolean isKodPrichiniDocumenta() {
		return kodPrichiniDocumenta;
	}
	public void setKodPrichiniDocumenta(boolean kodPrichiniDocumenta) {
		this.kodPrichiniDocumenta = kodPrichiniDocumenta;
	}
	public boolean isDepoDocumenta() {
		return depoDocumenta;
	}
	public void setDepoDocumenta(boolean depoDocumenta) {
		this.depoDocumenta = depoDocumenta;
	}
	public boolean isStanciaDocumenta() {
		return stanciaDocumenta;
	}
	public void setStanciaDocumenta(boolean stanciaDocumenta) {
		this.stanciaDocumenta = stanciaDocumenta;
	}
	public boolean isStanciaDislokacii() {
		return stanciaDislokacii;
	}
	public void setStanciaDislokacii(boolean stanciaDislokacii) {
		this.stanciaDislokacii = stanciaDislokacii;
	}
	public boolean isKodOperacii() {
		return kodOperacii;
	}
	public void setKodOperacii(boolean kodOperacii) {
		this.kodOperacii = kodOperacii;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	
}
