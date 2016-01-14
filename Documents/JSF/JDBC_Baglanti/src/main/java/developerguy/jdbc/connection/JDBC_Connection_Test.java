package developerguy.jdbc.connection;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  *
 *  * @author Batuhan  
 */


enum Properties {
    DRIVER_CLASS("oracle.jdbc.driver.OracleDriver"), CONNECTION_URL("jdbc:oracle:thin:@localhost:1521:xe"),
    USER_NAME("HR"), PASSWORD("12345");
    public String property;

    Properties(String property) {
        this.property = property;
    }
}

public class JDBC_Connection_Test {

    public static void main(String[] args) {

        Connection connection = JDBC_Connection_Test.getConnection();

        if (connection != null) {

            System.out.println("Connection success!");

        } else {

            System.out.println("Connection failed!");

        }

    }

    public static Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName(Properties.DRIVER_CLASS.property);
        } catch (ClassNotFoundException cnfe) {

            System.out.println(cnfe.getMessage());
        }
        try {
            connection = DriverManager.getConnection(Properties.CONNECTION_URL.property,
                    Properties.USER_NAME.property, Properties.PASSWORD.property
            );
            if (connection != null) {
                return connection;
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return connection;
    }
}
