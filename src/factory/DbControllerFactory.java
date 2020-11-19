/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.dbcontroller.BookDbController;
import entity.dbcontroller.HistoryDbController;
import entity.dbcontroller.ReaderDbController;
import entity.dbcontroller.UserDbController;

/**
 *
 * @author user
 */
public class DbControllerFactory {
    public static BookDbController getBookDbController(){
        return new BookDbController();
    }
    public static ReaderDbController getReaderDbController(){
        return new ReaderDbController();
    }
    public static UserDbController getUserDbController(){
        return new UserDbController();
    }
    public static HistoryDbController getHistoryDbController(){
        return new HistoryDbController();
    }
}
