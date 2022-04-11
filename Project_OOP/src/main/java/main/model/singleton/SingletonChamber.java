package main.model.singleton;

import main.model.auction.Chamber;

public class SingletonChamber {
    private static SingletonChamber instance;
    private Chamber chamber;
    private String typeOfAuction;

    private SingletonChamber() {
    }

    public static SingletonChamber getInstance() {
        if (instance == null) {
            instance = new SingletonChamber();
        }
        return instance;
    }

    public Chamber getChamber() {
        return chamber;
    }

    public void setChamber(Chamber chamber) {
        this.chamber = chamber;
    }

    public String getTypeOfAuction() {
        return typeOfAuction;
    }

    public void setTypeOfAuction(String typeOfAuction) {
        this.typeOfAuction = typeOfAuction;
    }
}
