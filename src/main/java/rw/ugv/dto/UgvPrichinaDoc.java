package rw.ugv.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * User: Siarhei Yanusheusky
 * Date: 24.10.13
 * Time: 14:31
 */
@Entity
@IdClass(value = FormPrichinaPK.class)
@Table(name = "SP_PRICHINA_DOC", schema="UGV")
public class UgvPrichinaDoc implements Serializable {
    @Id @Column(name = "KOD_PRICHINA_DOC")
    private String kodPrichina;
    @Id @Column(name = "KOD_FORM")
    private String kodForm;

    @Column(name = "FULL_NAME_PRICHINA_DOC")
    private String fullName;

    @Column(name = "SHORT_NAME_PRICHINA_DOC")
    private String shortName;

    public String getKodPrichina() {
        return kodPrichina;
    }

    public void setKodPrichina(String kodPrichina) {
        this.kodPrichina = kodPrichina;
    }

    public String getKodForm() {
        return kodForm;
    }

    public void setKodForm(String kodForm) {
        this.kodForm = kodForm;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "UgvPrichinaDoc{" +
                "kodPrichina='" + kodPrichina + '\'' +
                ", kodForm='" + kodForm + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
