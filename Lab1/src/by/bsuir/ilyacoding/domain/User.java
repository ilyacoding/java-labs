package by.bsuir.ilyacoding.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 2392343482934829L;

    private String login;
    private String password;
    private Role role;

    public enum Role { USER, ADMIN }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
