/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.severs;

import entity.Book;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class ReaderSaver {
    private String fileName = "readers";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
   
    public void saveReaders(List<Reader> readers) {
        tx.begin();
            for (int i = 0; i < readers.size(); i++) {
                if(readers.get(i) != null){
                    if(readers.get(i).getId()==null){
                        em.persist(readers.get(i));
                    }else{
                        em.merge(readers.get(i));
                    }
                }
            }
        tx.commit();
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(fileName);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(readers);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");    
//        }
    }

    public List<Reader> loadFile() {
        try {
            return  em.createQuery("SELECT r FROM Reader r")
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
//            return (Reader[]) ois.readObject();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Ошибка: не найден класс");
//        }
//        return new Reader[100];
    }
    
}
