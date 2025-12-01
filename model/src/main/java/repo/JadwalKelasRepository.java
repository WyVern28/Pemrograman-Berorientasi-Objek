package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.JadwalDTO;
import dbCon.Hari;
import dbCon.Jadwal_kelas;
import dbCon.db_config;

public class JadwalKelasRepository {
    public List<JadwalDTO> getJadwalKelasByNIM(String nim){
        List<JadwalDTO> listJadwal = new ArrayList<>();
        String sql = """
                select kelas.nama_kelas,id_ruangan,hari,jam_mulai,jam_selesai from jadwal_kelas
                inner join kelas on jadwal_kelas.id_kelas = kelas.id_kelas
                inner join nilai on kelas.id_kelas = nilai.id_kelas
                inner join mahasiswa on nilai.nim = mahasiswa.nim
                where mahasiswa.nim = ? and nilai.status = false
                """;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listJadwal.add(new JadwalDTO(
                    res.getString("nama_kelas"),
                    res.getString("id_ruangan"),
                    Hari.valueOf(res.getString("hari").toLowerCase()),
                    res.getTime("jam_mulai").toLocalTime(),
                    res.getTime("jam_selesai").toLocalTime())
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listJadwal;
    }
    public Jadwal_kelas getJadwalByIdKelas(String idKelas){
        Jadwal_kelas jadwal = null;
        String sql = "select * from jadwal_kelas where id_kelas = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idKelas);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                jadwal = new Jadwal_kelas(
                    res.getString("id_jadwal"),
                    res.getString("id_kelas"),
                    res.getString("id_ruangan"),
                    Hari.valueOf(res.getString("hari").toLowerCase()),
                    res.getTime("jam_mulai").toLocalTime(),
                    res.getTime("jam_selesai").toLocalTime()
                    );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return jadwal;
    }

    public boolean isJadwalBentrok(String idRuangan, String hari, String jamMulai, String jamSelesai) {
        String sql = """
            SELECT COUNT(*) FROM jadwal_kelas 
            WHERE id_ruangan = ? 
            AND hari = ? 
            AND (jam_mulai < ? AND jam_selesai > ?)
            """;

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, idRuangan);
            prep.setString(2, hari);
            prep.setString(3, jamSelesai);
            prep.setString(4, jamMulai);
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
