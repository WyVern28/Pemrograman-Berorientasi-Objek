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

    public static Connection getConn() {
        try {
            //cek conn
            if (conn == null || conn.isClosed()) {
                //buat koneksi baru (kalo koneksi gd)
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        } catch (SQLException e) {
            //tampil error (gui)
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + e.getMessage(), "Error Koneksi", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return conn;
    }
    public static void closeConn() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Koneksi sudah ditutup..");
            }
        } catch (SQLException e) {
            System.err.println("Gagal tutup koneksi: " + e.getMessage());
        }
    }
    //tes sederhana utk koneksi
    public static void main(String[] args) {
        Connection tesKoneksi = db_config.getConn();
        if (tesKoneksi != null) {
            System.out.println("Tes koneksi berhasil!");
            db_config.closeConn();
        } else {
            System.out.println("Tes koneksi gagal.");
        }
    }
}
