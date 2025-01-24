package org.example.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pubblicazione_id")
    private Pubblicazioni pubblicazione;

    private LocalDate data_inizio;

    private LocalDate data_fine_prevista;

    private LocalDate data_fine_effettiva;

    //costruttore
    public Prestito() {}

    public Prestito(Utente utente, Pubblicazioni pubblicazione, LocalDate data_inizio, LocalDate data_fine_effettiva) {
        this.utente = utente;
        this.pubblicazione = pubblicazione;
        this.data_inizio = data_inizio;
        this.data_fine_prevista = data_inizio.plusDays(30);
        this.data_fine_effettiva = data_fine_effettiva;
    }



    //getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Pubblicazioni getPubblicazione() {
        return pubblicazione;
    }

    public void setPubblicazione(Pubblicazioni pubblicazione) {
        this.pubblicazione = pubblicazione;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getData_fine_prevista() {
        return data_fine_prevista;
    }

    public void setData_fine_prevista(LocalDate data_fine_prevista) {
        this.data_fine_prevista = data_fine_prevista;
    }

    public LocalDate getData_fine_effettiva() {
        return data_fine_effettiva;
    }

    public void setData_fine_effettiva(LocalDate data_fine_effettiva) {
        this.data_fine_effettiva = data_fine_effettiva;
    }

    //toString

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", pubblicazione=" + pubblicazione +
                ", data_inizio=" + data_inizio +
                ", data_fine_prevista=" + data_fine_prevista +
                ", data_fine_effettiva=" + data_fine_effettiva +
                '}';
    }
}
