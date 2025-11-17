package dbCon;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_config {
    private static Connection conn;
    //link db
    private static final String DB_URL = "jdbc:mysql://localhost:3306/siasat";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public static Connection getConn() throws SQLException{
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return conn;
    }
}
