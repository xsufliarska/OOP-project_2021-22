package main.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String username;
    private String password;
    public Wallet wallet;

    public int auctionsJoined = 0;
    public int auctionsWon = 0;
    public int chambersBought = 0;

    public User(String username, String password, String name, String money, String attended, String won, String chambers) {
        this.name = name;
        this.username = username;
        this.password = password;
        wallet = new Wallet(money);
        this.auctionsJoined = Integer.parseInt(attended);
        this.auctionsWon = Integer.parseInt(won);
        this.chambersBought = Integer.parseInt(chambers);
    }



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
