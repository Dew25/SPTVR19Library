/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.dbcontroller.BookDbController;
import entity.dbcontroller.HistoryDbController;
import entity.dbcontroller.ReaderDbController;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class HistoryManager {
    private HistoryDbController hc = new HistoryDbController();
    private ReaderDbController rc = new ReaderDbController();
    private BookDbController bc = new BookDbController();
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private Scanner scanner = new Scanner(System.in);
    
    public History takeOnBookToReader(){
        List<Book> books = bc.findAll();
        List<Reader> readers = rc.findAll();
        System.out.println("--- Cписок книг ---");
        bookManager.printListBooks();
        System.out.print("Выберите номер книги:");
        Long bookNumber = scanner.nextLong();
        Book book = bc.find(bookNumber);
        System.out.println("--- Список читателей ---");
        readerManager.printListReaders();
        System.out.print("Выберите номер читателя:");
        Long readerNumber = scanner.nextLong();
        Reader reader = rc.find(readerNumber);
        Calendar c = new GregorianCalendar();
        History history = new History();
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOnDate(c.getTime());
        hc.create(history);
        return history;
    }

    public void printListHistories() {
        List<History> histories = hc.findAll();
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i)!= null && histories.get(i).getReturnDate() == null){
                System.out.printf("%3d. Книгу \"%s\" читает %s %s%n"
                        ,i+1
                        ,histories.get(i).getBook().getName()
                        ,histories.get(i).getReader().getName()
                        ,histories.get(i).getReader().getLastname()
                );
                System.out.println("--------------------------------");
            }
        }
    }
    
    public void returnBook(){
        System.out.println("--- Список читаемых книг ---");
        this.printListHistories();
        System.out.print("Выберите номер возвращаемой книги: ");
        Long historyNumber = scanner.nextLong();
        Calendar c = new GregorianCalendar();
        History history = hc.find(historyNumber);
        history.setReturnDate(c.getTime());
        hc.edit(history);
        System.out.println("Книга "+history.getBook().getName()+" возвращена.");
    }
    
}
