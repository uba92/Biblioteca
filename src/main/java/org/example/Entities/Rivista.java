package org.example.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Rivista extends Pubblicazioni{

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    //costruttore
    public Rivista() {}

    public Rivista(String titolo, LocalDate anno_pubblicazione, int numero_pagine, Periodicita periodicita) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.periodicita = periodicita;
    }

    //getters e setters

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public enum Periodicita {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
