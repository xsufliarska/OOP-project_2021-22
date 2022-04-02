package main.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;            //set
    private String username;        //set
    private String password;        //set
    Wallet wallet;

    int auctionsJoined = 0;
    int auctionsWon = 0;
    int chambersBought = 0;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // prob dont need
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
