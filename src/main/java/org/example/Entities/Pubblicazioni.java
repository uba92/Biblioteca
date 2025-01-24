package org.example.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pubblicazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codice_isbn;

    private String titolo;

    private LocalDate anno_pubblicazione;

    private int numero_pagine;

    //costruttori

    public Pubblicazioni() {}

    public Pubblicazioni(String titolo, LocalDate anno_pubblicazione, int numero_pagine) {
        this.titolo=titolo;
        this.anno_pubblicazione=anno_pubblicazione;
        this.numero_pagine=numero_pagine;
    }

    //getters e setters


    public Long getCodice_isbn() {
        return codice_isbn;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setAnno_pubblicazione(LocalDate anno_pubblicazione) {
        this.anno_pubblicazione=anno_pubblicazione;
    }

    public LocalDate getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    @Override
    public String toString() {
        return "Pubblicazioni{" +
                "codice_ISBN=" + codice_isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
