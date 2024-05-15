package br.com.cl.desafiofullstackmarcelokaufmann.repository;

import br.com.cl.desafiofullstackmarcelokaufmann.models.Instituicao;
import org.springframework.data.repository.CrudRepository;

public interface InstituicaoRepository extends CrudRepository<Instituicao, String> {
    Instituicao findById(Integer id);
}
