package br.com.cl.desafiofullstackmarcelokaufmann.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String tipo;

    @OneToMany
    private List<Evento> eventos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
