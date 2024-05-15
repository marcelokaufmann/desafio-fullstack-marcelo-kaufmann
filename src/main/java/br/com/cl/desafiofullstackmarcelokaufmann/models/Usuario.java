package br.com.cl.desafiofullstackmarcelokaufmann.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Modelo para informações de usuários
 *
 * @author Marcelo Augusto Kaufmann
 * @since   01/02/2021
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    private String login;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "senha")
    private String senha;

    @ManyToMany
    @JoinTable(name = "usuarios_roles",joinColumns = @JoinColumn(
            name = "usuario_id", referencedColumnName = "login"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
    private List<Role> roles;

    public Usuario(String login, String nomeCompleto, String senha) {
        this.login = login;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
