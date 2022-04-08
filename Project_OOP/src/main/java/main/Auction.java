package main;

public class Auction {
    //public Auction(AuctionSetup aSetup) {
    public Auction(String type) {
        //auctionSetup.setup(auctionedItem);        //wth is this
        //AuctionSetup auctionSetup = aSetup;         //can i do this like this? s nazvom konstruktora odkomentovanym
        //or like this prob
        switch (type) {
            case "English Auction":
                System.out.println("English auction selected");
                break;
            case "Japanese Auction":
                System.out.println("Japanese auction selected");
                break;
            case "First-Price Sealed-Bid Auction":
                System.out.println("First-Price Sealed-Bid/Blind auction selected");
                break;
            default:
                System.out.println("English auction selected");
                break;
        }
    }
}
