package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.Entities.Prestito;
import org.example.EntityManagerUtil;

import java.util.List;

public class PrestitoDAOImpl implements PrestitoDAO{

    @Override
    public void aggiungiPrestito(Prestito prestito) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prestito);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Prestito trovaDaId(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Prestito prestitoTrovato = em.find(Prestito.class, id);
            em.getTransaction().commit();
            return prestitoTrovato;
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void rimuoviPrestito(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Prestito prestitoDaRimuovere = em.find(Prestito.class, id);
            if (prestitoDaRimuovere != null)
                em.remove(prestitoDaRimuovere);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Prestito> prestitiPerUtente(Long numero_tessera) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Prestito p", Prestito.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}
