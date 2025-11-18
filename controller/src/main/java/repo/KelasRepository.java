package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
