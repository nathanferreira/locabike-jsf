package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario implements Serializable {

    private String CPF;
    private String name;
    private String gender;
    private String phone;
    private String birthDate;

    /*@OneToMany
    private List<Locacao> locacao;

    public List<Locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Locacao> locacao) {
        this.locacao = locacao;
    }*/
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
