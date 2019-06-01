package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.pojo.Locacao;
import br.ufscar.dc.dsw.pojo.Locadora;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LocacaoBean {

    private Locacao locacao;

    public String lista() {
        return "locacao/index.xhtml";
    }

    public String cadastra() {
        locacao = new Locacao();
        return "form.xhtml";
    }

    public String edita(String ID) {
        LocacaoDAO dao = new LocacaoDAO();
        locacao = dao.get(ID);
        return "form.xhtml";
    }

    public String salva(String email) {
        LocacaoDAO dao = new LocacaoDAO();
        ClienteDAO daoC = new ClienteDAO();
        
        LocadoraDAO daoL = new LocadoraDAO();
        
        locacao.setCliente(daoC.getClienteByEmail(email));
        // locacao.setLocadora(daoL.get("locadora@locadora"));
        
        if (locacao.getID() == null) {
            dao.save(locacao);
        } else {
            dao.update(locacao);
        }
        
        return "index.xhtml";
    }

    public String delete(Locacao locacao) {
        LocacaoDAO dao = new LocacaoDAO();
        dao.delete(locacao);
        return "locacao/index.xhtml";
    }

    public String volta() {
        return "/menu.xhtml?faces-redirect=true";
    }

    public List<Locacao> getLocacaos() throws SQLException {
        LocacaoDAO dao = new LocacaoDAO();
        return dao.getAll();
    }

    public Locacao getLocacao() {
        return locacao;
    }
}