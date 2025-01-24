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

        Genere genere1 = new Genere("Fantasy");
        Genere genere2 = new Genere("Distopia");

        Libro libro1 = new Libro("Harry Potter e la Pietra Filosofale", LocalDate.of(1997,1,1), 223, autore1, genere1);
        Libro libro2 = new Libro("1984", LocalDate.of(1949,1,1), 328, autore2, genere2);

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




    }

}
