package rw.ugv.dto;


import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;



@Entity
public class UgvDocument {
	
	@Id
	@Temporal( value = TemporalType.TIMESTAMP )
	@Generated(value = GenerationTime.INSERT)
	@Column(name = "DOC_ID")
	Date creatingTime;
	String form;
	@Column(name = "N_DOC")
	String documentNumber;
	@Column(name = "D_DOC")
	String documentDate;
	public Date getCreatingTime() {
		return creatingTime;
	}
	public void setCreatingTime(Date creatingTime) {
		this.creatingTime = creatingTime;
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
	public String getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}
	
	
	
}
