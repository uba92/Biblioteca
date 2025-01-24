package org.example;

import org.example.DAO.*;
import org.example.Entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Autore autore1 = new Autore("J.K.", "Rowling");
        Autore autore2 = new Autore("George", "Orwell");
        Autore autore3 = new Autore("Isaac", "Asimov");

        Genere genere1 = new Genere("Fantasy");
        Genere genere2 = new Genere("Distopia");
        Genere genere3 = new Genere("Sci-Fi");

        Libro libro1 = new Libro("Harry Potter e la Pietra Filosofale", LocalDate.of(1997,1,1), 223, autore1, genere1);
        Libro libro2 = new Libro("1984", LocalDate.of(1949,1,1), 328, autore2, genere2);
        Libro libro3 = new Libro("Funda Sci-Fi", LocalDate.of(1950, 3, 1), 480, autore3, genere3);

        Rivista rivista1 = new Rivista("Tecnologia e Innovazione", LocalDate.of(2025,1,1), 120, Rivista.Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("Scienza e Futuro", LocalDate.of(2024,12,27), 100, Rivista.Periodicita.SETTIMANALE);
        Rivista rivista3 = new Rivista("Arte e Cultura", LocalDate.of(2025,1,18), 100, Rivista.Periodicita.SEMESTRALE);

        List<Libro> libriAutore1 = new ArrayList<>();
        libriAutore1.add(libro1);

        List<Libro> libriAutore2 = new ArrayList<>();
        libriAutore2.add(libro2);

        autore1.setLista_libri(libriAutore1);
        autore2.setLista_libri(libriAutore2);

        Utente utente1 = new Utente("Umberto", "Tramontano", LocalDate.of(1992, 4, 6));
        Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.of(2025,1,1), LocalDate.of(2025,1,15));


        //salvataggio nel DB
        UtenteDAO utenteDAO = new UtenteDAOImpl();

        utenteDAO.aggiungiUtente(utente1);

        PrestitoDAO prestitoDAO = new PrestitoDAOImpl();

        prestitoDAO.aggiungiPrestito(prestito1);


        PubblicazioneDAO pubblicazioneDAO = new PubblicazioneDAOImpl();
        pubblicazioneDAO.aggiungiPubblicazione(libro1);
        pubblicazioneDAO.aggiungiPubblicazione(libro2);

        pubblicazioneDAO.aggiungiPubblicazione(rivista1);
        pubblicazioneDAO.aggiungiPubblicazione(rivista2);
        pubblicazioneDAO.aggiungiPubblicazione(rivista3);

    }

}
