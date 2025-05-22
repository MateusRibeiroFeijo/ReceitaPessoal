package com.crp.neoculinaria.controller;

import com.crp.neoculinaria.model.Receita;
import com.crp.neoculinaria.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    @GetMapping("/cadastro")
    public String exibirFormulario(){
        return "receita-cadastro";
    }
    
    @GetMapping("/lista")
    public String lista(){
        return "receita-listagem";
    }
}
