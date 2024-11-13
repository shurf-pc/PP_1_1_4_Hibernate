package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class Util {
    private static final String HOST_NAME = "localhost";
    private static final String DB_NAME = "learningsql";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getMySQLConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME, USER, PASSWORD);
    }
}


