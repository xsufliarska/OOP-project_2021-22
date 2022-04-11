package main.serialize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.model.User;
import main.model.auction.AuctionedItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ItemsSerializeTXT {
    File file = new File("itemsAuction.txt");
    Scanner fr;

    public ObservableList deserializeAuctions() throws FileNotFoundException {
        ObservableList<AuctionedItem> auctionsList;
        auctionsList = FXCollections.observableArrayList();
        fr = new Scanner(file);

        while (fr.hasNextLine()) {
            String[] lineSplit;
            String line = fr.nextLine();
            lineSplit = line.split(", ");
            AuctionedItem actual = new AuctionedItem(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]);
            auctionsList.add(actual);
        }

        return auctionsList;
    }

    public void serializeAuctions(ObservableList<AuctionedItem> auctionsList) throws IOException {
        File file = new File("itemsAuction.txt");
        FileWriter fr = new FileWriter(file, false);            //true - append, false - overwrite

        for (AuctionedItem atIndex: auctionsList) {
            fr.write(atIndex.name + ", " + atIndex.startingPrice + ", " + atIndex.usersName + ", " +
                    atIndex.imagePath + ", " + atIndex.currentBid + "\n");
        }

        fr.close();
    }
}
