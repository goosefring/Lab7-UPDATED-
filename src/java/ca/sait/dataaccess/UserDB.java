package ca.sait.dataaccess;


import ca.sait.models.UserdbUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import ca.sait.models.UserdbUser;
import ca.sait.models.UserdbRole;

/**
 *
 * @author Rehan Bhatti
 */
public class UserDB {

    public List<UserdbUser> getAll() throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        return em.createNamedQuery("UserdbUser.findAll", UserdbUser.class).getResultList();

    }

    public UserdbUser get(String email) throws Exception {

        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

       try {
           UserdbUser user = em.find(UserdbUser.class, email);
           
           return user;
       } 
       finally {
           em.close();
       }
    }

    public boolean insert(String email, boolean active, String first_name, String last_name, String password, UserdbRole role) {

        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        //UserdbUser user = new UserdbUser(email, active, first_name, last_name, password, role);
        
        UserdbUser user = new UserdbUser();

        user.setEmail(email);
        user.setActive(active);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setPassword(password);
        user.setRole(role);

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(user);
            trans.commit();

            return true;
        } catch (Exception ex) {
            trans.rollback();

            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(UserdbUser user) {

        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        //User user = new User();

//        user.getEmail();
//        user.getActive();
//        user.getFirstName();
//        user.getLastName();
//        user.getPassword();
//        user.getRole();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(user);
            trans.commit();

            return true;
        } catch (Exception ex) {
            trans.rollback();

            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(UserdbUser user) {

        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        //user.getEmail();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();

            return true;
        } catch (Exception ex) {
            trans.rollback();

            return false;
        } finally {
            em.close();
        }
    }

//    public List<User> getAll() throws Exception {
//        List<User> users = new ArrayList<>();
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        ResultSet usersSet = null;
//        ResultSet roleSet = null;
//
//        String getUsers = "SELECT * FROM userdb_user";
//        String getRole = "SELECT role_name FROM userdb_role where role_id=?";
//        try {
//            statement = connection.prepareStatement(getUsers);
//            usersSet = statement.executeQuery();
//            while (usersSet.next()) {
//                String email = usersSet.getString(1);
//                boolean active = usersSet.getBoolean(2);
//                String firstName = usersSet.getString(3);
//                String lastName = usersSet.getString(4);
//                String password = usersSet.getString(5);
//                int roleId = usersSet.getInt(6);
//
//                statement = connection.prepareStatement(getRole);
//                statement.setInt(1, roleId);
//                roleSet = statement.executeQuery();
//                roleSet.next();
//                Role role = new Role(roleId, roleSet.getString(1));
//
//                User user = new User(email, active, firstName, lastName, password, role);
//                users.add(user);
//
//                DBUtil.closeResultSet(roleSet);
//            }
//        } finally {
//            DBUtil.closeResultSet(usersSet);
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//        return users;
//    }
//
//    public User get(String email) throws Exception {
//        User user = null;
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        ResultSet usersSet = null;
//        ResultSet roleSet = null;
//        String sql = "SELECT * FROM userdb_user WHERE email=?";
//        String getRole = "SELECT role_name FROM userdb_role where role_id=?";
//
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, email);
//            usersSet = statement.executeQuery();
//            usersSet.next();
//            
//            String userEmail = usersSet.getString(1);
//            boolean active = usersSet.getBoolean(2);
//            String firstName = usersSet.getString(3);
//            String lastName = usersSet.getString(4);
//            String password = usersSet.getString(5);
//            int roleId = usersSet.getInt(6);
//
//            statement = connection.prepareStatement(getRole);
//            statement.setInt(1, roleId);
//            roleSet = statement.executeQuery();
//            roleSet.next();
//            Role role = new Role(roleId, roleSet.getString(1));
//
//            user = new User(email, active, firstName, lastName, password, role);
//
//        } finally {
//            DBUtil.closeResultSet(usersSet);
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//
//        return user;
//    }
//
//    public void insert(User user) throws Exception {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        String sql = "INSERT INTO userdb_user VALUES (?, ?, ?, ?, ?, ?)";
//
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, user.getEmail());
//            statement.setBoolean(2, user.getActive());
//            statement.setString(3, user.getFirstName());
//            statement.setString(4, user.getLastName());
//            statement.setString(5, user.getPassword());
//            statement.setInt(6, user.getRole().getId());
//            statement.executeUpdate();
//        } finally {
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//
//    }
//
//    public void update(User user) throws Exception {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        String sql = "UPDATE userdb_user SET active=?, first_name=?, last_name=?, password=?, role=? WHERE email=?";
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setBoolean(1, user.getActive());
//            statement.setString(2, user.getFirstName());
//            statement.setString(3, user.getLastName());
//            statement.setString(4, user.getPassword());
//            statement.setInt(5, user.getRole().getId());
//            statement.setString(6, user.getEmail());
//            statement.executeUpdate();
//        } finally {
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//    }
//
//    public void delete(User user) throws Exception {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        String sql = "DELETE FROM userdb_user WHERE email=?";
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, user.getEmail());
//            statement.executeUpdate();
//        } finally {
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//    }
}
