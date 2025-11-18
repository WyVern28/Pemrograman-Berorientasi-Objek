package logic;

import repo.UserRepository;

public class LoginLogic {
    /**
     * 
     * @param username 
     * @param password
     * @return kalo role ga ketemu return null
     * @return role -> dataType String
     */
    public String getRole(String username,String password){
        UserRepository user = new UserRepository();
        String role = user.Login(username.trim(), password.trim());
        if(role == null){
            return null;
        }
        return role;
    }
}