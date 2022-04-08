package main.model;

import java.util.LinkedList;

public class SingletonDatabase {
    private static SingletonDatabase instance;
    private LinkedList<User> userList;

    public SingletonDatabase() {
    }

    public static SingletonDatabase getInstance() {
        if (instance == null) {
            instance = new SingletonDatabase();
        }
        return instance;
    }

    public LinkedList<User> getUserList() {
        return userList;
    }

    public void setUserList(LinkedList<User> userList) {
        this.userList = userList;
    }
}
