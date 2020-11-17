/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class UserDbController extends AbstractFacade<User>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
     public UserDbController() {
        super(User.class);
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
