package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbCon.Dosen;
import dbCon.db_config;

public class DosenRepository {
    public Dosen getDosenById(String id){
        Dosen dosen = null;
        String sql = "select * from dosen where nid = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                dosen = new Dosen(res.getString("nid"),
                res.getString("name"),
                res.getString("id_prodi")
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dosen;
    }

    // Mendapatkan total jumlah dosen
    public int getTotalDosen() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM dosen";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {
            if (res.next()) {
                total = res.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    // Mendapatkan semua dosen
    public List<Dosen> getAllDosen() {
        List<Dosen> listDosen = new ArrayList<>();
        String sql = "SELECT * FROM dosen";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {
            while (res.next()) {
                Dosen dosen = new Dosen(
                    res.getString("nid"),
                    res.getString("name"),
                    res.getString("id_prodi")
                );
                listDosen.add(dosen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDosen;
    }

    // CREATE - Menambahkan dosen baru
    public boolean createDosen(Dosen dosen, String password) {
        String sqlUser = "INSERT INTO users (id_user, password, role) VALUES (?, ?, 'dosen')";
        String sqlDosen = "INSERT INTO dosen (nid, name, id_prodi) VALUES (?, ?, ?)";

        try (Connection conn = db_config.getConn()) {
            conn.setAutoCommit(false);
            try (PreparedStatement prepUser = conn.prepareStatement(sqlUser);
                 PreparedStatement prepDosen = conn.prepareStatement(sqlDosen)) {

                prepUser.setString(1, dosen.getNid());
                prepUser.setString(2, password);
                prepUser.executeUpdate();

                prepDosen.setString(1, dosen.getNid());
                prepDosen.setString(2, dosen.getNama());
                prepDosen.setString(3, dosen.getId_prodi());
                prepDosen.executeUpdate();

                conn.commit();
                return true;
            } catch (Exception e) {
                conn.rollback();
                System.err.println("Error saat menambahkan dosen:");
                System.err.println("NID: " + dosen.getNid());
                System.err.println("Nama: " + dosen.getNama());
                System.err.println("ID Prodi: " + dosen.getId_prodi());
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error koneksi database:");
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE - Memperbarui data dosen
    public boolean updateDosen(Dosen dosen) {
        String sql = "UPDATE dosen SET name = ?, id_prodi = ? WHERE nid = ?";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, dosen.getNama());
            prep.setString(2, dosen.getId_prodi());
            prep.setString(3, dosen.getNid());
            return prep.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Menghapus dosen
    public boolean deleteDosen(String nid) {
        String sqlDosen = "DELETE FROM dosen WHERE nid = ?";
        String sqlUser = "DELETE FROM users WHERE id_user = ? AND role = 'dosen'";

        try (Connection conn = db_config.getConn()) {
            conn.setAutoCommit(false);
            try (PreparedStatement prepDosen = conn.prepareStatement(sqlDosen);
                 PreparedStatement prepUser = conn.prepareStatement(sqlUser)) {

                // Hapus dari tabel dosen terlebih dahulu
                prepDosen.setString(1, nid);
                prepDosen.executeUpdate();

                // Kemudian hapus dari tabel users
                prepUser.setString(1, nid);
                prepUser.executeUpdate();

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
}
