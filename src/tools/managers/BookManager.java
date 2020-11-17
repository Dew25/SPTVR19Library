/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Book;
import entity.dbcontroller.BookDbController;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class BookManager {
    private BookDbController bc = new BookDbController();
    public Book createBook() {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание книги ---");
        System.out.print("Название книги: ");
        book.setName(scanner.nextLine());
        System.out.print("Автор книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Год издания книги: ");
        book.setPublishedYear(scanner.nextInt());
        bc.create(book);
        return book;
    }
    public void addBookToArray(Book book, List<Book> books){
        books.add(book);
    }

    public void printListBooks() {
        List<Book> books = bc.findAll();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i)!= null){
                System.out.printf("%3d. Название книги: %s%nАвтор: %s%n"
                        ,books.get(i).getId()
                        ,books.get(i).getName()
                        ,books.get(i).getAuthor()
                );
                System.out.println("--------------------------------");
            }
        }
    }
    
}
