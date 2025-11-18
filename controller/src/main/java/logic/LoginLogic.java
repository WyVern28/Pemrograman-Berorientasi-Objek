package logic;

import repo.UserRepository;

public class LoginLogic {
    /**
     * 
     * @param username 
     * @param password
     * @return role -> dataType String
     */
    public String getRole(String username,String password){
        UserRepository user = new UserRepository();
        String role = user.Login(username.trim(), password.trim());
        if(role == null){
            throw new RuntimeException("Username/Password salah");
        }
        return role;
    }
}