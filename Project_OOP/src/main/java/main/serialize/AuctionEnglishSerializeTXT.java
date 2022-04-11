package main.serialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AuctionEnglishSerializeTXT {
    // predmet, kto bidol, kolko bidol, kto bidol, kolko bidol, .....

    public ArrayList deserializeAuctions(String name) throws FileNotFoundException {
        File file = new File("englishAuction.txt");
        Scanner fr = new Scanner(file);
        ArrayList auction = new ArrayList();

        while (fr.hasNextLine()) {
            String[] lineSplit;
            String line = fr.nextLine();
            lineSplit = line.split(", ");

            int length = lineSplit.length;

            // getting just the auction we are looking into
            if(lineSplit[0] == name) {
                for (int i = 2; i < length - 1; i++) {
                    auction.add(lineSplit[i]);
                }
            }
        }

        return auction;
    }


    public void serializeAuctions(ArrayList auction) throws IOException {
        File file = new File("englishAuction.txt");
        Scanner fr = new Scanner(file);

        String fileContent = "";

        boolean written = false;

        while(fr.hasNextLine()) {
            fileContent = fileContent + fr.nextLine() + "\n";
        }

        String auctionLine = "";
        for (int j = 0; j < auction.size(); j++) {
            if(j != auction.size()-1) {
                auctionLine = auctionLine + auction.get(j) + ", ";
            }
            else {
                auctionLine = auctionLine + auction.get(j) + "\n";
            }
        }

        String[] lineSplit;
        lineSplit = fileContent.split("\n");

        for(int i = 0; i < lineSplit.length; i++) {
            String[] lineSplited;
            lineSplited = lineSplit[i].split(", ");

            if(auction.contains(lineSplited[0])) {
                lineSplit[i] = auctionLine;
                written = true;
            }
        }
        FileWriter frw = new FileWriter(file, false);           //true - append, false - overwrite

        for(int i = 0; i < lineSplit.length; i++) {
            frw.write(lineSplit[i] + "\n");
        }

        if(written == false) {
            frw.write(auctionLine + "\n");
        }

        frw.write("\n");
        frw.close();
    }
}
