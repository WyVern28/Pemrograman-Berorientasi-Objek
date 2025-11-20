package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.LihatMahasiswa;
import DTO.TranskripNilai;
import dbCon.db_config;

public class NilaiRepository {
    public List<LihatMahasiswa> getMahasiswaByIdKelas(String idKelas){
        List<LihatMahasiswa> listMahasiswa = new ArrayList<>();
        String sql = """
                select nilai.nim,mahasiswa.name from kelas
                inner join nilai on kelas.id_kelas = nilai.id_kelas
                inner join mahasiswa on nilai.nim = mahasiswa.nim
                where kelas.id_kelas = ? and status = false
                """;;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idKelas);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listMahasiswa.add(new LihatMahasiswa(res.getString("nim"),
                res.getString("name"))
            );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listMahasiswa;
    }

    public List<TranskripNilai> getTranskripNilaiByNIM(String nim){
        List <TranskripNilai> listNilai = new ArrayList<>();
        String sql = """
            select nilai.id_kelas,nama_kelas,nilai_akhir from nilai 
            inner join kelas on nilai.id_kelas = kelas.id_kelas
            where nilai.nim = ? and nilai.status = true 
            """;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                listNilai.add(new TranskripNilai(
                res.getString("id_kelas"),
                res.getString("nama_kelas"),
                res.getInt("nilai_akhir"))
                );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listNilai;
    }

    public boolean updateNilai(String idKelas,String nim,double nilai){
        int update = 0;
        String sql = "update nilai set nilai_akhir = ?, status = true where nim = ? and id_kelas = ? and status = false";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setDouble(1, nilai);
            prep.setString(2, nim);
            prep.setString(3, idKelas);
            update = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return update == 1;
    }

    public int cekBanyakMahasiswa(String idKelas){
        int count = 0;
        String sql = "select count(nim) from nilai where id_kelas = ? and status = false";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idKelas);
            ResultSet res = prep.executeQuery();
            if(res.next()) {
                count = res.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return count;
    }

    public List<String> getIdKelasByNIM(String nim){
        List<String> listKelas = new ArrayList<>();
        String sql = "select id_kelas from nilai where nim = ? and status = false";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                listKelas.add(res.getString("id_kelas"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listKelas;
    }

    public int getMaxIdNilai(){
        String maxId = null;
        String sql = "select id_nilai from nilai order by id_nilai desc limit 1";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                maxId = res.getString("id_nilai");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return Integer.parseInt(maxId.substring(maxId.length()-3));
    }
    public boolean InputNilai (String nim,String idKelas){
        NilaiRepository nilaiRepo = new NilaiRepository();
        String sql = "insert into nilai (id_nilai,nim,id_kelas,nilai_akhir,status) value (?,?,?,?,?)";
        int row = 0;
        int maxId = nilaiRepo.getMaxIdNilai()+1;
        String idNilai = "NL" + String.format("%03d", maxId);
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idNilai);
            prep.setString(2, nim);
            prep.setString(3, idKelas);
            prep.setDouble(4, 0.0);
            prep.setBoolean(5, false);
            row = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return row == 1;
    }

    public boolean cekMatkulBisaAmbil(String nim, String idMatkul){
        boolean bisaAmbil = true;
        String sql = """
                select nim, matkul.id_matkul from nilai 
                inner join kelas on nilai.id_kelas = kelas.id_kelas
                inner join matkul on kelas.id_matkul = matkul.id_matkul
                where nim = ? and matkul.id_matkul = ? and status = false
                """;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            prep.setString(2, idMatkul);
            ResultSet res = prep.executeQuery();
            if(res.next()){
                bisaAmbil = false;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            bisaAmbil = false;
        }
        return bisaAmbil;
    }
}
