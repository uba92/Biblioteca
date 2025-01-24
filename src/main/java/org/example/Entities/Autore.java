package org.example.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autore")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "autore")
    List<Libro> lista_libri;
    //costruttori
    public Autore(){}

    public Autore(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
    }

    //getters e setters


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", lista_libri=" + lista_libri +
                '}';
    }

    public void setLista_libri(List<Libro> lista_libri) {
        this.lista_libri = lista_libri;
    }
}
