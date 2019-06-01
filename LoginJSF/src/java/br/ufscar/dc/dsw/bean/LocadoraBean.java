package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.pojo.Locadora;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class LocadoraBean {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private Locadora locadora;

    public String lista() {
        return "locadora/index.xhtml";
    }

    public String cadastra() {
        locadora = new Locadora();
        return "form.xhtml";
    }
    
    public String edita(String email) {
        LocadoraDAO dao = new LocadoraDAO();
        locadora = dao.get(email);
        return "form.xhtml";
    }

    public String salva() {
        LocadoraDAO dao = new LocadoraDAO();
        locadora.setAtivo(true);
        
        if (locadora.getDtype() == null) {
            locadora.setPassword(encoder.encode(locadora.getPassword()));
            dao.save(locadora);
        } else {
            dao.update(locadora);
        }
        
        return "index.xhtml";
    }

    public String delete(Locadora locadora) {
        LocadoraDAO dao = new LocadoraDAO();
        dao.delete(locadora);
        return "index.xhtml";
    }

    public String volta() {
        return "/menu.xhtml?faces-redirect=true";
    }
    
    public String voltaIndex(){
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Locadora> getLocadoras() throws SQLException {
        LocadoraDAO dao = new LocadoraDAO();
        return dao.getAll();
    }

    public Locadora getLocadora() {
        return locadora;
    }
}
