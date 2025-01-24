package org.example.DAO;

import org.example.Entities.Utente;

import java.util.List;

public interface UtenteDAO {
    void aggiungiUtente (Utente utente);

    void rimuoviUtente(Long numero_tessera);

    List<Utente> trovaTuttiUtenti ();

    Utente cercaDaNumeroTessera(Long numeroTessera);

}
