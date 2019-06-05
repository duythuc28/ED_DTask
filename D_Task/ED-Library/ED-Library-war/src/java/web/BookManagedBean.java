/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.LibBookDTO;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import session.BookManagementFacadeRemote;
/**
 *
 * @author iOSDev
 */
@Named(value = "bookManagedBean")
@ConversationScoped
public class BookManagedBean implements Serializable {

    @EJB
    private BookManagementFacadeRemote bookManagementFacade;

    private String bookId;
    private String name;
    private String author;
    private String description;
    private String quantity;
    private String category;
    private boolean active;
    private ArrayList<LibBookDTO> searchList;
    
    public Conversation getConversation() {
        return conversation;
    }

    @Inject
    private Conversation conversation;
   
    
     /**
     * Creates a new instance of BookManagedBean
     */
    public BookManagedBean() {
        this.searchList = new ArrayList<>();
    }

    public ArrayList<LibBookDTO> getSearchList() {
        return this.searchList;
    }

    public void setSearchList(ArrayList<LibBookDTO> searchList) {
        this.searchList = searchList;
    }
    

    
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
  
     
     public String addBook() {
        if (this.bookId == null) {
            return "addBookFailure.xhtml";
        }
  
        LibBookDTO bookDTO = new LibBookDTO(bookId, name, author, description, category, active, Integer.valueOf(this.quantity));
        
         System.err.println(bookDTO);
        
        boolean result = bookManagementFacade.addBook(bookDTO);
        if (result) {
             return "addBookSuccess.xhtml";
        }
        return "addBookFailure.xhtml";
    }
     
    public ArrayList<LibBookDTO> getBookList() {
        return bookManagementFacade.getAllBooks();
    }
    

//    
    public void searchBooks() {

        System.out.println("Name " + this.name);
         System.out.println("Cate " + this.category);
        searchList.clear();
//        searchList = findBookByNameAndCategory();
        System.out.println("List " + this.findBookByNameAndCategory().size());
        for (LibBookDTO book: findBookByNameAndCategory()) {
            searchList.add(book);
        }
    }
    
     public void listener(AjaxBehaviorEvent event) {
        
    }

    
    private ArrayList<LibBookDTO> findBookByNameAndCategory() {
        if (this.name == null) { 
            this.name = "";
        }
        if (this.category == null) { 
            this.category = "ALL";
        }
        return bookManagementFacade.getBooks(this.name, this.category);
    }
     
     public String removeBook() { 
         if (this.bookId == null) {
            return "removeBookFailure.xhtml";
        }
        boolean result = bookManagementFacade.removeBook(bookId);
        if (result) {
             return "removeBookSuccess.xhtml";
        }
        return "removeBookFailure.xhtml";
     }
}
