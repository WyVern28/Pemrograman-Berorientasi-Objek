package dbCon;

public class User {
    private String id_user, password;
    private Role role;

    public User(String id_user, String password, Role role) {
        this.id_user = id_user;
        this.password = password;
        this.role = role;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
