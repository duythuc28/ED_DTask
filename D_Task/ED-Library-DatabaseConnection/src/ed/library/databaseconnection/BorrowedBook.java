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
public class BorrowedBook {

    private String bookID;
    private String userID;
    private boolean isReturn;
    private Date borrowedDate;
    private Date returnDate;

    public BorrowedBook(String bookID, String userID, boolean isReturn, Date borrowedDate, Date returnDate) {
        this.bookID = bookID;
        this.userID = userID;
        this.isReturn = isReturn;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isIsReturn() {
        return isReturn;
    }

    public void setIsReturn(boolean isReturn) {
        this.isReturn = isReturn;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    
}
