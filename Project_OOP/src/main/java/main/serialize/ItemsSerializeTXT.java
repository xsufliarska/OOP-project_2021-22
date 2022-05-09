package main.serialize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.model.User;
import main.model.auction.AuctionedItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        FileWriter frw = new FileWriter(file, false);            //true - append, false - overwrite

        for (AuctionedItem atIndex: auctionsList) {
            frw.write(atIndex.name + ", " + atIndex.startingPrice + ", " + atIndex.usersName + ", " +
                    atIndex.imagePath + ", " + atIndex.currentBid + "\n");
        }

        frw.close();
    }

    public static void deletionItem(String name) throws IOException {
        File file = new File("itemsAuction.txt");
        Scanner fr = new Scanner(file);

        String content = new String(Files.readAllBytes(Paths.get("itemsAuction.txt")));
        String[] contentSplit = content.split("\n");

        FileWriter frw = new FileWriter(file, false);

        for (int i = 0; i < contentSplit.length; i++) {
            String[] lineSplit;
            lineSplit = contentSplit[i].split(", ");
            if(lineSplit[0].equals(name)) {
                // do nothing
            }
            else {
                frw.write(contentSplit[i] + "\n");
            }
        }

        frw.close();
    }
}
