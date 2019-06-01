package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class ClienteBean {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private Cliente cliente;

    public String lista() {
        return "cliente/index.xhtml";
    }

    public String cadastra() {
        cliente = new Cliente();
        return "form.xhtml";
    }

    public String edita(String email) {
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.get(email);
        return "form.xhtml";
    }

    public String salva() {
        ClienteDAO dao = new ClienteDAO();
        cliente.setAtivo(true);

        if (cliente.getDtype() == null) {
            cliente.setPassword(encoder.encode(cliente.getPassword()));
            dao.save(cliente);
        } else {
            dao.update(cliente);
        }
        
        return "index.xhtml";
    }

    public String delete(Cliente cliente) {
        ClienteDAO dao = new ClienteDAO();
        dao.delete(cliente);
        return "index.xhtml";
    }

    public String volta() {
        return "/menu.xhtml?faces-redirect=true";
    }

    public List<Cliente> getClientes() throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        return dao.getAll();
    }

    public Cliente getCliente() {
        return cliente;
    }
}
