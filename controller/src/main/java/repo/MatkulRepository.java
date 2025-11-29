package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbCon.Matkul;
import dbCon.db_config;

public class MatkulRepository {
    public List<Matkul> getMatkulByIdProdi(String idProdi){
        String sql = """
                select * from matkul
                inner join prodi on matkul.id_prodi = prodi.id_prodi
                where matkul.id_prodi = ?
                """;
        List<Matkul> listMatkul = new ArrayList<>();
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idProdi);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                listMatkul.add(new Matkul(
                    res.getString("id_matkul"),
                    res.getString("nama_matkul"),
                    res.getString("id_prodi"),
                    res.getInt("sks"))
                    );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listMatkul;
    }

    // Mendapatkan total jumlah mata kuliah
    public int getTotalMatkul() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM matkul";
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

    // Mendapatkan semua mata kuliah
    public List<Matkul> getAllMatkul() {
        List<Matkul> listMatkul = new ArrayList<>();
        String sql = "SELECT * FROM matkul";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {
            while (res.next()) {
                Matkul matkul = new Matkul(
                    res.getString("id_matkul"),
                    res.getString("nama_matkul"),
                    res.getString("id_prodi"),
                    res.getInt("sks")
                );
                listMatkul.add(matkul);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMatkul;
    }

    // CREATE - Menambahkan mata kuliah baru
    public boolean createMatkul(Matkul matkul) {
        String sql = "INSERT INTO matkul (id_matkul, nama_matkul, id_prodi, sks) VALUES (?, ?, ?, ?)";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, matkul.getId_matkul());
            prep.setString(2, matkul.getNama_matkul());
            prep.setString(3, matkul.getId_prodi());
            prep.setInt(4, matkul.getSks());
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error saat menambahkan mata kuliah:");
            System.err.println("ID Matkul: " + matkul.getId_matkul());
            System.err.println("Nama Matkul: " + matkul.getNama_matkul());
            System.err.println("ID Prodi: " + matkul.getId_prodi());
            System.err.println("SKS: " + matkul.getSks());
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE - Memperbarui data mata kuliah
    public boolean updateMatkul(Matkul matkul) {
        String sql = "UPDATE matkul SET nama_matkul = ?, id_prodi = ?, sks = ? WHERE id_matkul = ?";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, matkul.getNama_matkul());
            prep.setString(2, matkul.getId_prodi());
            prep.setInt(3, matkul.getSks());
            prep.setString(4, matkul.getId_matkul());
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Menghapus mata kuliah
    public boolean deleteMatkul(String idMatkul) {
        String sql = "DELETE FROM matkul WHERE id_matkul = ?";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idMatkul);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
