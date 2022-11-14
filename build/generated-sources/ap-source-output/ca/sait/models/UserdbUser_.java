package ca.sait.models;

import ca.sait.models.UserdbRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-14T12:57:08")
@StaticMetamodel(UserdbUser.class)
public class UserdbUser_ { 

    public static volatile SingularAttribute<UserdbUser, String> firstName;
    public static volatile SingularAttribute<UserdbUser, String> lastName;
    public static volatile SingularAttribute<UserdbUser, String> password;
    public static volatile SingularAttribute<UserdbUser, UserdbRole> role;
    public static volatile SingularAttribute<UserdbUser, Boolean> active;
    public static volatile SingularAttribute<UserdbUser, String> email;

}