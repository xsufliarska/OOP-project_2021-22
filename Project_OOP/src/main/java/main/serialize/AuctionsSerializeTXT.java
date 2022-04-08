package main.serialize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.model.AuctionedItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AuctionsSerializeTXT {
    File file = new File("auctions.txt");
    Scanner fr;

    public ObservableList deserializeAuctions(ObservableList<AuctionedItem> auctionsList) throws FileNotFoundException {
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
}
