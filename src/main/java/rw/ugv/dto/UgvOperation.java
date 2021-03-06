package rw.ugv.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@ManagedBean(name="operation")
@ViewScoped
@Entity
@Table(name = "VGO", schema="UGVSCH")
public class UgvOperation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7251917582711374038L;



	public UgvOperation() {
		id = new Date();
	}
	/**
	 * Дата и время записи документа
	 */
	@ManyToOne
	@JoinColumn(name = "DOC_ID")
	@Cascade(value = CascadeType.ALL)
	private UgvDocument ugvDocId;
	
	/**
	 * Дата и время записи о технических характеристиках
	 */
	@ManyToOne
	@JoinColumn(name = "TEX_ID")
	@Cascade(value = CascadeType.ALL)
	private UgvTechnicalDetails ugvTechId;
	
	/**
	 * Дата и время записи заявки
	 */
	@ManyToOne
	@JoinColumn(name = "ZAJAV_ID")
	@Cascade(value = CascadeType.ALL)
	private UgvZajavka ugvZajavkaId;
	
	/**
	 * Дата и время записи учетной операции
	 */
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "ZAP_ID", nullable = false, updatable = false)
	private Date id;
	
	/**
	 * Дата и время регистрации операции в АБДПВ
	 */
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "DATOP")
	private Calendar openDateInAB;
	
	/**
	 * Дата закрытия операции
	 */
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "DATOP_END")
	private Calendar closingDateInAB;
	
	/**
	 * Признак состояния записи
	 */
	@Max(value=1)
	@Column (name = "PR_ZAP")
	private String priznakZapisi;
	
	/**
	 * Код операции
	 */
	@Column (name = "KOP")
	private String kodVGO;
	
	/**
	 * Код парной операции
	 */
	@Column (name = "KPAROP")
	private String kodParnojOperacii;
	
	/**
	 * Дата регистрации парной операции
	 */
	@Column (name = "DATPAROP")
	private Calendar dataRegistraciiParnojOperacii;
	
	/**
	 * Связный номер вагона
	 */
	@Column (name = "SNV")
	private String sviaznojNomerVagona;
	
	/**
	 * Код государства собственника
	 */
	@Column (name = "SOB")
	private String kodGosudarstvaSobstvennika;
	
	/**
	 * Код нового государства собственника
	 */
	@Column (name = "NSOB")
	private String kodNovogiGosudarstvaSobstvennika;


	public UgvDocument getUgvDocId() {
		return ugvDocId;
	}


	public void setUgvDocId(UgvDocument ugvDocId) {
		this.ugvDocId = ugvDocId;
	}


	public UgvTechnicalDetails getUgvTechId() {
		return ugvTechId;
	}


	public void setUgvTechId(UgvTechnicalDetails ugvTechId) {
		this.ugvTechId = ugvTechId;
	}


	public UgvZajavka getUgvZajavkaId() {
		return ugvZajavkaId;
	}


	public void setUgvZajavkaId(UgvZajavka ugvZajavkaId) {
		this.ugvZajavkaId = ugvZajavkaId;
	}


	public Date getId() {
		return id;
	}


	public void setId(Date id) {
		this.id = id;
	}


	public Calendar getOpenDateInAB() {
		return openDateInAB;
	}


	public void setOpenDateInAB(Calendar openDateInAB) {
		this.openDateInAB = openDateInAB;
	}


	public Calendar getClosingDateInAB() {
		return closingDateInAB;
	}


	public void setClosingDateInAB(Calendar closingDateInAB) {
		this.closingDateInAB = closingDateInAB;
	}


	public String getPriznakZapisi() {
		return priznakZapisi;
	}


	public void setPriznakZapisi(String priznakZapisi) {
		this.priznakZapisi = priznakZapisi;
	}


	public String getKodVGO() {
		return kodVGO;
	}


	public void setKodVGO(String kodVGO) {
		this.kodVGO = kodVGO;
	}


	public String getKodParnojOperacii() {
		return kodParnojOperacii;
	}


	public void setKodParnojOperacii(String kodParnojOperacii) {
		this.kodParnojOperacii = kodParnojOperacii;
	}


	public Calendar getDataRegistraciiParnojOperacii() {
		return dataRegistraciiParnojOperacii;
	}


	public void setDataRegistraciiParnojOperacii(
			Calendar dataRegistraciiParnojOperacii) {
		this.dataRegistraciiParnojOperacii = dataRegistraciiParnojOperacii;
	}


	public String getSviaznojNomerVagona() {
		return sviaznojNomerVagona;
	}


	public void setSviaznojNomerVagona(String sviaznojNomerVagona) {
		this.sviaznojNomerVagona = sviaznojNomerVagona;
	}


	public String getKodGosudarstvaSobstvennika() {
		return kodGosudarstvaSobstvennika;
	}


	public void setKodGosudarstvaSobstvennika(String kodGosudarstvaSobstvennika) {
		this.kodGosudarstvaSobstvennika = kodGosudarstvaSobstvennika;
	}


	public String getKodNovogiGosudarstvaSobstvennika() {
		return kodNovogiGosudarstvaSobstvennika;
	}


	public void setKodNovogiGosudarstvaSobstvennika(
			String kodNovogiGosudarstvaSobstvennika) {
		this.kodNovogiGosudarstvaSobstvennika = kodNovogiGosudarstvaSobstvennika;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "UgvOperation [openDateInAB=" + openDateInAB
				+ ", closingDateInAB=" + closingDateInAB + ", priznakZapisi="
				+ priznakZapisi + "]";
	}
	
}
