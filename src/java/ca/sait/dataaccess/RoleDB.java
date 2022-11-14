package ca.sait.dataaccess;

import ca.sait.models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import models.Role;

/**
 *
 * @author Rehan Bhatti
 */
public class RoleDB {

    public List<Role> getAll() throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        return em.createNamedQuery("UserdbRole.findAll", Role.class).getResultList();
    }
//    public List<Role> getAll() throws Exception {
//        List<Role> roles = new ArrayList<>();
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        
//        String sql = "SELECT * FROM userdb_role";
//        
//        try {
//            statement = connection.prepareStatement(sql);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int roleId = resultSet.getInt(1);
//                String roleName = resultSet.getString(2);
//                Role role = new Role(roleId, roleName);
//                roles.add(role);
//            }
//        } finally {
//            DBUtil.closeResultSet(resultSet);
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//        
//        return roles;
//    }
}
