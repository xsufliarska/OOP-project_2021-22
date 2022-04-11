package main.serialize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;
import main.model.auction.ItemChamber;
import main.model.singleton.SingletonUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChambersSerializeTXT {
    File file = new File("chambersAuction.txt");
    Scanner fr;

    public ObservableList deserializeAuctions(ObservableList<Chamber> auctionChambers) throws FileNotFoundException {
        auctionChambers = FXCollections.observableArrayList();
        fr = new Scanner(file);

        while (fr.hasNextLine()) {
            String[] lineSplit;
            String line = fr.nextLine();
            lineSplit = line.split(", ");

            ArrayList<ItemChamber> itemList = new ArrayList<>();
            int length = lineSplit.length;

            for(int i = 2; i < length - 1; i++) {
                ItemChamber actualItem = new ItemChamber(lineSplit[i], lineSplit[i + 1]);
                itemList.add(actualItem);
                i++;
            }

            Chamber actual = new Chamber(lineSplit[0], lineSplit[1], itemList, lineSplit[length - 1]);

            auctionChambers.add(actual);
        }

        return auctionChambers;
    }

    public void serializeAuctions(ObservableList<Chamber> auctionChambers) throws IOException {
        File file = new File("chambersAuction.txt");
        FileWriter fr = new FileWriter(file, false);            //true - append, false - overwrite

        for (Chamber atIndex: auctionChambers) {
            fr.write(atIndex.chamberNumber + ", " + atIndex.imagePath + ", ");

            for (int i = 0; i < atIndex.items.size(); i++) {
                fr.write(atIndex.items.get(i) + ", ");
            }

            fr.write(atIndex.currentBid + "\n");
        }

        fr.close();
    }
}
