/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.severs;

import entity.History;
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
public class HistorySaver {
    private final String fileName = "histories";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
   
    public void saveHistories(List<History> histories) {
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                if(histories.get(i)!= null){
                  if(histories.get(i).getId()==null){
                      em.persist(histories.get(i));
                  }else{
                      em.merge(histories.get(i));
                  }
                }
            }
        tx.commit();
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(fileName);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(histories);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");    
//        }
    }

    public List<History> loadFile() {
        try {
            return  em.createQuery("SELECT h FROM History h")
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
//            return (History[]) ois.readObject();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Ошибка: не найден класс");
//        }
//        return new History[100];
    }
    
}
