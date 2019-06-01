package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Locacao implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private String ID;
    
    private String rentDate;
    
    @ManyToOne
    private Locadora locadora;

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
    
    @ManyToOne
    private Cliente cliente;
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getRentDate() {
        return rentDate;
    }

}
