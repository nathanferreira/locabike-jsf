package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Locadora extends Usuario implements Serializable {

    private String CNPJ;
    private String name;
    private String city;

    /*@OneToMany
    private List<Locacao> locacao;

    public List<Locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Locacao> locacao) {
        this.locacao = locacao;
    }*/

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
