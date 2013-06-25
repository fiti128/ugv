package rw.ugv.dto;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean(name="document")
@ViewScoped
@Entity
@Table(name="DOC", schema="UGVSCH")
public class UgvDocument implements Serializable {
	

	public UgvDocument() {
		id = new Date();
	}
	private static final long serialVersionUID = -6682900294284156242L;
	

	
	/**
	 * Дата и время записи документа. 
	 * <p>Первичный ключ
	 */
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column(name = "DOC_ID", nullable = false, updatable = false) 
    private Date id;
	
	/**
	 * Форма документа
	 */
	@Column(name = "FORM")
	private String form;
	
	/**
	 * Номер документа
	 */
	@Column(name = "N_DOC")
	private String documentNumber;
	
	/**
	 * Дата составления документа
	 */
	@Column(name = "D_DOC")
	private Calendar documentDate;

	/**
	 * Код причины составления документа
	 */
	@Column(name = "KD_PRID")
	private String kodPrichiniDocumenta;

	/**
	 * Депо составитель документа
	 */
	@Column(name = "DEPOS")
	private String depoDocumenta;

	/**
	 * Станция составитель документа
	 */
	@Column(name = "STA")
	private String stanciaDocumenta;

	/**
	 * Станция дислокации
	 */
	@Column(name = "STDISL")
	private String stanciaDislokacii;

	/**
	 * Код операции
	 */
	@Column(name = "KOP")
	private String kodOperacii;

	public Date getCreatingTime() {
		return id;
	}
	public void setCreatingTime(Date creatingTime) {
		this.id = creatingTime;
	}

	public String getKodPrichiniDocumenta() {
		return kodPrichiniDocumenta;
	}
	public void setKodPrichiniDocumenta(String kodPrichiniDocumenta) {
		this.kodPrichiniDocumenta = kodPrichiniDocumenta;
	}
	public String getDepoDocumenta() {
		return depoDocumenta;
	}
	public void setDepoDocumenta(String depoDocumenta) {
		this.depoDocumenta = depoDocumenta;
	}
	public String getStanciaDocumenta() {
		return stanciaDocumenta;
	}
	public void setStanciaDocumenta(String stanciaDocumenta) {
		this.stanciaDocumenta = stanciaDocumenta;
	}
	public String getStanciaDislokacii() {
		return stanciaDislokacii;
	}
	public void setStanciaDislokacii(String stanciaDislokacii) {
		this.stanciaDislokacii = stanciaDislokacii;
	}
	public String getKodOperacii() {
		return kodOperacii;
	}
	public void setKodOperacii(String kodOperacii) {
		this.kodOperacii = kodOperacii;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public Calendar getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Calendar documentDate) {
		this.documentDate = documentDate;
	}
	
	
	
	
}
