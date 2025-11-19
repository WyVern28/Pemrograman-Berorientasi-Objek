package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbCon.Matkul;
import dbCon.db_config;

public class MatkulRepository {
    public List<Matkul> getMatkulByIdProdi(String idProdi){
        String sql = """
                select * from matkul
                inner join prodi on matkul.id_prodi = prodi.id_prodi
                inner join mahasiswa on prodi.id_prodi = mahasiswa.id_prodi
                where matkul.id_prodi = ?
                """;
        List<Matkul> listMatkul = new ArrayList<>();
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, idProdi);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                listMatkul.add(new Matkul(
                    res.getString("id_matkul"),
                    res.getString("nama_matkul"),
                    res.getString("id_prodi"),
                    res.getInt("sks"))
                    );
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listMatkul;
    }
}
