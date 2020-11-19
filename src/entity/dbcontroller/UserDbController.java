/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import entity.User;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class UserDbController extends AbstractFacade<User>{
   
    private EntityManager em;
     public UserDbController() {
        super(User.class);
        ConnectSingleton connect = ConnectSingleton.getInstanse();
        em = connect.getEntityManager();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
