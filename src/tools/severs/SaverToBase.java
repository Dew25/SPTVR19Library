/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.severs;

import entity.Book;
import entity.EntityInterface;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class SaverToBase implements SaverInterface{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
   
    @Override
    public void save(List entityList, String entityName) {
        tx.begin();
        EntityInterface entity = null;
            for (int i = 0; i < entityList.size(); i++) {
                if(entityName.equals(Book.class.toString())){
                    entity = (Book) entityList.get(i);
                }
                if(entityName.equals(Reader.class.toString())){
                    entity = (Reader) entityList.get(i);
                }
                if(entityName.equals(User.class.toString())){
                    entity = (User) entityList.get(i);
                }
                if(entityName.equals(History.class.toString())){
                    entity = (History) entityList.get(i);
                }
                //EntityInterface entity = (EntityInterface)entityList.get(i);
                if(entity != null && entity.getId()==null){
                    em.persist(entity);
                    break;
                }else{
                    em.merge(entity);
                }
            }
        tx.commit();
    }

    @Override
    public List load(String entityName) {
        try {
            return  em.createQuery("SELECT entity FROM "+entityName+" entity")
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Нет записей");
            return new ArrayList<>();
        }
    }
    
}
