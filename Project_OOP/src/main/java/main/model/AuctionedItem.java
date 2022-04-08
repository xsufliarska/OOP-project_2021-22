package main.model;

public class AuctionedItem {
    public String name = "";
    public int startingPrice = 0;
    public int value = 0;
    public String usersName; //String user / User user;
    public String imagePath = "";

    public int currentBid = 0;

    public AuctionedItem(String name, String price, String value, String usersName, String path) {
        this.name = name;
        this.startingPrice = Integer.parseInt(price);
        this.value = Integer.parseInt(value);
        this.usersName = usersName;
        this.imagePath = path;
    }

    // neede - adding to list view
    @Override
    public String toString() {
        return name;
    }
}
