package main;

import main.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Authentication {

    //User user = new User();

    // nacita file
   /* File file = new File("/main/registeredUsers.txt");
    FileReader fr;

    // constructor
    public Authentication() {
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/

//------------------------------------------------------ L O G I N ------------------------------------------------------

    public boolean checkIfCorrect(String loginName, String loginPassword) {
        User loadedUser = null;

        // skontroluje dokument ci sedi
        int numOfRegisteredUsers = 0;



        for(int i = 0; i < numOfRegisteredUsers; i++) {


            //user = this loged in person "upsidedown emoji"
            //user = loadedUser;
            return true;
        }

        return true;                                                  // FOR CHECK CHANGE IT TO TRUE AND THE SCENE WILL CHANGE
    }

//--------------------------------------------------- R E G I S T E R ---------------------------------------------------

    public void register(String registerUsername, String registerName, String registerPassword1) {

        // probably need to chcek if username is free :rollingeyes:
        User newUser = null;

        newUser.setName(registerName);
        newUser.setPassword(registerPassword1);
        newUser.setUsername(registerUsername);

        //userList.add(newUser);

        // add this stuff to registeredUsers txt file
    }











}