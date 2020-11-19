/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import entity.History;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class HistoryDbController {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public void create(History history) {
        tx.begin();
        em.persist(history);
        tx.commit();
    }

    public List<History> findAll() {
        try {
            return em.createQuery("SELECT h FROM History h")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public History find(Long historyId) {
        try {
            return (History) em.createQuery("SELECT h FROM History h WHERE h.id = :historyId")
                    .setParameter("historyId", historyId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }    
    }

    public void edit(History history) {
        tx.begin();
        em.merge(history);
        tx.commit();    }
}
