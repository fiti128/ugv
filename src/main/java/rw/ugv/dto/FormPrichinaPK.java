package rw.ugv.dto;

import java.io.Serializable;

/**
 * User: Siarhei Yanusheusky
 * Date: 24.10.13
 * Time: 14:28
 */
public class FormPrichinaPK implements Serializable {

    private String kodPrichina;
    private String kodForm;

    public FormPrichinaPK() {
    }

    public FormPrichinaPK(String kodPrichina, String kodForm) {
        this.kodPrichina = kodPrichina;
        this.kodForm = kodForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormPrichinaPK that = (FormPrichinaPK) o;

        if (!kodForm.equals(that.kodForm)) return false;
        if (!kodPrichina.equals(that.kodPrichina)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kodPrichina.hashCode();
        result = 31 * result + kodForm.hashCode();
        return result;
    }

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
}
