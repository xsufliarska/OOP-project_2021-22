package main.model;

import java.util.Random;

public class Bot {
    public String name;
    public Wallet wallet;

    public Bot(String name) {
        this.name = name;

        Random random = new Random();
        String randomNum = String.valueOf(random.nextInt(400) + 100);
        wallet = new Wallet(randomNum);
    }
}
