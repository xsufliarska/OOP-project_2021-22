package main.setup_strategy;

import controllers.homeP.auction.ControllerAuction;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import main.model.Bot;
import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;
import main.model.singleton.SingletonItem;
import main.model.singleton.SingletonUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FPSB_AuctionSetup implements AuctionSetup{
    private final ControllerAuction controllerAuction;

    private List<Bot> botList = new ArrayList<>();
    Bot bot;

    boolean userBidded = false;
    boolean userWon = false;

    int numberOfBids = 5;
    Integer[] values = new Integer[numberOfBids];

    String winnerText = "";

    int userBidValue = 0;


    public FPSB_AuctionSetup(ControllerAuction controllerAuction) throws FileNotFoundException {
        this.controllerAuction = controllerAuction;

        File file = new File("bots.txt");
        Scanner fr;
        botList = new LinkedList<>();
        fr = new Scanner(file);

        while (fr.hasNextLine()) {
            String[] lineSplit;
            String line = fr.nextLine();
            lineSplit = line.split("\n");
            Bot actual = new Bot(lineSplit[0]);
            botList.add(actual);
        }

        Random random = new Random();
        int botNum = random.nextInt(botList.size());
        bot = botList.get(botNum);

        int bidValue = 0;

        for(int i = 0; i < numberOfBids; i++) {
            values[i] = SingletonItem.getInstance().getAuctionedItem().startingPrice + (int) (SingletonItem.getInstance().getAuctionedItem().startingPrice * random.nextDouble());
        }

        // generate 5 diff numbers, and if one of them is higher than users bid, generated random bot is the winner
    }

    @Override
    public void setup(AuctionedItem auctionedObject) throws FileNotFoundException {
        // loading bots
//        File file = new File("bots.txt");
//        Scanner fr;
//        botList = new LinkedList<>();
//        fr = new Scanner(file);
//
//        while (fr.hasNextLine()) {
//            String[] lineSplit;
//            String line = fr.nextLine();
//            lineSplit = line.split("\n");
//            Bot actual = new Bot(lineSplit[0]);
//            botList.add(actual);
//        }

        controllerAuction.infoText("Welcome to auction");
        controllerAuction.infoText("The item starts at " + SingletonItem.getInstance().getAuctionedItem().startingPrice + " €");
        controllerAuction.infoText("Place your higher bids!");
        controllerAuction.infoText("You can only bid once! Think about it!\n");



        Timer timer = new Timer();

        //TODO listener
        controllerAuction.setListener(bidValue -> {
            userBidValue = bidValue;

            if(userBidded == false) {
                if(SingletonUser.getInstance().getUser().wallet.balance < bidValue) {
                    userBidded = false;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Not enough money");
                    alert.setHeaderText("You can't bid more money than you have charged on your account.");
                    alert.setContentText("Your disponible amount is " + SingletonUser.getInstance().getUser().wallet.balance + " €");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {}
                    });
                }
                else {
                    // TODO im sorry i was too lazy to check if it is lower or higher than the starting prize :/
                    userBidded = true;

                    int max = values[0];

                    for (int i = 1; i < values.length; i++) {
                        max = Math.max(values[i], max);
                    }

                    if (bidValue > max) {
                        winnerText += "The highest bid was " + bidValue + " and the winner is " +
                                SingletonUser.getInstance().getUser().getUsername();

                        userWon = true;
                    }

                    if (userWon == false) {
                        winnerText += "The highest bid was " + max + " and the winner is " + bot.name;
                    }

                    controllerAuction.biddingTextFPSB("You bidded " + bidValue + " €"); //nejaky exception
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("You can't bid because the auction has ended OR you already placed your bid.");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {}
                });
            }
        });

        //TODO multithreading
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    controllerAuction.endOfFPSBAuctionItem(winnerText, userWon, userBidValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //TODO time of auction
        }, 30000);
    }

    // not used
    @Override
    public void setup(Chamber auctionedObject) throws IOException{}

}
