package main;

import java.io.IOException;

public interface BidListener {
    //TODO Listener
    void onBid(int bidValue) throws IOException;
}
