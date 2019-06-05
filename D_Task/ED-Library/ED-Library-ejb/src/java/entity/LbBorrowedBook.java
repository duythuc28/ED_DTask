/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iOSDev
 */
@Entity
@Table(name = "LB_BORROWED_BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LbBorrowedBook.findAll", query = "SELECT l FROM LbBorrowedBook l")
    , @NamedQuery(name = "LbBorrowedBook.findByBorrowId", query = "SELECT l FROM LbBorrowedBook l WHERE l.borrowId = :borrowId")
    , @NamedQuery(name = "LbBorrowedBook.findByIsReturn", query = "SELECT l FROM LbBorrowedBook l WHERE l.isReturn = :isReturn")
    , @NamedQuery(name = "LbBorrowedBook.findByBorrowedDate", query = "SELECT l FROM LbBorrowedBook l WHERE l.borrowedDate = :borrowedDate")
    , @NamedQuery(name = "LbBorrowedBook.findByReturnedDate", query = "SELECT l FROM LbBorrowedBook l WHERE l.returnedDate = :returnedDate")})
public class LbBorrowedBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BORROW_ID")
    private Integer borrowId;
    @Column(name = "IS_RETURN")
    private Boolean isReturn;
    @Column(name = "BORROWED_DATE")
    @Temporal(TemporalType.DATE)
    private Date borrowedDate;
    @Column(name = "RETURNED_DATE")
    @Temporal(TemporalType.DATE)
    private Date returnedDate;
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
    @ManyToOne
    private LbBook bookId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private LbUser userId;

    public LbBorrowedBook() {
    }

    public LbBorrowedBook(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public LbBook getBookId() {
        return bookId;
    }

    public void setBookId(LbBook bookId) {
        this.bookId = bookId;
    }

    public LbUser getUserId() {
        return userId;
    }

    public void setUserId(LbUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowId != null ? borrowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LbBorrowedBook)) {
            return false;
        }
        LbBorrowedBook other = (LbBorrowedBook) object;
        if ((this.borrowId == null && other.borrowId != null) || (this.borrowId != null && !this.borrowId.equals(other.borrowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LbBorrowedBook[ borrowId=" + borrowId + " ]";
    }
    
}
