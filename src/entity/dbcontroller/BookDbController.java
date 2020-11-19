/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import entity.Book;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class BookDbController extends AbstractFacade<Book>{
    private EntityManager em;

    public BookDbController() {
        super(Book.class);
        ConnectSingleton connect = ConnectSingleton.getInstanse();
        em = connect.getEntityManager();
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
