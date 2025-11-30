package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.RegistrasiKelas;
import dbCon.Kelas;
import dbCon.db_config;

public class KelasRepository {
    public List<Kelas> getKelasByIdDosen(String idDosen){
        String sql = "select * from kelas where nid = ?";
        List<Kelas> listKelas = new ArrayList<>();
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idDosen);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                listKelas.add(new Kelas(
                    res.getString("id_kelas"),
                    res.getString("nama_kelas"),
                    res.getString("nid"),
                    res.getString("id_matkul"),
                    res.getInt("kapasitas"))
                    );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listKelas;
    }

    public List<RegistrasiKelas> getKelasByIdMatkul(String idMatkul){
        String sql = """
            SELECT 
            k.id_kelas, k.nama_kelas, d.name, k.id_matkul, k.kapasitas,
            COALESCE(sub.jumlah_mahasiswa, 0) AS jumlah_mahasiswa
            FROM kelas k
            INNER JOIN dosen d ON k.nid = d.nid
            LEFT JOIN (
                SELECT id_kelas, COUNT(nim) AS jumlah_mahasiswa
                FROM nilai 
                WHERE status = FALSE 
                GROUP BY id_kelas
            ) sub ON k.id_kelas = sub.id_kelas
            WHERE k.id_matkul = ?
            """;
        List<RegistrasiKelas> listKelas = new ArrayList<>();
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idMatkul);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listKelas.add(new RegistrasiKelas(
                    res.getString("id_kelas"),
                    res.getString("nama_kelas"),
                    res.getString("name"),
                    res.getString("id_matkul"),
                    res.getInt("jumlah_mahasiswa"),
                    res.getInt("kapasitas"))
                    );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listKelas;
    }

    public int getKapasitasKelas(String idKelas){
        String sql = "select kapasitas from kelas where id_kelas = ?";
        int kapasitas = 0;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idKelas);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                kapasitas = res.getInt(1);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kapasitas;
    }

    // Mendapatkan semua kelas dengan informasi jadwal
    public List<RegistrasiKelas> getAllKelasWithJadwal() {
        String sql = """
            SELECT
                k.id_kelas, k.nama_kelas, d.name as nama_dosen, k.id_matkul, k.kapasitas,
                COALESCE(sub.jumlah_mahasiswa, 0) AS jumlah_mahasiswa,
                j.id_ruangan, j.hari, j.jam_mulai, j.jam_selesai
            FROM kelas k
            INNER JOIN dosen d ON k.nid = d.nid
            LEFT JOIN (
                SELECT id_kelas, COUNT(nim) AS jumlah_mahasiswa
                FROM nilai
                WHERE status = FALSE
                GROUP BY id_kelas
            ) sub ON k.id_kelas = sub.id_kelas
            LEFT JOIN jadwal_kelas j ON k.id_kelas = j.id_kelas
            """;
        List<RegistrasiKelas> listKelas = new ArrayList<>();
        try(Connection conn = db_config.getConn();
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet res = prep.executeQuery()) {
            while (res.next()) {
                RegistrasiKelas regKelas = new RegistrasiKelas(
                    res.getString("id_kelas"),
                    res.getString("nama_kelas"),
                    res.getString("nama_dosen"),
                    res.getString("id_matkul"),
                    res.getInt("jumlah_mahasiswa"),
                    res.getInt("kapasitas")
                );
                // Store additional jadwal info as needed
                listKelas.add(regKelas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKelas;
    }

    // Mendapatkan total jumlah kelas
    public int getTotalKelas() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM kelas";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {
            if (res.next()) {
                total = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    // CREATE - Menambahkan kelas baru
    public boolean createKelas(Kelas kelas) {
        String sql = "INSERT INTO kelas (id_kelas, nama_kelas, nid, id_matkul, kapasitas) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, kelas.getId_kelas());
            prep.setString(2, kelas.getNama_kelas());
            prep.setString(3, kelas.getNid());
            prep.setString(4, kelas.getId_matkul());
            prep.setInt(5, kelas.getKapasitas());
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // CREATE - Menambahkan jadwal kelas
    public boolean createJadwalKelas(String idJadwal, String idKelas, String idRuangan, String hari, String jamMulai, String jamSelesai) {
        String sql = "INSERT INTO jadwal_kelas (id_jadwal, id_kelas, id_ruangan, hari, jam_mulai, jam_selesai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idJadwal);
            prep.setString(2, idKelas);
            prep.setString(3, idRuangan);
            prep.setString(4, hari);
            prep.setString(5, jamMulai);
            prep.setString(6, jamSelesai);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE - Memperbarui data kelas
    public boolean updateKelas(Kelas kelas) {
        String sql = "UPDATE kelas SET nama_kelas = ?, nid = ?, id_matkul = ?, kapasitas = ? WHERE id_kelas = ?";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, kelas.getNama_kelas());
            prep.setString(2, kelas.getNid());
            prep.setString(3, kelas.getId_matkul());
            prep.setInt(4, kelas.getKapasitas());
            prep.setString(5, kelas.getId_kelas());
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Menghapus kelas (akan cascade ke jadwal_kelas jika ada foreign key)
    public boolean deleteKelas(String idKelas) {
        String sql = "DELETE FROM kelas WHERE id_kelas = ?";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idKelas);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
