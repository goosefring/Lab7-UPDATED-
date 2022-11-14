package ca.sait.models;

import ca.sait.models.UserdbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-14T12:57:08")
@StaticMetamodel(UserdbRole.class)
public class UserdbRole_ { 

    public static volatile SingularAttribute<UserdbRole, String> name;
    public static volatile SingularAttribute<UserdbRole, Integer> id;
    public static volatile ListAttribute<UserdbRole, UserdbUser> userdbUserList;

}