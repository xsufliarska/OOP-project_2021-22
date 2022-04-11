package main.setup_strategy;

import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;
import main.model.singleton.SingletonUser;
import main.serialize.AuctionEnglishSerializeTXT;

import java.io.IOException;
import java.util.ArrayList;

public class EnglishAuctionSetup implements AuctionSetup{

    @Override
    public void setup(AuctionedItem auctionedObject) throws IOException {
        new AuctionEnglishSerializeTXT().deserializeAuctions(auctionedObject.name);

        ArrayList auction = new ArrayList();



        auction.add(auctionedObject.name);
        auction.add(SingletonUser.getInstance().getUser().getUsername());
        auction.add("5");

        new AuctionEnglishSerializeTXT().serializeAuctions(auction);
    }

    @Override
    public void setup(Chamber auctionedObject) throws IOException{

    }
}
