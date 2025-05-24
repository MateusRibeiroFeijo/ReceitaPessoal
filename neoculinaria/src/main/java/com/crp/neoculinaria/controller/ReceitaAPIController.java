package com.crp.neoculinaria.controller;

import com.crp.neoculinaria.model.Receita;
import com.crp.neoculinaria.service.ReceitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receita")
@CrossOrigin(origins="*")
public class ReceitaAPIController {
    @Autowired
    private ReceitaService receitaService;
    
    @GetMapping
    public List<Receita> listarTodos(){
        return receitaService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Receita buscarReceita(@PathVariable int id){
        return receitaService.buscarPorId(id);
    }
    
    @PostMapping
    public Receita criarReceita(@RequestBody Receita receita){
        return receitaService.salvar(receita);
    }
    
    @PutMapping("/{id}")
    public Receita atualizarReceita(@PathVariable int id, @RequestBody Receita receitaAtualizada){
        return receitaService.salvar(receitaAtualizada);
    }
    
    @DeleteMapping("/{id}")
    public void deletarReceita(@PathVariable int id){
        receitaService.excluir(id);
    }
    
}
