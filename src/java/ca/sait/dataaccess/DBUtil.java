package ca.sait.dataaccess;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rehan Bhatti
 */

public class DBUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("Lab7PU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
//public class DBUtil {
//        public static void closePreparedStatement(Statement ps) {
//        try {
//            if (ps != null) {
//                ps.close();
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void closeResultSet(ResultSet rs) {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//}
