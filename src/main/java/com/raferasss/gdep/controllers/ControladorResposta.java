package com.raferasss.gdep.controllers;

import com.raferasss.gdep.models.DependencyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class ControladorResposta {

    @GetMapping("/resultado/{parametro}")
    public String resultado(@PathVariable String parametro, Model model) throws IOException {
        ControladorJson json = new ControladorJson();
        List<DependencyDTO> lista = json.consultaDependencia(parametro); // Substitua "algumaString" pelo valor desejado
        model.addAttribute("listaDependencias", lista);
        lista.get(1).construirLinkMaven();
        return "resultadoBusca";
    }
}


