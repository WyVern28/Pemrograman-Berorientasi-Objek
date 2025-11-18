package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbCon.Mahasiswa;
import dbCon.db_config;

public class NilaiRepository {
    public List<Mahasiswa> getMahasiswaByIdKelas(String idKelas){
        MahasiswaRepository mhsRepo = new MahasiswaRepository();
        List<Mahasiswa> listMahasiswa = new ArrayList<>();
        String sql = "select nim from nilai where id_kelas = ? and status = false";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idKelas);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                String nim = res.getString("nim");
                listMahasiswa.add(mhsRepo.getMahasiswaById(nim));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listMahasiswa;
    }

    public List<Object[]> getNilaiByNIM(String nim){
        List <Object[]> listNilai = new ArrayList<>();
        String sql = """
            select nilai.id_kelas,nama_kelas,nilai_akhir from nilai 
            inner join kelas on nilai.id_kelas = kelas.id_kelas
            where nilai.nim = ? and nilai.status = true 
            """;
            try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
                prep.setString(1, nim);
                ResultSet res = prep.executeQuery();
                while(res.next()){
                Object[] obj = new Object[3];
                obj[0] = res.getString("id_kelas");
                obj[1] = res.getString("nama_kelas");
                obj[2] = res.getInt("nilai_akhir");
                listNilai.add(obj);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listNilai;
    }
}
