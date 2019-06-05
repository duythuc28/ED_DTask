package entity;

import entity.LbBorrowedBook;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-05T23:12:18")
@StaticMetamodel(LbBook.class)
public class LbBook_ { 

    public static volatile SingularAttribute<LbBook, Integer> quantity;
    public static volatile SingularAttribute<LbBook, String> author;
    public static volatile SingularAttribute<LbBook, String> name;
    public static volatile SingularAttribute<LbBook, String> description;
    public static volatile SingularAttribute<LbBook, Boolean> active;
    public static volatile SingularAttribute<LbBook, String> category;
    public static volatile SingularAttribute<LbBook, String> bookId;
    public static volatile CollectionAttribute<LbBook, LbBorrowedBook> lbBorrowedBookCollection;

}