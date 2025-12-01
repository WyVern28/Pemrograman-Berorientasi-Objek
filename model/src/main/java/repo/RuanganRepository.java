package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbCon.db_config;

public class RuanganRepository {
    public boolean cekAdaRuangan(String idRuangan){
        boolean cek = false;
        String sql = """
                select id_ruangan from ruangan where id_ruangan = ?
                """;
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idRuangan);
            ResultSet res = prep.executeQuery();
            if(res.next()){
                cek = true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cek;
    }
}
