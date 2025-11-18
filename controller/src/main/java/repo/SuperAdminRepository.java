package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbCon.SuperAdmin;
import dbCon.db_config;

public class SuperAdminRepository {
    public SuperAdmin getSuperAdminById(String id){
        SuperAdmin admin = null;
        String sql = "select * from superadmin where id_sa = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, id);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                admin = new SuperAdmin(res.getString("id_sa"),
                res.getString("nama"),
                res.getString("jabatan"),
                res.getString("kontak")
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return admin;
    }
}
