package com.crp.neoculinaria.service;

import com.crp.neoculinaria.model.Receita;
import com.crp.neoculinaria.repository.ReceitaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;
    
    public Receita salvar(Receita receita){
        return receitaRepository.save(receita);
    }
    
    public List<Receita> listarTodos(){
        return receitaRepository.findAll();
    }
    
    public Receita buscarPorId(int id){
        return receitaRepository.findById(id).orElse(null);
    }
    
    public void excluir(int id){
        receitaRepository.deleteById(id);
    }
}
