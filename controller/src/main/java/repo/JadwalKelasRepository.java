package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbCon.Hari;
import dbCon.Jadwal_kelas;
import dbCon.db_config;

public class JadwalKelasRepository {
    public List<Jadwal_kelas> getJadwalKelasByNIM(String nim){
        List<Jadwal_kelas> listJadwal = new ArrayList<>();
        String sql = """
                select * from jadwal_kelas
                inner join kelas on jadwal_kelas.id_kelas = kelas.id_kelas
                inner join nilai on kelas.id_kelas = nilai.id_kelas
                inner join mahasiswa on nilai.nim = mahasiswa.nim
                where mahasiswa.nim = ? and nilai.status = false
                """;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listJadwal.add(new Jadwal_kelas(
                    res.getString("id_jadwal"),
                    res.getString("id_kelas"),
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
}
