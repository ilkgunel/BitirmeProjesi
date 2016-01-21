package com.mycompany.jdbc.ile.oracle.tablo.olusturma;

import developerguy.jdbc.connection.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class InsertTableTest {

    public static void main(String[] args) {
        try {
            Boolean test = insertTableTest();
            if (test) {
                System.out.println("Data is inserted successfully");
            } else {
                System.out.println("Data is not inserted,fail");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Boolean insertTableTest() {
        String createTableQuery = "INSERT INTO user_test(id,user_name,user_last_name,created_date) VALUES(?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(createTableQuery);

                preparedStatement.setInt(1, (int) (new Random().nextInt(9) + 1));
                preparedStatement.setString(2, "Batuhan");
                preparedStatement.setString(3, "Apaydın");
                preparedStatement.setDate(4, JDBCUtil.getSQLDate());
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
