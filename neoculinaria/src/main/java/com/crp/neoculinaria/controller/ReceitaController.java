package com.crp.neoculinaria.controller;

import com.crp.neoculinaria.model.Receita;
import com.crp.neoculinaria.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;
    
    @GetMapping("/cadastro")
    public String exibirFormulario(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("receita", new Receita());
        return "receita-cadastro";
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Receita receita){
        receitaService.salvar(receita);
        return "redirect:/lista";
    }
    
    @GetMapping("/lista")
    public String lista(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("receitas", receitaService.listarTodos());
        return "receita-listagem";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        receitaService.excluir(id);
        return "redirect:/lista";
    }
    
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, @CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("receita", receitaService.buscarPorId(id));
        return "receita-cadastro";
    }
    
    @GetMapping("/detalhes/{id}")
    public String exibirDetalhes(@PathVariable int id, @CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        Receita receita = receitaService.buscarPorId(id);
        model.addAttribute("css", tema);
        model.addAttribute("receita", receita);
        return "detalhes";
    }
}
