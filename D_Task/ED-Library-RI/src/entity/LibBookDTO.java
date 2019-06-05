/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author iOSDev
 */
public class LibBookDTO {
    private String bookId;
    private String name;
    private String author;
    private String description;
    private String category;
    private Boolean active;
    private int quantity;

    public LibBookDTO(String bookId, String name, String author, String description, String category, Boolean active, int quantity) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.category = category;
        this.active = active;
        this.quantity = quantity;
    }

   

    public int getQuantity() {
        return quantity;
    }

    
    public String getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getActive() {
        return active;
    }
    
}
