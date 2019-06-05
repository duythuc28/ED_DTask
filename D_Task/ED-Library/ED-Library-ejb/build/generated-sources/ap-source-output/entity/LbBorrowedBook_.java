package entity;

import entity.LbBook;
import entity.LbUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-05T17:27:34")
@StaticMetamodel(LbBorrowedBook.class)
public class LbBorrowedBook_ { 

    public static volatile SingularAttribute<LbBorrowedBook, Boolean> isReturn;
    public static volatile SingularAttribute<LbBorrowedBook, Date> borrowedDate;
    public static volatile SingularAttribute<LbBorrowedBook, Integer> borrowId;
    public static volatile SingularAttribute<LbBorrowedBook, LbUser> userId;
    public static volatile SingularAttribute<LbBorrowedBook, Date> returnedDate;
    public static volatile SingularAttribute<LbBorrowedBook, LbBook> bookId;

}