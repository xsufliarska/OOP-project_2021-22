package main.setup_strategy;

import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;

import java.io.IOException;

public interface AuctionSetup {

    //TODO polymorphism
    //TODO inheritance
    //TODO factory

    void setup(AuctionedItem auctionedObject) throws IOException;      // typy nameVariable - things going into strategy
    void setup(Chamber auctionedObject) throws IOException;
}
