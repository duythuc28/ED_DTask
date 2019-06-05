/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.library.databaseconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author iOSDev
 */
public class SetUpEmsEmployeeDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SetUpEmsEmployeeDB myEmsEmployeeDB = new SetUpEmsEmployeeDB();

//myEmsEmployeeDB.dropEmsEmployeeTable();
        myEmsEmployeeDB.createLibraryUserTable();
        myEmsEmployeeDB.createBookTable();
        myEmsEmployeeDB.createBorrowBookTable();
        myEmsEmployeeDB.addBook();
        myEmsEmployeeDB.addUser();
    }
    
    public void addBook() {        
        Book book1 = new Book("0001", "Study Java", "Uncle Bob", "This is a new book", 5, "Programming", true);
        Book book2 = new Book("0002", "Sherlock Holmes", "Sir Athur Conan Doyle", "This is a new book", 5, "Fiction", true);
        Book book3 = new Book("0003", "Moby-Dick", "Herman Melville.", "This is a new book", 2, "Novel", true);
        Book book4 = new Book("0004", "It", "Stephen King", "This is a new book", 3, "Horror", true);
        Book book5 = new Book("0005", "The Notebook", "Nicholas Sparks", "This is a new book", 5, "Romantic", true);
        ArrayList<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        addBookRecords(list);
    }
    
    public void addUser() {        
        String password = "123456";
        String hashPassword = MyHash.getSHA256HashedString(password);
        User user1 = new User("0001", "Adam Smith", hashPassword,
                "adam@gmail.com", "123456", "123 Melbourne", "ADMIN", true, password);
        User user2 = new User("0002", "Ronaldo", hashPassword,
                "ronaldo@gmail.com", "123456", "123 Melbourne", "LIBRARIAN", true, password);
        User user3 = new User("0003", "Iron Man", hashPassword,
                "tony@gmail.com", "123456", "123 Melbourne", "STUDENT", true, password);
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        addUserRecords(list);
    }
    
    public static Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost/sun-appserv-library;create=true";
        String username = "APP";
        String password = "APP";
        return DriverManager.getConnection(url, username, password);
    }
    
    public void createLibraryUserTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            stmnt.execute("CREATE TABLE LB_USER ( "
                    + "USER_ID CHAR(6), "
                    + "NAME VARCHAR(50), "
                    + "PASSWORD CHAR(64), "
                    + "EMAIL VARCHAR(50), "
                    + "PHONE VARCHAR(10), "
                    + "ADDRESS VARCHAR(50), "
                    + "APPGROUP VARCHAR(15), "
                    + "ACTIVE BOOLEAN, "
                    + "MEMO VARCHAR(255), "
                    + "CONSTRAINT PK_USER PRIMARY KEY (USER_ID))");
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
    
    public void dropEmsEmployeeTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            stmnt.execute("DROP TABLE LB_BORROWED_BOOK");
            stmnt.execute("DROP TABLE LB_USER");
            stmnt.execute("DROP TABLE LB_BOOK");
           
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
    
    
    
    public void createBookTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            stmnt.execute("CREATE TABLE LB_Book ( "
                    + "BOOK_ID CHAR(6), "
                    + "NAME VARCHAR(50), "
                    + "AUTHOR VARCHAR (50), "
                    + "DESCRIPTION VARCHAR(100), "
                    + "QUANTITY INTEGER, "
                    + "CATEGORY VARCHAR(15), "
                    + "ACTIVE BOOLEAN, "
                    + "CONSTRAINT PK_BOOKID PRIMARY KEY (BOOK_ID))");
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
    
    public void createBorrowBookTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            stmnt.execute("CREATE TABLE LB_Borrowed_Book ( "
                    + "BORROW_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
                    + "BOOK_ID CHAR(6), "
                    + "USER_ID CHAR(6), "
                    + "IS_RETURN BOOLEAN, "
                    + "BORROWED_DATE DATE, "
                    + "RETURNED_DATE DATE, "
                    + "CONSTRAINT PK_BORROW_ID PRIMARY KEY (BORROW_ID),"
                    + "FOREIGN KEY (USER_ID) REFERENCES LB_USER (USER_ID),"
                    + "FOREIGN KEY (BOOK_ID) REFERENCES LB_Book (BOOK_ID))");
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
    
    public void addBookRecords(ArrayList<Book> books) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement
                    = "INSERT INTO LB_BOOK VALUES (?, ?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            for (Book book : books) {
                pStmnt.setString(1, book.getBookID());
                pStmnt.setString(2, book.getName());
                pStmnt.setString(3, book.getAuthor());
                pStmnt.setString(4, book.getDescription());
                pStmnt.setInt(5, book.getQuantity());
                pStmnt.setString(6, book.getCategory());
                pStmnt.setBoolean(7, book.isActive());
                
                int rowCount = pStmnt.executeUpdate();
                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
    
    public void addUserRecords(ArrayList<User> users) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement
                    = "INSERT INTO LB_USER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            for (User user : users) {
                pStmnt.setString(1, user.getUserID());
                pStmnt.setString(2, user.getName());
                pStmnt.setString(3, user.getPassword());
                pStmnt.setString(4, user.getEmail());
                pStmnt.setString(5, user.getPhone());
                pStmnt.setString(6, user.getAddress());
                pStmnt.setString(7, user.getAppGroup());
                pStmnt.setBoolean(8, user.isActive());
                pStmnt.setString(9, user.getMemo());
                
                int rowCount = pStmnt.executeUpdate();
                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
}
