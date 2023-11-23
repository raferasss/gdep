package com.raferasss.gdep.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raferasss.gdep.models.DependencyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cadastrarDependencia/busca")
public class ControladorJson {


    @GetMapping("{dependencia}")
    public List<DependencyDTO> consultaDependencia(@PathVariable("dependencia") String dependencia) throws IOException {
        String url = "https://search.maven.org/solrsearch/select?q=a:" + dependencia + "&rows=20&wt=json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.getForEntity(url,String.class);
        String responseBody = resp.getBody();


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        JsonNode docs = jsonNode.path("response").path("docs");

        List<DependencyDTO> dependencias = objectMapper.readValue(docs.traverse(),
                new TypeReference<List<DependencyDTO>>() {});

        for (int i = 0 ;i< dependencias.size();i++)
            System.out.println(dependencias.get(i).getId());


        return dependencias;

    }

}
