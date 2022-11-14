package ca.sait.services;

import ca.sait.dataaccess.UserDB;
import java.sql.*;
import java.util.List;
import ca.sait.models.UserdbUser;
import ca.sait.models.UserdbRole;

/**
 *
 * @author Rehan Bhatti
 */
public class UserService {


    public List<UserdbUser> getAll() throws Exception {

        UserDB userDB = new UserDB();
        
        List<UserdbUser> users = userDB.getAll();

        return users;
    }
    
    public UserdbUser get(String email) throws Exception {
        
        UserDB userDB = new UserDB();
        
        UserdbUser user = userDB.get(email);
        
        return user;
    }

    public boolean insert(String email, boolean active, String first_name, String last_name, String password, UserdbRole role) throws Exception {

        UserDB userDB = new UserDB();
        
        boolean inserted = userDB.insert(email, active, first_name, last_name, password, role);

        return inserted;
    }

    public boolean update(String email, boolean activity, String first_name, String last_name, String password, UserdbRole role) throws Exception {
        UserDB userDB = new UserDB();
        
        UserdbUser user = userDB.get(email);
        
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setRole(role);
        
        boolean updated = userDB.update(user);
        
        return updated;
    }
//
    public boolean delete(String email) throws Exception {
        
        UserDB userDB = new UserDB();
        
        UserdbUser user = userDB.get(email);
        
        boolean deleted = userDB.delete(user);
        
        return deleted;
    }
//    public List<User> getAll() throws Exception {
//        UserDB userDB = new UserDB();
//        List<User> users = userDB.getAll();
//        return users;
//    }
//    public User get(String email) throws Exception {
//        UserDB userDB = new UserDB();
//        User user = userDB.get(email);
//        return user;
//    }
//    
//    public void insert(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
//        User user = new User(email, activity, first_name, last_name, password, role);
//        UserDB userDB = new UserDB();
//        userDB.insert(user);
//    }
//    
//    public void update(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
//        UserDB userDB = new UserDB();
//        User user = userDB.get(email);
//        user.setFirstName(first_name);
//        user.setLastName(last_name);
//        user.setRole(role);
//        userDB.update(user);
//    }
//    
//    public void delete(String email) throws Exception{
//        UserDB userDB = new UserDB();
//        User user = userDB.get(email);
//        userDB.delete(user);
//    }
}
