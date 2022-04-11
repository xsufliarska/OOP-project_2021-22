package main.model.auction;

import java.util.ArrayList;

public class Chamber {
    public int chamberNumber = 0;
    public String imagePath = "";
    public ArrayList<ItemChamber> items = new ArrayList<>();

    public int currentBid = 0;

    public Chamber(String number, String path, ArrayList<ItemChamber> items, String currentBid) {
        this.chamberNumber = Integer.parseInt(number);
        this.imagePath = path;
        this.items = items;
        this.currentBid = Integer.parseInt(currentBid);
    }

    // needed - adding to list view
    @Override
    public String toString() {
        return Integer.toString(chamberNumber);
    }
}
