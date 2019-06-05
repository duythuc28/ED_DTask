/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LibBookDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author iOSDev
 */
@Remote
public interface BookManagementFacadeRemote {
    boolean addBook(LibBookDTO bookDTO);
    
    boolean removeBook(String id);
    
    ArrayList<LibBookDTO> getBooks(String name, String category);
    
    ArrayList<LibBookDTO> getAllBooks();
    
    boolean reserveBook(String bookID, String userID);
    
    
}
