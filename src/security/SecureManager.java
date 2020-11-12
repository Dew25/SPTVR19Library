/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.Reader;
import entity.User;
import java.util.List;
import java.util.Scanner;
import tools.managers.ReaderManager;
import tools.severs.ReaderSaver;
import tools.severs.SaverInterface;
import tools.severs.UserSaver;

/**
 *
 * @author user
 */
public class SecureManager {
    private Scanner scanner = new Scanner(System.in);
    
    public User checkTask(List<User> listUsers, List<Reader> listReaders, SaverInterface saver) {
        int numTask = -1;
        do{
            System.out.println("Ваш выбор: ");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Регистрация");
            System.out.println("2. Вход в систему");
            System.out.println("Введите номер задачи: ");
            String task = scanner.nextLine();
            UserManager userManager = new UserManager();
            try {
                numTask = Integer.parseInt(task);
                if(numTask >= 0 && numTask < 3){
                   if(numTask == 0){
                       System.out.println("Пока! :)");
                       System.exit(0);
                   }else if(numTask == 1){
                       User regUser = userManager.regUser();
                       userManager.addUserToArray(regUser, listUsers);
                       ReaderManager readerManager = new ReaderManager();
                       readerManager.addReaderToArray(regUser.getReader(), listReaders);
                       saver.save(listReaders, "Reader");
                       saver.save(listUsers,"User");
                   }else if(numTask == 2){
                       User authUser = userManager.getAuthUser(listUsers);
                       if(authUser != null){
                           return authUser;
                       }else{
                           System.out.println("Нет такого пользователя. Зарегистрируйтесь.");
                       }
                   }
                }
               
            } catch (Exception e) {
                System.out.println("Нет такой задачи. Выберите из перечисленных");
            }
         }while(true);
    }
    
}
