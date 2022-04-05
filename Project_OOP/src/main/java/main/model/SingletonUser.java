package main.model;

public class SingletonUser {
    private static SingletonUser instance;
    private User user;

    private SingletonUser() {
    }

    public static SingletonUser getInstance() {
        if (instance == null) {
            instance = new SingletonUser();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
