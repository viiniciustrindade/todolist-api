package com.senai.todolist.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Tarefa> tarefas;
    public Usuario(String nome, String senha){
        this.nome=nome;
        this.senha=senha;
    }
}