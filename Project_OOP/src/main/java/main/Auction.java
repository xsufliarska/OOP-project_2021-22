package main;

import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;
import main.setup_strategy.AuctionSetup;

import java.io.IOException;

public class Auction {
    public Auction(AuctionedItem auctionedObject, AuctionSetup setup) throws IOException {
        setup.setup(auctionedObject);
    }

    public Auction(Chamber auctionedObject, AuctionSetup setup) throws IOException {
        setup.setup(auctionedObject);
    }
}
