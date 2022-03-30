package main;

import main.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Entry {

    User user = new User();

    // nacita file
    File file = new File("main/registeredUsers.txt");
    FileReader fr;

    // constructor
    public Entry() {
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//------------------------------------------------------ L O G I N ------------------------------------------------------

    public boolean checkIfCorrect(String loginName, String loginPassword) {
        // skontroluje dokument ci sedi
        int numOfRegisteredUsers = 0;



        for(int i = 0; i < numOfRegisteredUsers; i++) {


            return true;
        }

        return true;                                                  // FOR CHECH CHANGE IT TO TRUE AND THE SCENE WILL CHANGE
    }

//--------------------------------------------------- R E G I S T E R ---------------------------------------------------

    public void register(String registerUsername, String registerName, String registerPassword1) {

        user.setName(registerName);
        user.setPassword(registerPassword1);
        user.setUsername(registerUsername);

        // add this stuff to registeredUsers txt file
    }











}