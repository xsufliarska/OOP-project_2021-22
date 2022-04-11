package main.model.auction;

public class AuctionedItem {
    public String name = "";
    public int startingPrice = 0;
    public String usersName; //String user / User user;
    public String imagePath = "";

    public int currentBid = 0;

    public AuctionedItem(String name, String price, String usersName, String path, String bid) {
        this.name = name;
        this.startingPrice = Integer.parseInt(price);
        this.usersName = usersName;
        this.imagePath = path;
        this.currentBid = Integer.parseInt(bid);
    }

    public AuctionedItem() {}

    // needed - adding to list view
    @Override
    public String toString() {
        return name;
    }

}
