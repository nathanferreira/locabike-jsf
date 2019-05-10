package pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {

    @Id
    private String email;
    private String password;
    private String role;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Cliente> clientes;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Locadora> locadoras;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Usuario))
		return false;
	Usuario other = (Usuario) obj;
	return other.email.equals(this.email);
    }
    
    @Override
    public String toString() {
        return email;
    }

}
