package org.example.DAO;


import jakarta.persistence.EntityManager;
import org.example.Entities.Autore;
import org.example.Entities.Pubblicazioni;
import org.example.Entities.Utente;
import org.example.EntityManagerUtil;

import java.util.List;

public class PubblicazioneDAOImpl implements PubblicazioneDAO {


    @Override
    public void aggiungiPubblicazione(Pubblicazioni pubblicazione) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(pubblicazione);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    @Override
    public void rimuoviPubblicazione(Long isbn) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Pubblicazioni pubblicazioneDaRimuovere = em.find(Pubblicazioni.class, isbn);
            if (pubblicazioneDaRimuovere != null)
                em.remove(pubblicazioneDaRimuovere);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    @Override
    public Pubblicazioni cercaDaIsbn(Long isbn) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Pubblicazioni pubblicazioneTrovata = em.find(Pubblicazioni.class, isbn);
            em.getTransaction().commit();
            return pubblicazioneTrovata;
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }

    @Override
    public List<Pubblicazioni> cercaDaAutore(Autore autore) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            return em.createQuery("SELECT * FROM pubblicazioni ", Pubblicazioni.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }

    @Override
    public Pubblicazioni cercaDaTitle(String titolo) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Pubblicazioni pubblicazioneTrovata = em.find(Pubblicazioni.class, titolo);
            em.getTransaction().commit();
            return pubblicazioneTrovata;
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }

}
