package rw.ugv.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "VGO")
public class UgvOperation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7251917582711374038L;



	public UgvOperation() {
		id = new Date();
	}
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "ZAP_ID", nullable = false, updatable = false)
	private Date id;
	
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "DATOP")
	private Calendar openDateInAB;
	
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "DATOP_END")
	private Calendar closingDateInAB;
	
	@Column (name = "PR_ZAP")
	private char priznakZapisi;
	
	@ManyToOne
	@JoinColumn(name = "DOC_ID")
	@Cascade(value = CascadeType.ALL)
	private UgvDocument ugvDocId;
	
	@ManyToOne
	@JoinColumn(name = "TEX_ID")
	@Cascade(value = CascadeType.ALL)
	private UgvTechnicalDetails ugvTechId;

	public UgvTechnicalDetails getUgvTechId() {
		return ugvTechId;
	}

	public void setUgvTechId(UgvTechnicalDetails ugvTechId) {
		this.ugvTechId = ugvTechId;
	}

	public Date getCreatingTime() {
		return id;
	}

	public Calendar getOpenDateInAB() {
		return openDateInAB;
	}

	public Calendar getClosingDateInAB() {
		return closingDateInAB;
	}

	public char getPriznakZapisi() {
		return priznakZapisi;
	}

	public UgvDocument getUgvDocId() {
		return ugvDocId;
	}

	public void setCreatingTime(Date creatingTime) {
		this.id = creatingTime;
	}

	public void setOpenDateInAB(Calendar openDateInAB) {
		this.openDateInAB = openDateInAB;
	}

	public void setClosingDateInAB(Calendar closingDateInAB) {
		this.closingDateInAB = closingDateInAB;
	}

	public void setPriznakZapisi(char priznakZapisi) {
		this.priznakZapisi = priznakZapisi;
	}

	public void setUgvDocId(UgvDocument ugvDocId) {
		this.ugvDocId = ugvDocId;
	}
	public Date getId() {
		return id;
	}

	public void setId(Date id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
