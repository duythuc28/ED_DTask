/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LbBook;
import entity.LbBorrowedBook;
import entity.LbUser;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author iOSDev
 */
@Local
public interface BookLocalFacadeLocal {
    boolean addBook(LbBook book);
    boolean removeBook(String id);
    ArrayList<LbBook> getAllBooks();
    ArrayList<LbBook> getBooks(String name, String type);
    ArrayList<LbBook> getActiveBooks(String name, String type);
    boolean reserveBook(LbBorrowedBook borrowBook);
    LbBook find(String id);
}
