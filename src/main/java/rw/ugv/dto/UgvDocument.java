package rw.ugv.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author ircm_yanusheusky
 *
 */
@Entity
@Table(name="DOC", schema="UGV")
public class UgvDocument implements Serializable, Cloneable {
	

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
	@Column(name = "ID_DOC", nullable = false, updatable = false) 
    private Date id;
	
	@OneToMany(mappedBy = "ugvDocId")
	private List<UgvOperation> operationList;
	
	/**
	 * Форма документа
	 */
	@Column(name = "FORM_DOC")
	private String form;
	
	/**
	 * Номер документа
	 */
	@Column(name = "NUM_DOC")
	private String documentNumber;
	
	/**
	 * Дата составления документа
	 */
	@Column(name = "DATA_DOC")
	private Date documentDate;

	/**
	 * Код причины составления документа
	 */
	@Column(name = "KOD_PRICHINA")
	private String kodPrichiniDocumenta;

	/**
	 * Депо составитель документа
	 */
	@Column(name = "DEPO_DOC")
	private String depoDocumenta;

	/**
	 * Станция составитель документа
	 */
	@Column(name = "ST_DOC")
	private String stanciaDocumenta;

	/**
	 * Станция дислокации
	 */
	@Column(name = "ST_DISLOKACII")
	private String stanciaDislokacii;

	/**
	 * Код операции
	 */
	@Column(name = "KOD_OP")
	private String kodOperacii;
	
	/**
	 * Статус документа
	 */
	@Column(name = "STATUS_DOC")
	private String statusDoc;



	public Date getId() {
		return id;
	}
	public void setId(Date id) {
		this.id = id;
	}

    @Override
    public UgvDocument clone() throws CloneNotSupportedException {
        return (UgvDocument)super.clone();
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
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	
	
	public List<UgvOperation> getOperationList() {
		return operationList;
	}
	public void setOperationList(List<UgvOperation> operationList) {
		this.operationList = operationList;
	}
	
	
	public String getStatusDoc() {
		return statusDoc;
	}
	public void setStatusDoc(String statusDoc) {
		this.statusDoc = statusDoc;
	}
	@Override
	public String toString() {
		return "UgvDocument [id=" + id + ", form=" + form + ", documentNumber="
				+ documentNumber + "]";
	}
	
	
	
	
	
}
