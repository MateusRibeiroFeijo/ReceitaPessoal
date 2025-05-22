package com.crp.neoculinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data //Já faz os geters e seters
@Entity //traduz essa entidade para MySQL e vice versa
@Table(name="Receita")
@Component
public class Receita {
    @Id
    private int id;
    private String nome;
    private String categoria;
    private String ingredientes;
    private String preparo;
    private int tempo;
    private String dificuldade;
}
