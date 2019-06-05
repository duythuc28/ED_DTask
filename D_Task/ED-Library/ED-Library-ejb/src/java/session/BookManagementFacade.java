/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LbBook;
import entity.LibBookDTO;
import java.util.ArrayList;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author iOSDev
 */
@DeclareRoles({"ADMIN", "STUDENT", "LIBRARIAN"})
@Stateless
public class BookManagementFacade implements BookManagementFacadeRemote {

    @EJB
    private BookLocalFacadeLocal localFacade;
    
    private LibBookDTO convertToDTO(LbBook book) {
        if (book == null) { return null; }
        
        LibBookDTO bookDTO = new LibBookDTO(book.getBookId(),
                book.getName(), book.getAuthor(), book.getDescription(),
                book.getCategory(), book.getActive(), book.getQuantity());
        
        return bookDTO;
    }
    
    private LbBook convertDTO2Object(LibBookDTO dto) {
        if (dto == null) return null ;
      
        LbBook book = new LbBook();
        book.setBookId(dto.getBookId());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setQuantity(dto.getQuantity());
        book.setCategory(dto.getCategory());
        book.setActive(dto.getActive());
        
        return book;
    }

    @RolesAllowed({"ADMIN", "LIBRARIAN"})
    @Override
    public boolean addBook(LibBookDTO bookDTO) {
        if (bookDTO == null) return false;
        LbBook book = convertDTO2Object(bookDTO);
        return localFacade.addBook(book);
    }

    @RolesAllowed({"ADMIN", "LIBRARIAN"})
    @Override
    public boolean removeBook(String id) {
       if (id == null) return false;
       return localFacade.removeBook(id);
    }
    
    @RolesAllowed({"ADMIN", "LIBRARIAN"})
    @Override
    public ArrayList<LibBookDTO> getAllBooks() {
        ArrayList<LbBook> books = localFacade.getAllBooks();
        ArrayList<LibBookDTO> newBookList = new ArrayList<>();
        for (LbBook book: books) {
            LibBookDTO dto = this.convertToDTO(book);
            newBookList.add(dto);
        }
        return newBookList;
    }
    
    

    @RolesAllowed({"ADMIN", "LIBRARIAN", "STUDENT"})
    @Override
    public ArrayList<LibBookDTO> getBooks(String name, String category) {
        ArrayList<LbBook> books = localFacade.getBooks(name, category);
        ArrayList<LibBookDTO> newBookList = new ArrayList<>();
        for (LbBook book: books) {
            LibBookDTO dto = this.convertToDTO(book);
            newBookList.add(dto);
        }
        return newBookList;
    }

    @RolesAllowed({"ADMIN", "LIBRARIAN", "STUDENT"})
    @Override
    public boolean reserveBook(String bookID, String userID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
