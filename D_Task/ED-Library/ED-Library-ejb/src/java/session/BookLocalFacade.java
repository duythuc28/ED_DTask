/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.LbBook;
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
        Query query = em.createQuery("SELECT e FROM LbBook e where e.active = true");
        ArrayList<LbBook> bookList = new ArrayList<>(query.getResultList());
        return bookList;
    }

    @Override
    public ArrayList<LbBook> getBooks(String name, String type) {
        Query query;
        // check if the name is empty will get all
        if (type.equals("ALL")) { 
            if (name.equals("")) {
                return getAllBooks();
            } else {
                System.out.println("query name " + name);
                query = em.createQuery("SELECT e FROM LbBook e WHERE UPPER(e.name) LIKE :name AND e.active = :value");
                query.setParameter("name", "%"+name.toUpperCase()+"%");
                query.setParameter("value", true);
            }
        } else {
            if (name.equals("")) {
                 query = em.createQuery("SELECT e FROM LbBook e where e.active = :trueValue AND e.category = :category ");
                 query.setParameter("trueValue", true);
                 query.setParameter("category", type);
            } else {
                
                query = em.createQuery("SELECT e FROM LbBook e WHERE UPPER(e.name) LIKE :name AND e.category = :category AND e.active = :value");
                query.setParameter("name", "%"+name.toUpperCase()+"%");
                query.setParameter("category", type);
                query.setParameter("value", true);
            }
        }
        
        ArrayList<LbBook> bookList = new ArrayList<>(query.getResultList());
        return bookList;
    }

    @Override
    public boolean reserveBook(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
