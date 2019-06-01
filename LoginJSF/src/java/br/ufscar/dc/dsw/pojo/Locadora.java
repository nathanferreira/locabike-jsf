package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Locadora extends Usuario implements Serializable {

    private String CNPJ;
    private String name;
    private String city;

    public String getCNPJ() {
        return CNPJ;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
