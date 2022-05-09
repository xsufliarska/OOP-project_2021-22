package main.setup_strategy;

import controllers.homeP.auction.ControllerAuction;
import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JapaneseAuctionSetup implements AuctionSetup{

    private final ControllerAuction controllerAuction;

    public JapaneseAuctionSetup(ControllerAuction controllerAuction) {
        this.controllerAuction = controllerAuction;
    }

    @Override
    public void setup(AuctionedItem auctionedObject) throws FileNotFoundException {

    }

    // not used
    @Override
    public void setup(Chamber auctionedObject) throws IOException {}

}
