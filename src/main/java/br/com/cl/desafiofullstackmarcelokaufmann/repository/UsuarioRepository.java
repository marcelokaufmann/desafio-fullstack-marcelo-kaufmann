package br.com.cl.desafiofullstackmarcelokaufmann.repository;

import br.com.cl.desafiofullstackmarcelokaufmann.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findByLogin(String login);
}
