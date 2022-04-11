package main;

import main.model.singleton.SingletonDatabase;
import main.model.singleton.SingletonUser;
import main.model.User;
import main.serialize.SerializeTXT;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Authentication {

    // load file
    File file = new File("registeredUsers.txt");
    Scanner fr;
    LinkedList<User> users;

    // constructor
    public Authentication() {
        try {
//            users = new TxtSerializable__NOT_USED().deserialization();
            users = SingletonDatabase.getInstance().getUserList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//------------------------------------------------------ L O G I N ------------------------------------------------------

    public boolean checkIfCorrect(String loginName, String loginPassword) {
        for (User atIndex: users) {
            if(atIndex.getUsername().equals(loginName) && atIndex.getPassword().equals(loginPassword)) {
                SingletonUser.getInstance().setUser(atIndex);
                return true;
            }
        }
        return false;                                                  // FOR CHECK CHANGE IT TO TRUE AND THE SCENE WILL CHANGE
    }

//--------------------------------------------------- R E G I S T E R ---------------------------------------------------

    public boolean register(String registerUsername, String registerName, String registerPassword) throws IOException {

        boolean isRegistered = false;

        // probably need to chcek if username is free :rollingeyes:
        for(User atIndex: users) {
            if(atIndex.getUsername().equals(registerUsername)) {
                isRegistered = true;
            }
        }

        // if user is not registered, register him
        if(isRegistered == false) {
            User newUser = new User(registerUsername, registerPassword, registerName, "0", "0", "0", "0");

            newUser.setUsername(registerUsername);
            newUser.setName(registerName);
            newUser.setPassword(registerPassword);

            users.add(newUser);
            //new TxtSerializable__NOT_USED().serialization(users);
            new SerializeTXT().serializeTXT(users);
            return true;
        }
        return false;
    }











}