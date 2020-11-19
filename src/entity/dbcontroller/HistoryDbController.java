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
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class HistoryDbController extends AbstractFacade<History>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
   

    public HistoryDbController() {
        super(History.class);
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<History> findReadingAll() {
        try {
            String query = "SELECT en FROM History en WHERE en.returnDate = NULL";
            return em.createQuery(query)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
