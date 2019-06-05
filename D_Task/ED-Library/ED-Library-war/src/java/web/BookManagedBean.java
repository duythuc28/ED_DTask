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
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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

    private String email;
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
//        if (this.name == null && this.category == null) {
//            this.searchList.addAll(this.findBookByNameAndCategory());
//        }
    }

    public ArrayList<LibBookDTO> getSearchList() {

        return this.searchList;
    }

    public void setSearchList(ArrayList<LibBookDTO> searchList) {
        this.searchList = searchList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public String getUserName() { 
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        String username = request.getRemoteUser();
        return username;
    }
    

    public void searchBooksAdmin() {
        System.out.println("Name " + this.name);
        System.out.println("Cate " + this.category);
        searchList.clear();
        for (LibBookDTO book: findAllBookByNameAndCategory(true)) {
            searchList.add(book);
        }
    }
    
    public void searchBooksNormal() {
        searchList.clear();
        for (LibBookDTO book: findAllBookByNameAndCategory(false)) {
            searchList.add(book);
        }
    }
    
    public String borowBook() { 
        this.email = getUserName();
        System.out.println("email "  + email);
        boolean result = bookManagementFacade.reserveBook(this.bookId, email);
        if (!result) {
            return "borrowFailure.xhtml";
        }
        return "borrowSuccess.xhtml";
    }
    
     public void listener(AjaxBehaviorEvent event) {
        
    }

    // This method is to help admin find and filter books 
    private ArrayList<LibBookDTO> findAllBookByNameAndCategory(boolean isAdmin) {
        if (this.name == null) { 
            this.name = "";
        }
        if (this.category == null) { 
            this.category = "ALL";
        }
        if (!isAdmin) { 
            System.out.println("Get Active books ");
            return bookManagementFacade.getActiveBooks(this.name, this.category);
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
