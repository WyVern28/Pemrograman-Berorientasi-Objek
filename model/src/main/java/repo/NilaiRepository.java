package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbCon.Nilai;

import DTO.LihatMahasiswa;
import DTO.TranskripNilai;
import dbCon.db_config;

public class NilaiRepository {
    public List<LihatMahasiswa> getMahasiswaByIdKelas(String idKelas){
        List<LihatMahasiswa> listMahasiswa = new ArrayList<>();
        String sql = """
                select nilai.nim, mahasiswa.name 
                from kelas
                inner join nilai on kelas.id_kelas = nilai.id_kelas
                inner join mahasiswa on nilai.nim = mahasiswa.nim
                where kelas.id_kelas = ? and nilai.status = false
                """;
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
            select nilai.id_kelas, kelas.nama_kelas, nilai.nilai_akhir 
            from nilai 
            inner join kelas on nilai.id_kelas = kelas.id_kelas
            where nilai.nim = ? 
            and nilai.status = true 
            and nilai.status_bayar = 'LUNAS' 
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

    public boolean updateNilai(String idKelas, String nim, double nilai) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            System.out.println("=== MULAI PROSES UPDATE NILAI ==="); // DEBUG
            conn = db_config.getConn();
            conn.setAutoCommit(false);

            String sqlNilai = "update nilai set nilai_akhir = ?, status = true where nim = ? and id_kelas = ? and status = false";
            prep = conn.prepareStatement(sqlNilai);
            prep.setDouble(1, nilai);
            prep.setString(2, nim);
            prep.setString(3, idKelas);

            int affected = prep.executeUpdate();
            System.out.println("Langkah 1 Update Nilai: Baris terpengaruh = " + affected); // DEBUG

            if (affected == 0) {
                System.out.println("GAGAL: Data mungkin sudah dinilai sebelumnya (status sudah true) atau ID salah."); // DEBUG
                conn.rollback();
                return false;
            }

            float ipkBaru = hitungIPKInternal(conn, nim);
            int totalSksBaru = hitungTotalSksInternal(conn, nim); // <-- Cek output method ini di bawah

            System.out.println("Hitungan Baru -> IPK: " + ipkBaru + ", Total SKS: " + totalSksBaru); // DEBUG

            String sqlMhs = "update mahasiswa set ipk = ?, total_sks = ? where nim = ?";
            try (PreparedStatement prepMhs = conn.prepareStatement(sqlMhs)) {
                prepMhs.setFloat(1, ipkBaru);
                prepMhs.setInt(2, totalSksBaru);
                prepMhs.setString(3, nim);
                int mhsAffected = prepMhs.executeUpdate();
                System.out.println("Langkah 3 Update Mahasiswa: Baris terpengaruh = " + mhsAffected); // DEBUG
            }

            conn.commit();
            System.out.println("=== SUKSES COMMIT ==="); // DEBUG
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage()); // DEBUG
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {}
            }
            e.printStackTrace();
            return false;
        } finally {
            try { if (prep != null) prep.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    private float hitungIPKInternal(Connection conn, String nim) throws SQLException {
        float totalBobotKaliSks = 0;
        int totalSks = 0;

        String sql = """
            SELECT n.nilai_akhir, m.sks 
            FROM nilai n
            JOIN kelas k ON n.id_kelas = k.id_kelas
            JOIN matkul m ON k.id_matkul = m.id_matkul
            WHERE n.nim = ? AND n.status = true
            """;

        try (PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                double val = res.getDouble("nilai_akhir");
                int sks = res.getInt("sks");
                totalBobotKaliSks += (convertKeBobot(val) * sks);
                totalSks += sks;
            }
        }
        if (totalSks == 0) return 0.00f;
        return totalBobotKaliSks / totalSks;
    }

    private int hitungTotalSksInternal(Connection conn, String nim) throws SQLException {
        int totalSks = 0;

        String sql = """
        SELECT SUM(m.sks) as total_sks
        FROM nilai n
        JOIN kelas k ON n.id_kelas = k.id_kelas
        JOIN matkul m ON k.id_matkul = m.id_matkul
        WHERE n.nim = ? AND n.status = true
        """;

        try (PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, nim);
            ResultSet res = prep.executeQuery();
            if (res.next()) {
                totalSks = res.getInt("total_sks");
            }
        }

        System.out.println("DEBUG SKS: Menghitung SKS untuk NIM " + nim + ". Hasil: " + totalSks); // DEBUG
        return totalSks;
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
        if (maxId == null) return 0;
        return Integer.parseInt(maxId.substring(maxId.length()-3));
    }

    public boolean InputNilai (String nim,String idKelas){
        NilaiRepository nilaiRepo = new NilaiRepository();
        String sql = "insert into nilai (id_nilai, nim, id_kelas, nilai_akhir, status, status_bayar) values (?, ?, ?, ?, ?, ?)";
        int row = 0;
        int maxId = nilaiRepo.getMaxIdNilai()+1;
        String idNilai = "NL" + String.format("%03d", maxId);
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idNilai);
            prep.setString(2, nim);
            prep.setString(3, idKelas);
            prep.setDouble(4, 0.0);
            prep.setBoolean(5, false);
            prep.setString(6, "BELUM");
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
                select nilai.nim from nilai 
                inner join kelas on nilai.id_kelas = kelas.id_kelas
                where nilai.nim = ? and kelas.id_matkul = ? and nilai.status = false
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

    private double convertKeBobot(double nilai) {
        if (nilai >= 85) return 4.00;
        if (nilai >= 80) return 3.50;
        if (nilai >= 75) return 3.00;
        if (nilai >= 70) return 2.50;
        if (nilai >= 65) return 2.00;
        if (nilai >= 50) return 1.00;
        return 0.00;
    }
}
