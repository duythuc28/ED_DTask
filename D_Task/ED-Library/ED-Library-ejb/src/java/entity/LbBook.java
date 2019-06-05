/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iOSDev
 */
@Entity
@Table(name = "LB_BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LbBook.findAll", query = "SELECT l FROM LbBook l")
    , @NamedQuery(name = "LbBook.findByBookId", query = "SELECT l FROM LbBook l WHERE l.bookId = :bookId")
    , @NamedQuery(name = "LbBook.findByName", query = "SELECT l FROM LbBook l WHERE l.name = :name")
    , @NamedQuery(name = "LbBook.findByAuthor", query = "SELECT l FROM LbBook l WHERE l.author = :author")
    , @NamedQuery(name = "LbBook.findByDescription", query = "SELECT l FROM LbBook l WHERE l.description = :description")
    , @NamedQuery(name = "LbBook.findByQuantity", query = "SELECT l FROM LbBook l WHERE l.quantity = :quantity")
    , @NamedQuery(name = "LbBook.findByCategory", query = "SELECT l FROM LbBook l WHERE l.category = :category")
    , @NamedQuery(name = "LbBook.findByActive", query = "SELECT l FROM LbBook l WHERE l.active = :active")})
public class LbBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "BOOK_ID")
    private String bookId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "AUTHOR")
    private String author;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Size(max = 15)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "ACTIVE")
    private Boolean active;
    @OneToMany(mappedBy = "bookId")
    private Collection<LbBorrowedBook> lbBorrowedBookCollection;

    public LbBook() {
    }

    public LbBook(String bookId) {
        this.bookId = bookId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<LbBorrowedBook> getLbBorrowedBookCollection() {
        return lbBorrowedBookCollection;
    }

    public void setLbBorrowedBookCollection(Collection<LbBorrowedBook> lbBorrowedBookCollection) {
        this.lbBorrowedBookCollection = lbBorrowedBookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LbBook)) {
            return false;
        }
        LbBook other = (LbBook) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LbBook[ bookId=" + bookId + " ]";
    }
    
}
