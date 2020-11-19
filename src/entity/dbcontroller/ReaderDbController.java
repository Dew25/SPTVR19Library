/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import entity.Reader;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class ReaderDbController extends AbstractFacade<Reader>{
    
    private EntityManager em;
        
    public ReaderDbController() {
        super(Reader.class);
        ConnectSingleton connect = ConnectSingleton.getInstanse();
        em = connect.getEntityManager();
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
