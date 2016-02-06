package com.mycompany.jdbc.ile.oracle.tablo.olusturma;

import developerguy.jdbc.connection.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class CreateTableTest {

    public static void main(String[] args) {
        try {
            Boolean test = createTableTest();
            if (test) {
                
                System.out.println("Table is created successfully");
            } else {
                System.out.println("Table is not created,fail");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Boolean createTableTest() {
        String createTableQuery = ""
                + "CREATE TABLE user_test"
                + "("
                + "id NUMBER(2) PRIMARY KEY,"
                + "user_name VARCHAR2(20),"
                + "user_last_name VARCHAR2(20),"
                + "created_date DATE"
                + ")";
        
        Connection connection = null;
        
        PreparedStatement preparedStatement = null;
        
        try {
            connection = JDBCUtil.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(createTableQuery);

                preparedStatement.executeUpdate();

                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (SQLException se) {
            System.out.println(se.getLocalizedMessage());
        } finally {
            JDBCUtil.close(preparedStatement, connection);
        }
        return null;
    }
}
