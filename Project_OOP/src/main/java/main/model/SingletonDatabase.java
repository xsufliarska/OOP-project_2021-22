package main.model;

import java.util.LinkedList;

public class SingletonDatabase {
    private static SingletonDatabase instance;
    //private LinkedList<User>;

    private SingletonDatabase() {
    }

    public static SingletonDatabase getInstance() {
        if (instance == null) {
            instance = new SingletonDatabase();
        }
        return instance;
    }
}
