package rw.ugv.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
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
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		DocumentForm df = new DocumentForm();
//		File file = new File("file.txt");
//		System.out.println(file.getAbsolutePath());
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		oos.writeObject(df);
////		if (file.isFile()) {
////			file.delete();
////		}
//	}
	public void handleFormChanged() {
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
	
	public DocumentForm(String form) {
		this.form = form;
		Map<String,Boolean> vp47 = new HashMap<String,Boolean>();
		vp47.put("documentNumber", true);
		vp47.put("dataDocumenta", true);
		vp47.put("kodPrichiniDocumenta", true);
		vp47.put("depoDocumenta", true);
		vp47.put("stanciaDocumenta", true);
		vp47.put("stanciaDislokacii", true);
		vp47.put("kodOperacii", true);
		
		Map<String,Boolean> vp4 = new HashMap<String,Boolean>();
		vp4.put("documentNumber", false);
		vp4.put("dataDocumenta", false);
		vp4.put("kodPrichiniDocumenta", false);
		vp4.put("depoDocumenta", true);
		vp4.put("stanciaDocumenta", true);
		vp4.put("stanciaDislokacii", true);
		vp4.put("kodOperacii", true);
		
		Map<String,Boolean> vp10 = new HashMap<String,Boolean>();
		vp10.put("documentNumber", true);
		vp10.put("dataDocumenta", true);
		vp10.put("kodPrichiniDocumenta", true);
		vp10.put("depoDocumenta", true);
		vp10.put("stanciaDocumenta", false);
		vp10.put("stanciaDislokacii", false);
		vp10.put("kodOperacii", false);

		map.put("vp47", vp47);
		map.put("vp4", vp4);
		map.put("vp10", vp10);
		
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
