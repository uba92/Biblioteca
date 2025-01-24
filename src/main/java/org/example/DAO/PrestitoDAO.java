package org.example.DAO;

import org.example.Entities.Prestito;

import java.util.List;

public interface PrestitoDAO {
    void aggiungiPrestito(Prestito prestito);

    Prestito trovaDaId (Long id);

    void rimuoviPrestito(Long id);

    List<Prestito> prestitiPerUtente(Long numero_tessera);
}
