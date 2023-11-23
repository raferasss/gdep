package com.raferasss.gdep.controllers;

import com.raferasss.gdep.models.DependencyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class ControladorDependencia {


    //GERA O FORMULARIO WEB BASEADO NO  CAMINHO form/formDependencia
    @RequestMapping("/cadastrarDependencia")
    public String formDependencia () {

        return "form/formDependencia";
    }

    //PROCESSA STRING QUE É DIGITADA PELO USUARIO E NOS LEVA PARA A CHAMADA DO CONTROLADORJSON
    @RequestMapping(value = "/cadastrarDependencia", method = RequestMethod.POST)
    String processarFormulario (@RequestParam("dependencia") String minhaString) throws IOException {
        System.out.println("String digitada: " + minhaString);

        return "redirect:/cadastrarDependencia/busca/" + minhaString;

    }
}
