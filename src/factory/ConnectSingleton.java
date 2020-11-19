/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class ConnectSingleton {
    private  EntityManager em;
    private  EntityManagerFactory emf;
    private static ConnectSingleton instanse;

    private  ConnectSingleton() {
        try {
            this.emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
            this.em = emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("Нет подключения к базе данных");
            System.exit(0);
        }
    }
    public static ConnectSingleton getInstanse(){
        if(instanse == null){
            instanse = new ConnectSingleton();
        }
        return instanse;
    }
    public EntityManager getEntityManager() {
        return em;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
