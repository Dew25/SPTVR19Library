/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.severs;

import entity.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class UserSaver {
    private final String fileName = "users";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
   

    public void saveUsers(List<User> users) {
        tx.begin();
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i) != null){
                    if(users.get(i).getId()==null){
                        em.persist(users.get(i));
                    }else{
                        em.merge(users.get(i));
                    }
                }
            }
        tx.commit();
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(fileName);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(users);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");    
//        }
    }

    public List<User> loadFile() {
        try {
            return em.createQuery("SELECT u FROM User u")
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Нет записей");
            return new ArrayList();
        }
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(fileName);
//            ois = new ObjectInputStream(fis);
//            return (User[]) ois.readObject();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Ошибка: не найден класс");
//        }
//        return new User[100];
    }
    
}
