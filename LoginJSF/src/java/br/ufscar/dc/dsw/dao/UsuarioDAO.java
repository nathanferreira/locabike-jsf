package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDAO extends GenericDAO<Usuario> {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    @Override
    public void save(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        em.persist(usuario);
        tx.commit();
        em.close();
    }

    @Override
    public List<Usuario> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select u from Usuario u", Usuario.class);
        List<Usuario> usuarios = q.getResultList();
        em.close();
        return usuarios;
    }

    @Override
    public void delete(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.getReference(Usuario.class, usuario.getEmail());
        tx.begin();
        em.remove(usuario);
        tx.commit();
    }

    @Override
    public void update(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }

    @Override
    public Usuario get(String email) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, email);
        em.close();
        return usuario;
    }
}
