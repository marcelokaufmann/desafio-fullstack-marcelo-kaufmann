package br.com.cl.desafiofullstackmarcelokaufmann.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Modelo para permissão de acesso de usuários
 *
 * @author Marcelo Augusto Kaufmann
 * @since   01/02/2021
 * @version 1.0
 *
 */
@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    private String nomeRole;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}
