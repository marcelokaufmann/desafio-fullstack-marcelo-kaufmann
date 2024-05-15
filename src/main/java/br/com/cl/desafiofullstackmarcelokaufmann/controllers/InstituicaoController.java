package br.com.cl.desafiofullstackmarcelokaufmann.controllers;

import br.com.cl.desafiofullstackmarcelokaufmann.models.Evento;
import br.com.cl.desafiofullstackmarcelokaufmann.models.Instituicao;
import br.com.cl.desafiofullstackmarcelokaufmann.repository.EventoRepository;
import br.com.cl.desafiofullstackmarcelokaufmann.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class InstituicaoController {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value = "/cadastrarInstituicao", method = RequestMethod.GET)
    public String form() {
        return "instituicao/formInstituicao";
    }

    /**
     * Método para criação de instituição
     *
     * @author Marcelo Augusto Kaufmann
     * @since   14/05/2024
     * @version 1.0
     *
     */
    @RequestMapping(value = "/cadastrarInstituicao", method = RequestMethod.POST)
    public String form(Instituicao instituicao) {

        instituicaoRepository.save(instituicao);

        return "redirect:/cadastrarInstituicao";
    }


    /**
     * Método para preenchimento da grid de instituições
     *
     * @author Marcelo Augusto Kaufmann
     * @since   14/05/2024
     * @version 1.0
     *
     */
    @RequestMapping("/instituicoes")
    public ModelAndView listaInstituicoes() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Instituicao> instituicoes = instituicaoRepository.findAll();
        mv.addObject("instituicoes", instituicoes);
        return mv;
    }

    /**
     * Método para visualização de instituição
     *
     * @author Marcelo Augusto Kaufmann
     * @since   14/05/2024
     * @version 1.0
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesInstituicao(@PathVariable("id") Integer id) {
        Instituicao instituicao = instituicaoRepository.findById(id);
        ModelAndView mv = new ModelAndView("instituicao/detalhesInstituicao");
        mv.addObject("instituicao", instituicao);
        return mv;
    }

    /**
     * Método para criação de evento
     *
     * @author Marcelo Augusto Kaufmann
     * @since   14/05/2024
     * @version 1.0
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String detalhesInstituicaoPost(@PathVariable("id") Integer id, Evento evento) {
        Instituicao instituicao = instituicaoRepository.findById(id);
        evento.setInstituicao(instituicao);
        Date dataAtual = new Date();
        if (evento.getDataInicial().before(dataAtual) && evento.getDataFinal().after(dataAtual)) {
            evento.setAtivo(Boolean.TRUE);
        } else {
            evento.setAtivo(Boolean.FALSE);
        }
        eventoRepository.save(evento);

        return "redirect:/{id}";
    }
}
