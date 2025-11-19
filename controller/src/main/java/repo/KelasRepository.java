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
}
