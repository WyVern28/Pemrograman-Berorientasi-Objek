package repo; // Pastikan package-nya benar

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.TagihanDTO;
import dbCon.db_config;

public class KeuanganRepository {

    public double getHargaPerSKS() {
        double harga = 0;
        String sql = "SELECT jumlah FROM master_biaya WHERE id_biaya = 'SKS'";
        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {
            if (res.next()) {
                harga = res.getDouble("jumlah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return harga;
    }

    public List<TagihanDTO> getTagihanByNIM(String nim) {
        List<TagihanDTO> listTagihan = new ArrayList<>();
        double hargaPerSks = getHargaPerSKS();

        String sql = """
            SELECT n.id_nilai, m.nama_matkul, m.sks, n.status_bayar
            FROM nilai n
            JOIN kelas k ON n.id_kelas = k.id_kelas
            JOIN matkul m ON k.id_matkul = m.id_matkul
            WHERE n.nim = ?
            ORDER BY n.status_bayar ASC, m.nama_matkul ASC
            """;

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();

            while (res.next()) {
                int sks = res.getInt("sks");
                double totalHarga = sks * hargaPerSks;

                listTagihan.add(new TagihanDTO(
                        res.getString("id_nilai"),
                        res.getString("nama_matkul"),
                        sks,
                        totalHarga,
                        res.getString("status_bayar")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTagihan;
    }

    public boolean bayarTagihan(List<String> listIdNilai) {
        if (listIdNilai.isEmpty()) return false;

        StringBuilder sql = new StringBuilder("UPDATE nilai SET status_bayar = 'LUNAS' WHERE id_nilai IN (");
        for (int i = 0; i < listIdNilai.size(); i++) {
            sql.append(i == 0 ? "?" : ",?");
        }
        sql.append(")");

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < listIdNilai.size(); i++) {
                prep.setString(i + 1, listIdNilai.get(i));
            }

            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}