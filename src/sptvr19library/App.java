/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import security.SecureManager;
import entity.Book;
import entity.History;
import entity.User;
import java.util.Scanner;
import security.UserManager;
import tools.managers.BookManager;
import tools.managers.HistoryManager;
import tools.managers.ReaderManager;


/**
 *
 * @author sillamae kutsekool
 */
class App {
 
    private ReaderManager readerManager = new ReaderManager();
    private BookManager bookManager = new BookManager();
    private HistoryManager historyManager = new HistoryManager();
    private UserManager userManager = new UserManager();
    private SecureManager secureManager = new SecureManager();
    private User loginedUser;

    public App() {
    }
    
    public void run(){
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask();
        boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Посмотреть список книг");
            System.out.println("3. Зарегистрировать нового читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу в библиотеку");
            System.out.println("7. Список читаемыз книг");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
           
            switch (task) {
                case "0":
                    System.out.println("---- Конец программы ----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("---- Добавить новую книгу ----");
                    Book book = bookManager.createBook();
                    break;
                case "2":
                    System.out.println("--- Cписок книг ---");
                    bookManager.printListBooks();
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    User user = userManager.regUser();
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    readerManager.printListReaders();
                    break;
                case "5":
                    System.out.println("--- Выдать книгу ---");
                    History history = historyManager.takeOnBookToReader();
                    
                    break;
                case "6":
                    System.out.println("--- Возврат книги ---");
                    historyManager.returnBook();
                    break;
                case "7":
                    System.out.println("--- Список читаемых книг ---");
                    historyManager.printListHistories();
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
