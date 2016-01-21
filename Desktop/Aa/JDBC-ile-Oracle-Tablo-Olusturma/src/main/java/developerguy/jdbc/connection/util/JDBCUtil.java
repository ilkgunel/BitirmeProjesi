package developerguy.jdbc.connection.util;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  *
 *  * @author Batuhan  
 *
 */
public class JDBCUtil {

    private static String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USER_NAME = "HR";
    private static String PASSWORD = "12345";

    public static Connection getConnection() {

        Connection connection = null;
        
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
        try {
            connection = DriverManager.getConnection(CONNECTION_URL,
                    USER_NAME, PASSWORD);
            if (connection != null) {
                return connection;
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return connection;
    }

    public static void close(PreparedStatement ps, Connection con) {
        try {
            if (ps != null && con != null) {
                ps.close();
                con.close();
            }
        } catch (SQLException se) {
            System.out.println(se.getLocalizedMessage());
        }
    }
}
