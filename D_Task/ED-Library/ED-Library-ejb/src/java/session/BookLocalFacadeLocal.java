/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LbBook;
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
    boolean reserveBook(String id);
    LbBook find(String id);
}
