package org.example.DAO;

import org.example.Entities.Autore;
import org.example.Entities.Pubblicazioni;

import java.util.List;

public interface PubblicazioneDAO {
    void aggiungiPubblicazione(Pubblicazioni pubblicazione);

    void rimuoviPubblicazione(Long isbn);

    Pubblicazioni cercaDaIsbn(Long isbn);

//    List<Pubblicazioni> cercaDaYear(int anno_pubblicazione);
//
    List<Pubblicazioni> cercaDaAutore(Autore autore);
//
    Pubblicazioni cercaDaTitle(String titolo);
//
//    List<Pubblicazioni> elementiInPrestito (Long numero_tessera);

}
