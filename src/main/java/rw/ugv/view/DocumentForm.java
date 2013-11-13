package rw.ugv.view;


import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Transient;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import rw.ugv.dao.StationsDAO;
import rw.ugv.dto.SpFormDoc;
import rw.ugv.dto.Stations;
import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvPrichinaDoc;
import rw.ugv.qualifiers.FormKod;
import rw.ugv.qualifiers.UgvForm;


@Named
@SessionScoped
public class DocumentForm implements Serializable {
	@Inject
	private StationsDAO stationsDao;
	
	
	
	@Inject @UgvForm
	private List<UgvPrichinaDoc> prichinaDocList;
    @Inject @UgvForm
    private List<SpFormDoc> spFormDocList;
	private static final long serialVersionUID = 1203352608230766258L;
	private Map<String, Map<String,Boolean>> map = new HashMap<String,Map<String,Boolean>> ();
	private List<String> formList;
	private List<String> prichiniList;
	
	@Column(name = "FORM")
	private String form;
	
	private String kodPrichini;
	private String kodForm;
	
	@Produces @FormKod
	public String getKodForm() {
		return kodForm;
	}
	
    private String fullNameForm="horosh";

	public void handleFormChanged(String form) {
		this.form = form;
		if (this.form != null && this.form != "") {
		SpFormDoc spFormDoc = spFormDocList.get(0);
		
            for (SpFormDoc formDoc : spFormDocList) {
            	 if (formDoc.getShortNameForm().trim().equals(form.trim())){
                    spFormDoc = formDoc;
                    break;
                }
            }

        documentNumber = intToBool(spFormDoc.getPrNomeraDocumenta());
        dataDocumenta = intToBool(spFormDoc.getPrDataDoc());
        kodPrichiniDocumenta = intToBool(spFormDoc.getPrPrichini());
        depoDocumenta = intToBool(spFormDoc.getPrDepoDoc());
        stanciaDocumenta = intToBool(spFormDoc.getPrStDoc());
        stanciaDislokacii = intToBool(spFormDoc.getPrStDislocacii());
        fullNameForm = spFormDoc.getFullNameForm();
        kodForm = spFormDoc.getKodForm();
        kodOperacii = true;
        if(kodPrichiniDocumenta) {
        	prichiniList = new ArrayList<String>();
        	for (UgvPrichinaDoc prichinaDoc : prichinaDocList) {
				prichiniList.add(prichinaDoc.getFullName().trim());
			}
        }
		}
	}
	
	public List<String> autoCompleteStations(String filter) throws Exception {
		Map<String,String> filters = new HashMap<String,String>();
		filters.put("stationName", filter);
		filters.put("stationNumber", filter);
		List<Stations> list = stationsDao.pagination(0, 10, null, false, filters);
		List<String> autoCompleteList = new ArrayList<String>();
		for (Stations station : list) {
			autoCompleteList.add(String.format("%s, %s",station.getStationNumber(),station.getStationName()));
		}
		return autoCompleteList;
	}
	public List<String> getFormList(){
		return formList;
	}
	
	public List<String> getPrichiniList() {
		return prichiniList;
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
		formList = new ArrayList<String>();
        for (SpFormDoc spFormDoc : spFormDocList) {
            formList.add(spFormDoc.getShortNameForm());
        }

	}
	
	public DocumentForm()  {
	}
    public static boolean intToBool(int input)
    {
        if (input < 0 || input > 1)
        {
            throw new UnsupportedOperationException();
        }

        // Note we designate 1 as true and 0 as false though some may disagree
        return input == 1;
    }

    public String sayHello() {
    	System.out.println("Hello");
    	return "index";
    }
    public String sayHello(UgvDocument document) {
    	System.out.println(document);
    	return "";
    }
    	
    public String getKodPrichini() {
        return kodPrichini;
    }

    public void setKodPrichini(String kodPrichini) {
        this.kodPrichini = kodPrichini;
    }

    public String getFullNameForm() {
        return fullNameForm;
    }

    public void setFullNameForm(String fullNameForm) {
        this.fullNameForm = fullNameForm;
    }

    public List<SpFormDoc> getSpFormDocList() {
        return spFormDocList;
    }

    public void setSpFormDocList(List<SpFormDoc> spFormDocList) {
        this.spFormDocList = spFormDocList;
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
