package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Usuario;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        PapelDAO papelDAO = new PapelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        LocadoraDAO locadoraDAO = new LocadoraDAO();

        // Criando Usuario admin com papel ROLE_ADMIN
        Usuario u1 = new Usuario();
        u1.setEmail("admin@admin");
        u1.setPassword(encoder.encode("admin"));
        u1.setAtivo(true);
        usuarioDAO.save(u1);

        Papel p1 = new Papel();
        p1.setNome("ROLE_ADMIN");
        papelDAO.save(p1);

        u1.getPapel().add(p1);
        usuarioDAO.update(u1);

        // Criando Usuario cliente com papel ROLE_CLIENTE
        Cliente c1 = new Cliente();
        c1.setEmail("cliente@cliente");
        c1.setPassword(encoder.encode("cliente"));
        c1.setName("VIDALOKA");
        c1.setBirthDate("21/02/2000");
        c1.setCPF("420450123");
        c1.setGender("M");
        c1.setPhone("23872378");
        c1.setAtivo(true);
        clienteDAO.save(c1);

        Papel p3 = new Papel();
        p3.setNome("ROLE_CLIENTE");
        papelDAO.save(p3);

        c1.getPapel().add(p3);
        usuarioDAO.update(c1);

        // Criando Usuario locadora com papel ROLE_LOCADORA
        Locadora l1 = new Locadora();
        l1.setEmail("locadora@locadora");
        l1.setPassword(encoder.encode("locadora"));
        l1.setCNPJ("420450123");
        l1.setName("Locadora 1");
        l1.setCity("São Carlos");
        l1.setAtivo(true);
        locadoraDAO.save(l1);

        Papel p2 = new Papel();
        p2.setNome("ROLE_LOCADORA");
        papelDAO.save(p3);

        l1.getPapel().add(p2);
        usuarioDAO.update(l1);
    }
}
