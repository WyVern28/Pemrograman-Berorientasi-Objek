package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbCon.Dosen;
import dbCon.db_config;

public class DosenRepository {
    public Dosen getDosenById(String id){
        Dosen dosen = null;
        String sql = "select * from dosen where nid = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                dosen = new Dosen(res.getString("nid"),
                res.getString("name"),
                res.getString("id_prodi")
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dosen;
    }
}
