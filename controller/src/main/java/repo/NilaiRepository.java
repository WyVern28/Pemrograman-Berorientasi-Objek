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

    public List<Object[]> getTranskripNilaiByNIM(String nim){
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
}
