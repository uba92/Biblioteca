package org.example.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genere")
public class Genere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "genere")
    List<Libro> lista_libri;

    //costruttore
    public Genere() {}

    public Genere(String nome) {
        this.nome=nome;
    }

    //getters e setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genere{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", lista_libri=" + lista_libri +
                '}';
    }
}
