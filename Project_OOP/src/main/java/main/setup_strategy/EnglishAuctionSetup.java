package main.setup_strategy;

import controllers.homeP.auction.ControllerAuction;
import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import main.model.Bot;
import main.model.auction.AuctionedItem;
import main.model.auction.Chamber;
import main.model.singleton.SingletonItem;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class EnglishAuctionSetup implements AuctionSetup {

    private final ControllerAuction controllerAuction;
    private final PauseTransition runner = new PauseTransition(Duration.seconds(5));    //TODO bot time
    private List<Bot> botList = new ArrayList<>();
    int i = 0;
    boolean ended = false;
    boolean itemAuct = false;

    public EnglishAuctionSetup(ControllerAuction controllerAuction) {
        this.controllerAuction = controllerAuction;

        runner.setOnFinished(event -> {
            Random random = new Random();
            int botNum = random.nextInt(botList.size());
            Bot bot = botList.get(botNum);

            int bidValue = 0;

            if(itemAuct == true) {
                bidValue = SingletonItem.getInstance().getAuctionedItem().startingPrice + i;
            }
            else {
                bidValue = 100 + i;
            }

            controllerAuction.biddingTextBot(bot.name, bidValue);
            //bots bids increase by 10
            i += 10;

            runner.playFromStart();
        });
    }

    @Override
    public void setup(AuctionedItem auctionedObject) throws IOException {
        itemAuct = true;

        // loading bots
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

        controllerAuction.infoText("Welcome to auction");
        controllerAuction.infoText("The item starts at " + SingletonItem.getInstance().getAuctionedItem().startingPrice + " €");



        Timer timer = new Timer();

        //TODO listener
        controllerAuction.setListener(bidValue -> {
            if(ended == false) {
                if (controllerAuction.biddingText(bidValue + "")) {
                    i += 10;
                    runner.stop();
                    runner.playFromStart();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Auction has ended");
                alert.setHeaderText("You can't bid because the auction has ended.");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {}
                });
            }
        });

        runner.play();

        //TODO multithreading
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runner.stop();
                ended = true;
                try {
                    controllerAuction.endOfEnglishAuctionItem();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //TODO time of auction
        }, 40000);
    }

    @Override
    public void setup(Chamber auctionedObject) throws IOException{
        // loading bots
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

        controllerAuction.infoText("Welcome to auction");
        // every chamber will strat at 100 €
        controllerAuction.infoText("The chamber starts at " + 100 + " €");



        Timer timer = new Timer();

        //TODO listener
        controllerAuction.setListener(bidValue -> {
            if(ended == false) {
                if (controllerAuction.biddingText(bidValue + "")) {
                    i += 10;
                    runner.stop();
                    runner.playFromStart();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Auction has ended");
                alert.setHeaderText("You can't bid because the auction has ended.");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {}
                });
            }
        });

        runner.play();

        //TODO multithreading
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runner.stop();
                ended = true;
                try {
                    controllerAuction.endOfAuctionChamber();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //TODO time of auction
        }, 40000);
    }
}
