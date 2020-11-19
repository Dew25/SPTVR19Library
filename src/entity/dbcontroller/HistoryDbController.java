/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import entity.History;
import factory.ConnectSingleton;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class HistoryDbController extends AbstractFacade<History>{

    private EntityManager em;
   
    public HistoryDbController() {
        super(History.class);
        ConnectSingleton connect = ConnectSingleton.getInstanse();
        em = connect.getEntityManager();
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
