package rw.ugv.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: Siarhei Yanusheusky
 * Date: 23.10.13
 * Time: 9:05
 */
@Entity
@Table(name="SP_FORM_DOC", schema="UGV")
public class SpFormDoc implements Serializable {

    @Id
    @Column(name = "KOD_FORM")
    private String kodForm;

    @Column(name = "PR_PRICHINA")
    private int prPrichini;

    @Column(name = "PR_NOMER_DOC")
    private int prNomeraDocumenta;

    @Column(name = "PR_DEPO_DOC")
    private int prDepoDoc;

    @Column(name = "PR_ST_DOC")
    private int prStDoc;

    @Column(name = "PR_DATA_DOC")
    private int prDataDoc;

    @Column(name = "PR_ST_DISLORFCII")
    private int prStDislocacii;

    @Column(name = "SHORT_NAME_FORM")
    private String shortNameForm;

    @Column(name = "FULL_NAME_FORM")
    private String fullNameForm;


    public String getKodForm() {
        return kodForm;
    }

    public void setKodForm(String kodForm) {
        this.kodForm = kodForm;
    }

    public int getPrPrichini() {
        return prPrichini;
    }

    public void setPrPrichini(int prPrichini) {
        this.prPrichini = prPrichini;
    }

    public int getPrNomeraDocumenta() {
        return prNomeraDocumenta;
    }

    public void setPrNomeraDocumenta(int prNomeraDocumenta) {
        this.prNomeraDocumenta = prNomeraDocumenta;
    }

    public int getPrDepoDoc() {
        return prDepoDoc;
    }

    public void setPrDepoDoc(int prDepoDoc) {
        this.prDepoDoc = prDepoDoc;
    }

    public int getPrStDoc() {
        return prStDoc;
    }

    public void setPrStDoc(int prStDoc) {
        this.prStDoc = prStDoc;
    }

    public int getPrDataDoc() {
        return prDataDoc;
    }

    public void setPrDataDoc(int prDataDoc) {
        this.prDataDoc = prDataDoc;
    }

    public int getPrStDislocacii() {
        return prStDislocacii;
    }

    public void setPrStDislocacii(int prStDislocacii) {
        this.prStDislocacii = prStDislocacii;
    }

    public String getShortNameForm() {
        return shortNameForm;
    }

    public void setShortNameForm(String shortNameForm) {
        this.shortNameForm = shortNameForm;
    }

    public String getFullNameForm() {
        return fullNameForm;
    }

    public void setFullNameForm(String fullNameForm) {
        this.fullNameForm = fullNameForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpFormDoc spFormDoc = (SpFormDoc) o;

        if (!kodForm.equals(spFormDoc.kodForm)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return kodForm.hashCode();
    }

    @Override
    public String toString() {
        return shortNameForm;
    }
}
