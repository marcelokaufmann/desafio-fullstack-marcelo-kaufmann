package br.com.cl.desafiofullstackmarcelokaufmann.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller para página de informação do sistema
 *
 * @author Marcelo Augusto Kaufmann
 * @since   14/05/2024
 * @version 1.0
 *
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
