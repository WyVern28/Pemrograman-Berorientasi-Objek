package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbCon.Mahasiswa;
import dbCon.db_config;

public class MahasiswaRepository {
    public Mahasiswa getMahasiswaById(String id){
        Mahasiswa mhs = null;
        String sql = "select * from mahasiswa where nim = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                mhs = new Mahasiswa(
                    res.getString("nim"),
                    res.getString("name"),
                    res.getString("id_prodi"),
                    res.getFloat("ipk"),
                    res.getInt("total_sks")
                    );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return mhs;
    }

    // Mendapatkan total jumlah mahasiswa
    public int getTotalMahasiswa() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM mahasiswa";
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

    // Mendapatkan semua mahasiswa
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> listMahasiswa = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {
            while (res.next()) {
                Mahasiswa mhs = new Mahasiswa(
                    res.getString("nim"),
                    res.getString("name"),
                    res.getString("id_prodi"),
                    res.getFloat("ipk"),
                    res.getInt("total_sks")
                );
                listMahasiswa.add(mhs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMahasiswa;
    }

    // CREATE - Menambahkan mahasiswa baru
    public boolean createMahasiswa(Mahasiswa mahasiswa, String password) {
        String sqlUser = "INSERT INTO users (id_user, password, role) VALUES (?, ?, 'mahasiswa')";
        String sqlMahasiswa = "INSERT INTO mahasiswa (nim, name, id_prodi, ipk, total_sks) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = db_config.getConn()) {
            conn.setAutoCommit(false);
            try (PreparedStatement prepUser = conn.prepareStatement(sqlUser);
                 PreparedStatement prepMahasiswa = conn.prepareStatement(sqlMahasiswa)) {

                prepUser.setString(1, mahasiswa.getNim());
                prepUser.setString(2, password);
                prepUser.executeUpdate();

                prepMahasiswa.setString(1, mahasiswa.getNim());
                prepMahasiswa.setString(2, mahasiswa.getNama());
                prepMahasiswa.setString(3, mahasiswa.getId_prodi());
                prepMahasiswa.setFloat(4, mahasiswa.getIpk());
                prepMahasiswa.setInt(5, mahasiswa.getTotalSks());
                prepMahasiswa.executeUpdate();

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

    // UPDATE - Memperbarui data mahasiswa
    public boolean updateMahasiswa(Mahasiswa mahasiswa) {
        String sql = "UPDATE mahasiswa SET name = ?, id_prodi = ?, ipk = ?, total_sks = ? WHERE nim = ?";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, mahasiswa.getNama());
            prep.setString(2, mahasiswa.getId_prodi());
            prep.setFloat(3, mahasiswa.getIpk());
            prep.setInt(4, mahasiswa.getTotalSks());
            prep.setString(5, mahasiswa.getNim());
            return prep.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Menghapus mahasiswa
    public boolean deleteMahasiswa(String nim) {
        String sqlMahasiswa = "DELETE FROM mahasiswa WHERE nim = ?";
        String sqlUser = "DELETE FROM users WHERE id_user = ? AND role = 'mahasiswa'";

        try (Connection conn = db_config.getConn()) {
            conn.setAutoCommit(false);
            try (PreparedStatement prepMahasiswa = conn.prepareStatement(sqlMahasiswa);
                 PreparedStatement prepUser = conn.prepareStatement(sqlUser)) {

                // Hapus dari tabel mahasiswa terlebih dahulu
                prepMahasiswa.setString(1, nim);
                prepMahasiswa.executeUpdate();

                // Kemudian hapus dari tabel users
                prepUser.setString(1, nim);
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
