package main.model.singleton;

import main.model.auction.AuctionedItem;

public class SingletonItem {
    private static SingletonItem instance;
    private AuctionedItem item;
    private String typeOfAuction;

    private SingletonItem() {
    }

    public static SingletonItem getInstance() {
        if (instance == null) {
            instance = new SingletonItem();
        }
        return instance;
    }

    public AuctionedItem getAuctionedItem() {
        return item;
    }

    public void setAuctionedItem(AuctionedItem item) {
        this.item = item;
    }

    public String getTypeOfAuction() {
        return typeOfAuction;
    }

    public void setTypeOfAuction(String typeOfAuction) {
        this.typeOfAuction = typeOfAuction;
    }
}
