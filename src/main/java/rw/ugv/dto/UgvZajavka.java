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

@ManagedBean(name="zajavka")
@ViewScoped
@Entity
@Table(name = "ZAJAV", schema="UGV")
public class UgvZajavka implements Serializable {

	private static final long serialVersionUID = 8111608703615462876L;
	public UgvZajavka() {
		id = new Date();
	}
	
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "ID_ZAJAV", nullable = false, updatable = false)
	private Date id;
	
	/**
	 * Форма заявки
	 */
	@Column(name = "FORM_ZAJAV")
	private String zajavkaForm;
	
	/**
	 * Номер заявки
	 */
	@Column(name = "NUM_ZAJAV")
	private String zajavkaNomer;
	
	/**
	 * Дата составления заявки
	 */
	@Column(name = "DATA_ZAJAV")
	private Calendar zajavkaDate;

	/**
	 * Код причины составления заявки
	 */
	@Column(name = "KOD_PRICHINA_ZAJAV")
	private String kodPrichiniZajavki;

	/**
	 * Код операции 
	 */
	@Column(name = "KOD_OP")
	private String kodOperacii;
	
	/**
	 * Код операции 
	 */
	@Column(name = "STATUS_ZAJAV")
	private String statusZajavki;

	
	public Date getId() {
		return id;
	}
	public void setId(Date id) {
		this.id = id;
	}



	public String getZajavkaForm() {
		return zajavkaForm;
	}

	public void setZajavkaForm(String zajavkaForm) {
		this.zajavkaForm = zajavkaForm;
	}

	public String getZajavkaNomer() {
		return zajavkaNomer;
	}

	public void setZajavkaNomer(String zajavkaNomer) {
		this.zajavkaNomer = zajavkaNomer;
	}

	public Calendar getZajavkaDate() {
		return zajavkaDate;
	}

	public void setZajavkaDate(Calendar zajavkaDate) {
		this.zajavkaDate = zajavkaDate;
	}

	public String getKodPrichiniZajavki() {
		return kodPrichiniZajavki;
	}

	public void setKodPrichiniZajavki(String kodPrichiniZajavki) {
		this.kodPrichiniZajavki = kodPrichiniZajavki;
	}

	public String getKodOperacii() {
		return kodOperacii;
	}

	public void setKodOperacii(String kodOperacii) {
		this.kodOperacii = kodOperacii;
	}
	public String getStatusZajavki() {
		return statusZajavki;
	}
	public void setStatusZajavki(String statusZajavki) {
		this.statusZajavki = statusZajavki;
	}
	@Override
	public String toString() {
		return "UgvZajavka [zajavkaForm=" + zajavkaForm + ", zajavkaNomer="
				+ zajavkaNomer + ", zajavkaDate=" + zajavkaDate + "]";
	}
	
	
}
