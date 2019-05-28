package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.pojo.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    
    private Usuario usuario;

    public String lista() {
        return "usuario/index.xhtml";
    }

    public String cadastra() {
        usuario = new Usuario();
        return "form.xhtml";
    }

    public String edita(String email) {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.get(email);
        return "form.xhtml";
    }

    public String salva() {
        UsuarioDAO dao = new UsuarioDAO();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        
        if (usuario.getEmail() == null) {
            
            dao.save(usuario);
            
        } else {
            dao.update(usuario);
        }
        return "index.xhtml";
    }

    public String delete(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.delete(usuario);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Usuario> getUsuarios() throws SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.getAll();
    }

    public Usuario getUsuario() {
        return usuario;
    }
}