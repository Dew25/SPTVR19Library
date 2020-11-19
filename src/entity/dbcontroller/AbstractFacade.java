/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dbcontroller;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public abstract class AbstractFacade<T> {
    private EntityManager em;
    private Class<T> entityClass;
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    public void create(T entity) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        em = getEntityManager();
        try {
            String query = "SELECT en FROM "+entityClass.getName()+" en";
            return em.createQuery(query)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public T find(Long id) {
        em = getEntityManager();
        try {
            return (T) em.createQuery("SELECT en FROM "+entityClass.getName()+" en WHERE en.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
  

    public void edit(T entity) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();   
    }
    
}
