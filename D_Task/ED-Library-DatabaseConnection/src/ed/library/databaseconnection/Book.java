/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.library.databaseconnection;

import java.sql.Date;

/**
 *
 * @author iOSDev
 */
public class Book {
    private String bookID;
    private String name;
    private String author;
    private String description;
    private int quantity;
    private String category;
    private boolean active;

    public Book(String bookID, String name, String author, String description, int quantity, String category, boolean active) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        this.active = active;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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
    
    
    
}
