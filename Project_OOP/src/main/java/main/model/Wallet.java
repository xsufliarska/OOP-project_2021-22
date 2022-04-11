package main.model;

import java.io.Serializable;

public class Wallet {
    public int balance = 0;

    public Wallet(String money) {
        this.balance = Integer.parseInt(money);
    }

    public void charge(int value) {
        balance = balance + value;
    }

    public void withdraw(int value) {
        balance = balance - value;

        if(balance < 0) {
            balance = 0;
        }
    }
}
