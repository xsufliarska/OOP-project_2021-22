package main.model;

public class Wallet {
    int balance;

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
