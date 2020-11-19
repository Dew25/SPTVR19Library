/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Reader;
import entity.dbcontroller.ReaderDbController;
import factory.DbControllerFactory;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReaderManager {
    private ReaderDbController rc = DbControllerFactory.getReaderDbController();

    public Reader createReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Регистрация читателя ---");
        System.out.print("Имя: ");
        reader.setName(scanner.nextLine());
        System.out.print("Фамилия: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Телефон: ");
        reader.setPhone(scanner.nextLine());
        rc.create(reader);
        return reader;
    }

    public void addReaderToArray(Reader reader, List<Reader> readers) {
        readers.add(reader);
    }
    public void printListReaders() {
        List<Reader> readers = rc.findAll();
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i)!= null){
                System.out.printf("%3d. Добавлен читатель: %s %s%n"
                        ,readers.get(i).getId()
                        ,readers.get(i).getName()
                        ,readers.get(i).getLastname()
                );
                System.out.println("--------------------------------");
            }
        }
    }
    
}
