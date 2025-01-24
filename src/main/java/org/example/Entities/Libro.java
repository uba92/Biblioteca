package org.example.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libro extends Pubblicazioni{
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autore_id")
    private Autore autore;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genere_id")
    private Genere genere;

    //costruttore
    public Libro() {}

    public Libro(String titolo, LocalDate anno_pubblicazione, int numero_pagine, Autore autore, Genere genere) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.autore=autore;
        this.genere=genere;
    }

    //getters e setters

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore=" + autore +
                ", genere=" + genere +
                '}';
    }
}
