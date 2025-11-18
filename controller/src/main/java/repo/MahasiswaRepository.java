package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbCon.Mahasiswa;
import dbCon.db_config;

public class MahasiswaRepository {
    public Mahasiswa getMahasiswaById(String id){
        Mahasiswa mhs = null;
        String sql = "select * from mahasiswa where nim = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                mhs = new Mahasiswa(
                    res.getString("nim"),
                    res.getString("name"),
                    res.getString("id_prodi"),
                    res.getFloat("ipk"),
                    res.getInt("total_sks")
                    );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return mhs;
    }
}
