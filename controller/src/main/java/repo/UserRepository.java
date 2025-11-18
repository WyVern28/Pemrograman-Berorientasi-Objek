package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbCon.db_config;

public class UserRepository {
    public String Login(String username,String password){
        String role = null;
        String sql = "select role from users where id_user = ? and password = ?";
        try(Connection conn = db_config.getConn();PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, username);
            prep.setString(2, password);
            ResultSet result = prep.executeQuery();
            while(result.next()){
                role = result.getString("role");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return role;
    }
}
