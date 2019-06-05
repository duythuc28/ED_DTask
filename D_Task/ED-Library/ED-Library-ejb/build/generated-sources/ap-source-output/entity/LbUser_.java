package entity;

import entity.LbBorrowedBook;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-05T17:27:34")
@StaticMetamodel(LbUser.class)
public class LbUser_ { 

    public static volatile SingularAttribute<LbUser, String> password;
    public static volatile SingularAttribute<LbUser, String> address;
    public static volatile SingularAttribute<LbUser, String> phone;
    public static volatile SingularAttribute<LbUser, String> appgroup;
    public static volatile SingularAttribute<LbUser, String> name;
    public static volatile SingularAttribute<LbUser, Boolean> active;
    public static volatile SingularAttribute<LbUser, String> memo;
    public static volatile SingularAttribute<LbUser, String> userId;
    public static volatile SingularAttribute<LbUser, String> email;
    public static volatile CollectionAttribute<LbUser, LbBorrowedBook> lbBorrowedBookCollection;

}