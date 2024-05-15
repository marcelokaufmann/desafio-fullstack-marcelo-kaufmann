package br.com.cl.desafiofullstackmarcelokaufmann.repository;

import br.com.cl.desafiofullstackmarcelokaufmann.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {

}
