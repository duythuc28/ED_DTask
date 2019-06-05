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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author iOSDev
 */
@Stateless
public class BookLocalFacade implements BookLocalFacadeLocal {
    
    @PersistenceContext(unitName = "ED-Library-ejbPU")
    private EntityManager em;
    
    public BookLocalFacade() {
    }

    // PRIVATE METHODS
    
    private void create(LbBook entity) {
        em.persist(entity);
    }

    private void edit(LbBook entity) {
        em.merge(entity);
    }

    private void remove(LbBook entity) {
        em.remove(em.merge(entity));
    }
    
    private void insertBorrowBook(LbBorrowedBook borrowedBook) { 
        em.persist(borrowedBook);
    }

    // IMPLEMENT METHODS
    @Override
    public boolean addBook(LbBook book) {
        if (book == null) return false; 
        
        LbBook getBook = find(book.getBookId());
        
        // Book is exited
        if (getBook != null) {
            return false;
        }
        
        this.create(book);
        return true;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public LbBook find(String id) {
        return em.find(LbBook.class, id);
    }

    @Override
    public boolean removeBook(String id) {
        
        if (id == null) return false;
        
        LbBook findBook = find(id);
        
       if (findBook == null) { 
           return false;
       }
       
       if (findBook.getActive() == false) { 
           return false;
       }
       
       findBook.setActive(false);
       return true;
    }

    @Override
    public ArrayList<LbBook> getAllBooks() {
        // Get all active books
        Query query = em.createQuery("SELECT e FROM LbBook e where e.active = true AND e.quantity > 0");
        ArrayList<LbBook> bookList = new ArrayList<>(query.getResultList());
        return bookList;
    }

    @Override
    public ArrayList<LbBook> getBooks(String name, String type) {
        Query query;
        // check if the name is empty will get all
         System.out.println("Get All Books ");
        if (type.equals("ALL")) { 
            if (name.equals("")) {
                query = em.createQuery("SELECT e FROM LbBook e");
            } else {
                System.out.println("query name " + name);
                query = em.createQuery("SELECT e FROM LbBook e WHERE UPPER(e.name) LIKE :name");
                query.setParameter("name", "%"+name.toUpperCase()+"%");
            }
        } else {
            if (name.equals("")) {
                 query = em.createQuery("SELECT e FROM LbBook e where e.category = :category ");
                 query.setParameter("category", type);
            } else {
                
                query = em.createQuery("SELECT e FROM LbBook e WHERE UPPER(e.name) LIKE :name AND e.category = :category ");
                query.setParameter("name", "%"+name.toUpperCase()+"%");
                query.setParameter("category", type);
            }
        }
        
        ArrayList<LbBook> bookList = new ArrayList<>(query.getResultList());
        return bookList;
    }
    
    @Override
    public ArrayList<LbBook> getActiveBooks(String name, String type) {
        System.out.println("Get All Active Books ");
        Query query;
        // check if the name is empty will get all
        if (type.equals("ALL")) { 
            if (name.equals("")) {
                return getAllBooks();
            } else {
                System.out.println("query name " + name);
                query = em.createQuery("SELECT e FROM LbBook e WHERE e.quantity > 0 AND UPPER(e.name) LIKE :name AND e.active = :value");
                query.setParameter("name", "%"+name.toUpperCase()+"%");
                query.setParameter("value", true);
            }
        } else {
            if (name.equals("")) {
                 query = em.createQuery("SELECT e FROM LbBook e where e.quantity > 0 AND e.active = :trueValue AND e.category = :category ");
                 query.setParameter("trueValue", true);
                 query.setParameter("category", type);
            } else {
                
                query = em.createQuery("SELECT e FROM LbBook e WHERE e.quantity > 0 AND UPPER(e.name) LIKE :name AND e.category = :category AND e.active = :value");
                query.setParameter("name", "%"+name.toUpperCase()+"%");
                query.setParameter("category", type);
                query.setParameter("value", true);
            }
        }
        
        ArrayList<LbBook> bookList = new ArrayList<>(query.getResultList());
        return bookList;
    }

    @Override
    public boolean reserveBook(LbBorrowedBook borrowBook) {
        // Check if book is inactive and out of stock
//        if (!book.getActive() && book.getQuantity() == 0) {
//            return false;
//        }
       if (borrowBook == null) return false; 
       
       this.insertBorrowBook(borrowBook);
       return true;
    }

}
