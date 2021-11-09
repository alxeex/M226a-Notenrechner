package ch.tbz;

import java.util.ArrayList;

class AuthService {
    private final ArrayList<User> users = new ArrayList<User>();


    public AuthService() {
        users.add(new User(1, "graber", "rolf", true));
        users.add(new User(2, "julian", "a", false));
        users.add(new User(3, "user3", "user3", false));
    }

    public boolean IsUserLoggedIn(int userId) {
        for (User user : users) {
            if (user.getId() == userId && user.isLoggedIn())
                return true;
        }
        return false;
    }

    public User Login(String un, String pw) {
        for (User user : users) {
            if (user.getName().equals(un) && user.getPassword().equals(pw)) {
                user.setLoggedIn(true);
                return user;
            }
        }
        System.out.println("Benutzername oder Passwort falsch!");
        return null;
    }

    public boolean Logout(String un) {
        for (User user : users) {
            if (user.getName() == un) {
                user.setLoggedIn(false);
                return true;
            }
        }
        return false;
    }

    public boolean Logout(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setLoggedIn(false);
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public User getUser(int userId) {
        return users.get(userId - 1);
    }
}
