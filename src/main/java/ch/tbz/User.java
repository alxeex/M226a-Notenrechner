package ch.tbz;

public class User {
    private int id;
    private String name;
    private String password;
    private Boolean isLoggedIn = false;
    private Boolean admin = false;

    public User(Integer id, String name, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void getAdmin(Boolean admin) {
        admin = admin;
    }
}
