package main.model;

import java.io.Serializable;

public class User extends Figure implements Serializable {
    // private String username;     //set
    private String password;        //set
    private Wallet wallet;
    private String name;            //set

    // email?

/*    public String getUsername() {
        return this.username;
    }*/

    // prob dont need
/*    public String getPassword() {
        return this.password;
    }

    public Wallet getWallet() {
        return this.wallet;
    }*/

/*    public String getName() {
        return super(this.name);
    }*/


    public void setPassword(String password) {
        this.password = password;
    }

/*    public void setWallet() {

        return this.wallet;
    }*/

    public void setName(String name) {
        this.name = name;
    }
}
