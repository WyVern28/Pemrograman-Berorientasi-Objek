package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbCon.SuperAdmin;
import dbCon.db_config;

public class SuperAdminRepository {

    // CREATE - Menambahkan SuperAdmin baru
    public boolean createSuperAdmin(SuperAdmin admin, String password) {
        String sqlUser = "INSERT INTO users (id_user, password, role) VALUES (?, ?, 'superadmin')";
        String sqlAdmin = "INSERT INTO superadmin (id_sa, nama, jabatan, kontak) VALUES (?, ?, ?, ?)";

        try (Connection conn = db_config.getConn()) {
            conn.setAutoCommit(false);

            try (PreparedStatement prepUser = conn.prepareStatement(sqlUser);
                 PreparedStatement prepAdmin = conn.prepareStatement(sqlAdmin)) {

                // Insert ke tabel users
                prepUser.setString(1, admin.getId_sa());
                prepUser.setString(2, password);
                prepUser.executeUpdate();

                // Insert ke tabel superadmin
                prepAdmin.setString(1, admin.getId_sa());
                prepAdmin.setString(2, admin.getNama());
                prepAdmin.setString(3, admin.getJabatan());
                prepAdmin.setString(4, admin.getKontak());
                prepAdmin.executeUpdate();

                conn.commit();
                return true;
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ - Mendapatkan SuperAdmin berdasarkan ID
    public SuperAdmin getSuperAdminById(String id){
        SuperAdmin admin = null;
        String sql = "select * from superadmin where id_sa = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                admin = new SuperAdmin(res.getString("id_sa"),
                res.getString("nama"),
                res.getString("jabatan"),
                res.getString("kontak")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    // READ ALL - Mendapatkan semua SuperAdmin
    public List<SuperAdmin> getAllSuperAdmin() {
        List<SuperAdmin> adminList = new ArrayList<>();
        String sql = "SELECT * FROM superadmin";

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {

            while (res.next()) {
                SuperAdmin admin = new SuperAdmin(
                    res.getString("id_sa"),
                    res.getString("nama"),
                    res.getString("jabatan"),
                    res.getString("kontak")
                );
                adminList.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminList;
    }

    // UPDATE - Memperbarui data SuperAdmin
    public boolean updateSuperAdmin(SuperAdmin admin) {
        String sql = "UPDATE superadmin SET nama = ?, jabatan = ?, kontak = ? WHERE id_sa = ?";

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, admin.getNama());
            prep.setString(2, admin.getJabatan());
            prep.setString(3, admin.getKontak());
            prep.setString(4, admin.getId_sa());

            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE PASSWORD - Memperbarui password SuperAdmin
    public boolean updatePassword(String id, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE id_user = ? AND role = 'superadmin'";

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, newPassword);
            prep.setString(2, id);

            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Menghapus SuperAdmin (akan otomatis menghapus user karena CASCADE)
    public boolean deleteSuperAdmin(String id) {
        String sql = "DELETE FROM users WHERE id_user = ? AND role = 'superadmin'";

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, id);
            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // CHECK - Mengecek apakah ID sudah ada
    public boolean isIdExist(String id) {
        String sql = "SELECT COUNT(*) FROM superadmin WHERE id_sa = ?";

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, id);
            ResultSet res = prep.executeQuery();

            if (res.next()) {
                return res.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
