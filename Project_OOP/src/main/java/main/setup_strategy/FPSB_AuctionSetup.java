package main.setup_strategy;

import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;

import java.io.IOException;

public class FPSB_AuctionSetup implements AuctionSetup{
    @Override
    public void setup(AuctionedItem auctionedObject) {

    }

    // not used
    @Override
    public void setup(Chamber auctionedObject) throws IOException{}
}
