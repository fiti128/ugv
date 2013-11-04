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
import javax.validation.constraints.Max;

@ManagedBean(name="techDetails")
@ViewScoped
@Entity
@Table(name="VAGON", schema="UGV")
public class UgvTechnicalDetails implements Serializable {

	private static final long serialVersionUID = 2539410460467753351L;
	
	/**  
	 * Дата и время записи технической характеристики (первичный ключ)
	 */
	public UgvTechnicalDetails() {
		id = new Date();
	}
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column(name = "ID_VAGON", nullable = false, updatable = false) 
    private Date id;
	
	/**  
	 *  Номер вагона
	 */
	@Column(name = "NV")
	private String wagonNumber;
	
	/**  
	 *  Дата постройки
	 */
	@Column(name = "DATA_POSTROIKI")
	private String dataPostroiki;
	
	/**  
	 *  Код железнодорожной администрации
	 */
	@Column(name = "KOD_GD_ADMINISTRACII")
	private String kodDorozhAdministr;
		
	
	/** 
	 * 	Дорога приписки вагона
	 */
	@Column(name = "DOR_PRIPISKI_VAG")
	private String dorogaPripiski;
		
	/** 
	 * 	Станция приписки вагона
	 */
	@Column(name = "ST_PRIPISKI_VAG")
	private String stanciaPripiski;
	
	/** 
	 * 	Полигон обращения вагона
	 */
	@Column(name = "POLIGON")
	private String poligonWagona;
	
	/** 
	 * 	Код завода постройки
	 */
	@Column(name = "KOD_ZAVOD_POSTROIKI")
	private String kodZavoda;
	
	/** 
	 * 	Заводской номер постройки
	 */
	@Column(name = "ZAVOD_NV")
	private String zavNomerWagona;
	
	/** 
	 * 	Тип вагона расчетный
	 */
	@Column(name = "TIP_VAG_RASCHETNYI")
	private String tipWagona;
	
	/** 
	 * 	Тип вагона из документа
	 */
	@Column(name = "TIP_VAG_DOC")
	private String tipWagonaIzDoc;
	
	/**  
	 *  Идентификационный номер модели
	 */
	@Column(name = "ID_MODEL")
	private String idModeliWagona;
	
	/** 
	 *   Модель вагона из паспорта
	 */
	@Column(name = "MODEL")
	private String modelWagonaIzPasporta;
	
	/** 
	 * 	Модель вагона из справочника
	 */
	@Column(name = "MODEL_SPRAVOCHN")
	private String modelWagonaIzSpravochnika;
	
	/**  
	 * 	Технические условия
	 */
	@Column(name = "TEHNICH_USLOVIE")
	private String techUslovia;
	
	/** 
	 * 	Тара вагона
	 */
	@Column(name = "TARA_VAG")
	private String taraWagona;
	
	/** 
	 *   Грузоподъемность
	 */
	@Column(name = "GRUZOPOD")
	private String gruzopodjemnost;
	
	
	/** 
	 * 	Длина по осям автоцепок
	 */
	@Column(name = "DLINA_AVTOSCEP")
	private String dlinaPoOsiamAvtocepok;
	
	/** 
	 *  	Габарит
	 */
	@Max(value=1)
	@Column(name = "GABARIT")
	private String gabarit;
	
	/** 
	 * 	Материал обшивки кузова
	 */
	@Column(name = "MATERIAL_OBSHIV_KUZOV")
	private String materialObshivkiKuzova;
	
	/** 
	 * 	Тип воздухораспределителя
	 */
	@Max(value=1)
	@Column(name = "TIP_VOZDUHRASPRED")
	private String tipVozduharaspr;
	
	/** 
	 * 	Авторегулятор рычажной передачи
	 */
	@Max(value=1)
	@Column(name = "AUTOREGUL_PEREDACHA")
	private String avtoregulRychazchPeredachi;
	
	/** 
	 * 	Рычажная передача
	 */
	@Max(value=1)
	@Column(name = "PEREDACHA")
	private String ruchazchnPeredacha;
		
	/** 
	 * 	Авторежим
	 */
	@Max(value=1)
	@Column(name = "AUTOREGIM")
	private String avtorezchim;
	
	/** 
	 * 	Ручной тормоз
	 */
	@Max(value=1)
	@Column(name = "TORMOZ")
	private String ruchnTormoz;
	
	/** 
	 * 	Тип автосцепки
	 */
	@Max(value=1)
	@Column(name = "TIP_AVTOSCEP")
	private String tipAvtoscepki;
	
	/** 
	 * 	Тип поглащающего аппарата
	 */
	@Column(name = "TIP_APPARAT")
	private String tipPoglAparata;
	
	/** 
	 * 	Возможность постановки буферов
	 */
	@Max(value=1)
	@Column(name = "BUFFER")
	private String vozmozchnPostanovkiBuferov;
	
	/** 
	 * 	Модель тележек
	 */
	@Column(name = "MODEL_TELEG")
	private String modelTelezchek;
	
	/** 
	 * 	Подпольные усиливающие балочки
	 */
	@Max(value=1)
	@Column(name = "USIL_BALOCHKI")
	private String podpolUsilBalki;
	
	/** 
	 * 	Калибровка котла цистерны
	 */
	@Column(name = "KALIBROVKA_KOTLA_CISTERNI")
	private String kalibrovkaKotla;
	
	/** 
	 * 	Наличие сливного прибора
	 */
	@Max(value=1)
	@Column(name = "SLIVNOI_PRIBOR")
	private String slivnPribor;
	
	/** 
	 * 	Наличие рамы
	 */
	@Max(value=1)
	@Column(name = "RAMA")
	private String rama;
	
	/** 
	 * 	Конструкция котла
	 */
	@Max(value=1)
	@Column(name = "KONSTRUKCIA_KOTLA")
	private String konstrKotla;
	
	/** 
	 * 	Код СМГС1
	 */
	@Column(name = "SMGS1")
	private String kodSMGS1;
	
	/** 
	 * 	Код СМГС2
	 */
	@Column(name = "SMGS2")
	private String kodSMGS2;
	
	/** 
	 * 	Продлен ли срок службы 
	 */
	@Max(value=1)
	@Column(name = "SROK_SLUGB_PRODLEN")
	private String prodlenSrokSlyzchbiWagona;
	
	
	/** 
	 * 	Дата продления срока службы вагона
	 */
	@Column(name = "DATA_SROK_SLUGB_PRODLEN")
	private Calendar dataProdlenSrokSlyzchbiWagona;
	
	/** 
	 * 	Документ на продление срока службы
	 */
	@Column(name = "DOC_SROK_SLUGB_PRODLEN")
	private String documentProdlenSrokSlyzchbi;
	
	/** 
	 * 	Дата документа на продление срока службы
	 */
	@Column(name = "DATA_DOC_SROK_SLUGB")
	private Calendar dataDocumentaProdlenSrokSlyzchbi;
	
	/** 
	 * 	Переведен на ремонт по пробегу
	 */
	@Max(value=1)
	@Column(name = "REMONT_PROBEG")
	private String perevedenNaRemontPoProbegu;
	
	/**
	 * 	Дата перевода на ремонт по пробегу
	 */
	@Column(name = "DATA_REMONT_PROBEG")
	private Calendar dataPerevedaNaRemontPoProbegu;
	
	/** 
	 *  Документ перевода на ремонт по пробегу
	 */
	@Column(name = "DOC_REMONT_PROBEG")
	private String documentPerevedaNaRemontPoProbegu;
	
	/** 
	 * 	Дата документа перевода на ремонт по пробегу
	 */
	@Column(name = "DATA_DOC_REMONT")
	private Calendar dataDocumentaPerevedaNaRemontPoProbegu;
	
	/**
	 * 	Документ на изменение года постройки
	 */
	@Column(name = "DOC_GOD_POSTROIKI")
	private String documentNaIzmenenieGodaPostroiki;
	
	/** 
	 *  Дата документа на изменение года постройки
	 */
	@Column(name = "DATA_DOC_POSTROIKI")
	private Calendar dataDocumentaNaIzmenenieGodaPostroiki;
	
	/** 
	 * 	Дата последнего капитального ремонта
	 */
	@Column(name = "DATA_REMKAP")
	private Calendar dataKapitalnogoPoslRemonta;
	
	/** 
	 * 	Код завода или депо последнего капремонта
	 */
	@Column(name = "KOD_ZAVOD_REMKAP")
	private String kodZavodaKapitalnogoPoslRemonta;
	
	/** 
	 * 	Дата последнего деповского ремонта
	 */
	@Column(name = "DATA_REMONT")
	private Calendar dataDepoPoslRemonta;
	
	/** 
	 * 	Код депо последнего деповского ремонта
	 */
	@Column(name = "KOD_DEPO_REMONT")
	private String kodDepoPoslRemonta;
	
	/** 
	 * 	№ Проекта модернизации 1
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ1")
	private String nomerModernizacii1;
	
	/** 
	 * 	№ Проекта модернизации 2
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ2")
	private String nomerModernizacii2;
	
	/** 
	 * 	№ Проекта модернизации 3
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ3")
	private String nomerModernizacii3;
	
	/** 
	 * 	№ Проекта модернизации 4
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ4")
	private String nomerModernizacii4;
	
	/** 
	 * 	№ Проекта модернизации 5
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ5")
	private String nomerModernizacii5;
	
	/** 
	 * 	№ Проекта модернизации 6
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ6")
	private String nomerModernizacii6;
	
	/** 
	 * 	№ Проекта модернизации 7
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ7")
	private String nomerModernizacii7;
	
	/** 
	 * 	№ Проекта модернизации 8
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ8")
	private String nomerModernizacii8;
	
	/** 
	 * 	№ Проекта модернизации 9
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ9")
	private String nomerModernizacii9;
	
	/** 
	 * 	№ Проекта модернизации 10
	 */
	@Column(name = "NUM_PROEKT_MODERNIZ10")
	private String nomerModernizacii10;
	
	/** 
	 * 	Старый номер вагона
	 */
	@Column(name = "OLD_NV")
	private String nomerWagonaStarij;
	
	/** 
	 * 	Причина перенумерования
	 */
	@Max(value=1)
	@Column(name = "PRICHINA_PERENUMER")
	private String kodPerenumerovania;
	
	/** 
	 * 	Дата изъятия вагона из Единого парка
	 */
	@Column(name = "DATA_IZYATIYA_EDINYI_PARK")
	private Calendar dataIzjatiaIzEdinogoParka;
	
	/** 
	 * 	Код организации-собственницы
	 */
	@Column(name = "KOD_SOBSTV")
	private String kodSobstv;
	
	/** 
	 * 	Код организации-арендатора вагона
	 */
	@Column(name = "KOD_ARENDATOR")
	private String kodArendatoraWagona;
	
	/** 
	 * 	Станция приписки арендованного вагона
	 */
	@Column(name = "ST_PRIPISKI_AREND_VG")
	private String stanciaPripiskiArendnogoWagona;
	
	/** 
	 * 	Срок аренды
	 */
	@Column(name = "SROK_ARENDY")
	private Calendar dataOkonchaniiArendi;
	
	/**
	 	Род перевозимого груза
	 */
	@Column(name = "KOD_GRUZ")
	private String opisanieGruza;
	
	/** 
	 * 	Паспорт составленный на предприятии
	 */
	@Column(name = "PASPORT")
	private String pasportSostNaPredprijatii;
	
	/** 
	 * 	Условный код балансосодержателя
	 */
	@Column(name = "KOD_BALANS")
	private String uslKodBalansa;
	
	/** 
	 * 	Текущий вид собственности вагона
	 */
	@Max(value=1)
	@Column(name = "TEK_VID_SOBSTVENNOSTI")
	private String vidSobstvWagonaTek;
		
	/** 
	 * 	Первичный вид собственности вагона
	 */
	@Max(value=1)
	@Column(name = "PERV_VID_SOBSTVENNOSTI")
	private String vidSobstvWagonaPervichnij;
	
	/** 
	 * 	Признак нахождения вагона в Едином парке
	 */
	@Max(value=1)
	@Column(name = "PR_EDINYI_PARK")
	private String priznakNachozchdeniaWagonaVEdinomParke;
	
	/** 
	 * 	Количество непрошедших переписей
	 */
	@Max(value=1)
	@Column(name = "KOL_NEPROSHED_PEREPIS")
	private String kolNeproshedshichZapisej;

	
	// Getters and Setters...
	
	
	public Date getId() {
		return id;
	}

	public void setId(Date id) {
		this.id = id;
	}

	public String getWagonNumber() {
		return wagonNumber;
	}

	public void setWagonNumber(String wagonNumber) {
		this.wagonNumber = wagonNumber;
	}

	public String getKodDorozhAdministr() {
		return kodDorozhAdministr;
	}

	public void setKodDorozhAdministr(String kodDorozhAdministr) {
		this.kodDorozhAdministr = kodDorozhAdministr;
	}

	public String getKodSobstv() {
		return kodSobstv;
	}

	public void setKodSobstv(String kodSobstv) {
		this.kodSobstv = kodSobstv;
	}

	public String getDorogaPripiski() {
		return dorogaPripiski;
	}

	public void setDorogaPripiski(String dorogaPripiski) {
		this.dorogaPripiski = dorogaPripiski;
	}

	public String getStanciaPripiski() {
		return stanciaPripiski;
	}

	public void setStanciaPripiski(String stanciaPripiski) {
		this.stanciaPripiski = stanciaPripiski;
	}

	public String getPoligonWagona() {
		return poligonWagona;
	}

	public void setPoligonWagona(String poligonWagona) {
		this.poligonWagona = poligonWagona;
	}

	public String getKodZavoda() {
		return kodZavoda;
	}

	public void setKodZavoda(String kodZavoda) {
		this.kodZavoda = kodZavoda;
	}

	public String getZavNomerWagona() {
		return zavNomerWagona;
	}

	public void setZavNomerWagona(String zavNomerWagona) {
		this.zavNomerWagona = zavNomerWagona;
	}

	public String getTipWagona() {
		return tipWagona;
	}

	public void setTipWagona(String tipWagona) {
		this.tipWagona = tipWagona;
	}

	public String getTipWagonaIzDoc() {
		return tipWagonaIzDoc;
	}

	public void setTipWagonaIzDoc(String tipWagonaIzDoc) {
		this.tipWagonaIzDoc = tipWagonaIzDoc;
	}

	public String getIdModeliWagona() {
		return idModeliWagona;
	}

	public void setIdModeliWagona(String idModeliWagona) {
		this.idModeliWagona = idModeliWagona;
	}

	public String getModelWagonaIzPasporta() {
		return modelWagonaIzPasporta;
	}

	public void setModelWagonaIzPasporta(String modelWagonaIzPasporta) {
		this.modelWagonaIzPasporta = modelWagonaIzPasporta;
	}

	public String getModelWagonaIzSpravochnika() {
		return modelWagonaIzSpravochnika;
	}

	public void setModelWagonaIzSpravochnika(String modelWagonaIzSpravochnika) {
		this.modelWagonaIzSpravochnika = modelWagonaIzSpravochnika;
	}

	public String getTechUslovia() {
		return techUslovia;
	}

	public void setTechUslovia(String techUslovia) {
		this.techUslovia = techUslovia;
	}

	public String getTaraWagona() {
		return taraWagona;
	}

	public void setTaraWagona(String taraWagona) {
		this.taraWagona = taraWagona;
	}

	public String getGruzopodjemnost() {
		return gruzopodjemnost;
	}

	public void setGruzopodjemnost(String gruzopodjemnost) {
		this.gruzopodjemnost = gruzopodjemnost;
	}

	public String getDlinaPoOsiamAvtocepok() {
		return dlinaPoOsiamAvtocepok;
	}

	public void setDlinaPoOsiamAvtocepok(String dlinaPoOsiamAvtocepok) {
		this.dlinaPoOsiamAvtocepok = dlinaPoOsiamAvtocepok;
	}

	public String getGabarit() {
		return gabarit;
	}

	public void setGabarit(String gabarit) {
		this.gabarit = gabarit;
	}

	public String getMaterialObshivkiKuzova() {
		return materialObshivkiKuzova;
	}

	public void setMaterialObshivkiKuzova(String materialObshivkiKuzova) {
		this.materialObshivkiKuzova = materialObshivkiKuzova;
	}

	public String getTipVozduharaspr() {
		return tipVozduharaspr;
	}

	public void setTipVozduharaspr(String tipVozduharaspr) {
		this.tipVozduharaspr = tipVozduharaspr;
	}

	public String getAvtoregulRychazchPeredachi() {
		return avtoregulRychazchPeredachi;
	}

	public void setAvtoregulRychazchPeredachi(String avtoregulRychazchPeredachi) {
		this.avtoregulRychazchPeredachi = avtoregulRychazchPeredachi;
	}

	public String getRuchazchnPeredacha() {
		return ruchazchnPeredacha;
	}

	public void setRuchazchnPeredacha(String ruchazchnPeredacha) {
		this.ruchazchnPeredacha = ruchazchnPeredacha;
	}

	public String getAvtorezchim() {
		return avtorezchim;
	}

	public void setAvtorezchim(String avtorezchim) {
		this.avtorezchim = avtorezchim;
	}

	public String getRuchnTormoz() {
		return ruchnTormoz;
	}

	public void setRuchnTormoz(String ruchnTormoz) {
		this.ruchnTormoz = ruchnTormoz;
	}

	public String getTipAvtoscepki() {
		return tipAvtoscepki;
	}

	public void setTipAvtoscepki(String tipAvtoscepki) {
		this.tipAvtoscepki = tipAvtoscepki;
	}

	public String getTipPoglAparata() {
		return tipPoglAparata;
	}

	public void setTipPoglAparata(String tipPoglAparata) {
		this.tipPoglAparata = tipPoglAparata;
	}

	public String getVozmozchnPostanovkiBuferov() {
		return vozmozchnPostanovkiBuferov;
	}

	public void setVozmozchnPostanovkiBuferov(String vozmozchnPostanovkiBuferov) {
		this.vozmozchnPostanovkiBuferov = vozmozchnPostanovkiBuferov;
	}

	public String getModelTelezchek() {
		return modelTelezchek;
	}

	public void setModelTelezchek(String modelTelezchek) {
		this.modelTelezchek = modelTelezchek;
	}

	public String getPodpolUsilBalki() {
		return podpolUsilBalki;
	}

	public void setPodpolUsilBalki(String podpolUsilBalki) {
		this.podpolUsilBalki = podpolUsilBalki;
	}

	public String getKalibrovkaKotla() {
		return kalibrovkaKotla;
	}

	public void setKalibrovkaKotla(String kalibrovkaKotla) {
		this.kalibrovkaKotla = kalibrovkaKotla;
	}

	public String getSlivnPribor() {
		return slivnPribor;
	}

	public void setSlivnPribor(String slivnPribor) {
		this.slivnPribor = slivnPribor;
	}

	public String getRama() {
		return rama;
	}

	public void setRama(String rama) {
		this.rama = rama;
	}

	public String getKonstrKotla() {
		return konstrKotla;
	}

	public void setKonstrKotla(String konstrKotla) {
		this.konstrKotla = konstrKotla;
	}

	public String getKodSMGS1() {
		return kodSMGS1;
	}

	public void setKodSMGS1(String kodSMGS1) {
		this.kodSMGS1 = kodSMGS1;
	}

	public String getKodSMGS2() {
		return kodSMGS2;
	}

	public void setKodSMGS2(String kodSMGS2) {
		this.kodSMGS2 = kodSMGS2;
	}

	public String getProdlenSrokSlyzchbiWagona() {
		return prodlenSrokSlyzchbiWagona;
	}

	public void setProdlenSrokSlyzchbiWagona(String prodlenSrokSlyzchbiWagona) {
		this.prodlenSrokSlyzchbiWagona = prodlenSrokSlyzchbiWagona;
	}

	public Calendar getDataProdlenSrokSlyzchbiWagona() {
		return dataProdlenSrokSlyzchbiWagona;
	}

	public void setDataProdlenSrokSlyzchbiWagona(
			Calendar dataProdlenSrokSlyzchbiWagona) {
		this.dataProdlenSrokSlyzchbiWagona = dataProdlenSrokSlyzchbiWagona;
	}

	public String getDocumentProdlenSrokSlyzchbi() {
		return documentProdlenSrokSlyzchbi;
	}

	public void setDocumentProdlenSrokSlyzchbi(String documentProdlenSrokSlyzchbi) {
		this.documentProdlenSrokSlyzchbi = documentProdlenSrokSlyzchbi;
	}

	public Calendar getDataDocumentaProdlenSrokSlyzchbi() {
		return dataDocumentaProdlenSrokSlyzchbi;
	}

	public void setDataDocumentaProdlenSrokSlyzchbi(
			Calendar dataDocumentaProdlenSrokSlyzchbi) {
		this.dataDocumentaProdlenSrokSlyzchbi = dataDocumentaProdlenSrokSlyzchbi;
	}

	public String getPerevedenNaRemontPoProbegu() {
		return perevedenNaRemontPoProbegu;
	}

	public void setPerevedenNaRemontPoProbegu(String perevedenNaRemontPoProbegu) {
		this.perevedenNaRemontPoProbegu = perevedenNaRemontPoProbegu;
	}

	public Calendar getDataPerevedaNaRemontPoProbegu() {
		return dataPerevedaNaRemontPoProbegu;
	}

	public void setDataPerevedaNaRemontPoProbegu(
			Calendar dataPerevedaNaRemontPoProbegu) {
		this.dataPerevedaNaRemontPoProbegu = dataPerevedaNaRemontPoProbegu;
	}

	public String getDocumentPerevedaNaRemontPoProbegu() {
		return documentPerevedaNaRemontPoProbegu;
	}

	public void setDocumentPerevedaNaRemontPoProbegu(
			String documentPerevedaNaRemontPoProbegu) {
		this.documentPerevedaNaRemontPoProbegu = documentPerevedaNaRemontPoProbegu;
	}

	public Calendar getDataDocumentaPerevedaNaRemontPoProbegu() {
		return dataDocumentaPerevedaNaRemontPoProbegu;
	}

	public void setDataDocumentaPerevedaNaRemontPoProbegu(
			Calendar dataDocumentaPerevedaNaRemontPoProbegu) {
		this.dataDocumentaPerevedaNaRemontPoProbegu = dataDocumentaPerevedaNaRemontPoProbegu;
	}

	public String getDocumentNaIzmenenieGodaPostroiki() {
		return documentNaIzmenenieGodaPostroiki;
	}

	public void setDocumentNaIzmenenieGodaPostroiki(
			String documentNaIzmenenieGodaPostroiki) {
		this.documentNaIzmenenieGodaPostroiki = documentNaIzmenenieGodaPostroiki;
	}

	public Calendar getDataDocumentaNaIzmenenieGodaPostroiki() {
		return dataDocumentaNaIzmenenieGodaPostroiki;
	}

	public void setDataDocumentaNaIzmenenieGodaPostroiki(
			Calendar dataDocumentaNaIzmenenieGodaPostroiki) {
		this.dataDocumentaNaIzmenenieGodaPostroiki = dataDocumentaNaIzmenenieGodaPostroiki;
	}

	public Calendar getDataKapitalnogoPoslRemonta() {
		return dataKapitalnogoPoslRemonta;
	}

	public void setDataKapitalnogoPoslRemonta(Calendar dataKapitalnogoPoslRemonta) {
		this.dataKapitalnogoPoslRemonta = dataKapitalnogoPoslRemonta;
	}

	public String getKodZavodaKapitalnogoPoslRemonta() {
		return kodZavodaKapitalnogoPoslRemonta;
	}

	public void setKodZavodaKapitalnogoPoslRemonta(
			String kodZavodaKapitalnogoPoslRemonta) {
		this.kodZavodaKapitalnogoPoslRemonta = kodZavodaKapitalnogoPoslRemonta;
	}

	public Calendar getDataDepoPoslRemonta() {
		return dataDepoPoslRemonta;
	}

	public void setDataDepoPoslRemonta(Calendar dataDepoPoslRemonta) {
		this.dataDepoPoslRemonta = dataDepoPoslRemonta;
	}

	public String getKodDepoPoslRemonta() {
		return kodDepoPoslRemonta;
	}

	public void setKodDepoPoslRemonta(String kodDepoPoslRemonta) {
		this.kodDepoPoslRemonta = kodDepoPoslRemonta;
	}

	public String getNomerModernizacii1() {
		return nomerModernizacii1;
	}

	public void setNomerModernizacii1(String nomerModernizacii1) {
		this.nomerModernizacii1 = nomerModernizacii1;
	}

	public String getNomerModernizacii2() {
		return nomerModernizacii2;
	}

	public void setNomerModernizacii2(String nomerModernizacii2) {
		this.nomerModernizacii2 = nomerModernizacii2;
	}

	public String getNomerModernizacii3() {
		return nomerModernizacii3;
	}

	public void setNomerModernizacii3(String nomerModernizacii3) {
		this.nomerModernizacii3 = nomerModernizacii3;
	}

	public String getNomerModernizacii4() {
		return nomerModernizacii4;
	}

	public void setNomerModernizacii4(String nomerModernizacii4) {
		this.nomerModernizacii4 = nomerModernizacii4;
	}

	public String getNomerModernizacii5() {
		return nomerModernizacii5;
	}

	public void setNomerModernizacii5(String nomerModernizacii5) {
		this.nomerModernizacii5 = nomerModernizacii5;
	}

	public String getNomerModernizacii6() {
		return nomerModernizacii6;
	}

	public void setNomerModernizacii6(String nomerModernizacii6) {
		this.nomerModernizacii6 = nomerModernizacii6;
	}

	public String getNomerModernizacii7() {
		return nomerModernizacii7;
	}

	public void setNomerModernizacii7(String nomerModernizacii7) {
		this.nomerModernizacii7 = nomerModernizacii7;
	}

	public String getNomerModernizacii8() {
		return nomerModernizacii8;
	}

	public void setNomerModernizacii8(String nomerModernizacii8) {
		this.nomerModernizacii8 = nomerModernizacii8;
	}

	public String getNomerModernizacii9() {
		return nomerModernizacii9;
	}

	public void setNomerModernizacii9(String nomerModernizacii9) {
		this.nomerModernizacii9 = nomerModernizacii9;
	}

	public String getNomerModernizacii10() {
		return nomerModernizacii10;
	}

	public void setNomerModernizacii10(String nomerModernizacii10) {
		this.nomerModernizacii10 = nomerModernizacii10;
	}

	public String getNomerWagonaStarij() {
		return nomerWagonaStarij;
	}

	public void setNomerWagonaStarij(String nomerWagonaStarij) {
		this.nomerWagonaStarij = nomerWagonaStarij;
	}

	public String getKodPerenumerovania() {
		return kodPerenumerovania;
	}

	public void setKodPerenumerovania(String kodPerenumerovania) {
		this.kodPerenumerovania = kodPerenumerovania;
	}

	public Calendar getDataIzjatiaIzEdinogoParka() {
		return dataIzjatiaIzEdinogoParka;
	}

	public void setDataIzjatiaIzEdinogoParka(Calendar dataIzjatiaIzEdinogoParka) {
		this.dataIzjatiaIzEdinogoParka = dataIzjatiaIzEdinogoParka;
	}

	public String getKodArendatoraWagona() {
		return kodArendatoraWagona;
	}

	public void setKodArendatoraWagona(String kodArendatoraWagona) {
		this.kodArendatoraWagona = kodArendatoraWagona;
	}

	public String getStanciaPripiskiArendnogoWagona() {
		return stanciaPripiskiArendnogoWagona;
	}

	public void setStanciaPripiskiArendnogoWagona(
			String stanciaPripiskiArendnogoWagona) {
		this.stanciaPripiskiArendnogoWagona = stanciaPripiskiArendnogoWagona;
	}

	public Calendar getDataOkonchaniiArendi() {
		return dataOkonchaniiArendi;
	}

	public void setDataOkonchaniiArendi(Calendar dataOkonchaniiArendi) {
		this.dataOkonchaniiArendi = dataOkonchaniiArendi;
	}

	public String getOpisanieGruza() {
		return opisanieGruza;
	}

	public void setOpisanieGruza(String opisanieGruza) {
		this.opisanieGruza = opisanieGruza;
	}

	public String getPasportSostNaPredprijatii() {
		return pasportSostNaPredprijatii;
	}

	public void setPasportSostNaPredprijatii(String pasportSostNaPredprijatii) {
		this.pasportSostNaPredprijatii = pasportSostNaPredprijatii;
	}

	public String getUslKodBalansa() {
		return uslKodBalansa;
	}

	public void setUslKodBalansa(String uslKodBalansa) {
		this.uslKodBalansa = uslKodBalansa;
	}

	public String getVidSobstvWagonaTek() {
		return vidSobstvWagonaTek;
	}

	public void setVidSobstvWagonaTek(String vidSobstvWagonaTek) {
		this.vidSobstvWagonaTek = vidSobstvWagonaTek;
	}

	public String getVidSobstvWagonaPervichnij() {
		return vidSobstvWagonaPervichnij;
	}

	public void setVidSobstvWagonaPervichnij(String vidSobstvWagonaPervichnij) {
		this.vidSobstvWagonaPervichnij = vidSobstvWagonaPervichnij;
	}

	public String getPriznakNachozchdeniaWagonaVEdinomParke() {
		return priznakNachozchdeniaWagonaVEdinomParke;
	}

	public void setPriznakNachozchdeniaWagonaVEdinomParke(
			String priznakNachozchdeniaWagonaVEdinomParke) {
		this.priznakNachozchdeniaWagonaVEdinomParke = priznakNachozchdeniaWagonaVEdinomParke;
	}

	public String getKolNeproshedshichZapisej() {
		return kolNeproshedshichZapisej;
	}

	public void setKolNeproshedshichZapisej(String kolNeproshedshichZapisej) {
		this.kolNeproshedshichZapisej = kolNeproshedshichZapisej;
	}
	


	
}
