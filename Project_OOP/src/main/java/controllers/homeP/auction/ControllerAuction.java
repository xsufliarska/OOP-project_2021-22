package controllers.homeP.auction;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.Auction;
import main.BidListener;
import main.model.auction.Chamber;
import main.model.singleton.SingletonChamber;
import main.model.singleton.SingletonItem;
import main.model.auction.AuctionedItem;
import main.model.singleton.SingletonUser;
import main.serialize.ChambersSerializeTXT;
import main.serialize.ItemsSerializeTXT;
import main.setup_strategy.EnglishAuctionSetup;
import main.setup_strategy.FPSB_AuctionSetup;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.abs;

public class ControllerAuction implements Initializable {

    @FXML
    private TextArea auctionInfoField;
    @FXML
    private Button bidButton;
    @FXML
    private TextField bidField;
    @FXML
    private TextField currentBidField;
    @FXML
    private ImageView image;
    @FXML
    private Button leaveButton;
    @FXML
    private Text nameOfObject;
    @FXML
    private Text userName;
    @FXML
    private BorderPane rootPane;


    AuctionedItem itemInAuction;
    Chamber chamberInAuction;
    String typeOfAuction;

    private BidListener listener;

    @FXML
    void bid(ActionEvent event) throws IOException {
        //TODO listener
        listener.onBid(Integer.parseInt(bidField.getText()));
    }

    // wont work if this is not here
    // empty bcs manually programmed in initialize
    @FXML
    void leave(ActionEvent event) {}

    //TODO listener
    public void setListener(BidListener listener) {
        this.listener = listener;
    }

    public void infoText(String text) {
        String oldText = auctionInfoField.getText();
        auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + text);
        currentBidField.setText(text + " €");
    }

    public boolean biddingText(String text) {
        // when the user is bidding
        boolean bid = false;

        int neW = Integer.parseInt(text);
        int old = Integer.parseInt(currentBidField.getText().substring(0, currentBidField.getText().length() - 2));

        if(SingletonUser.getInstance().getUser().wallet.balance < neW) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not enough money");
            alert.setHeaderText("You can't bid more money than you have charged on your account.");
            alert.setContentText("Your disponible amount is " + SingletonUser.getInstance().getUser().wallet.balance + " €");

            //TODO vlastná výnimka
            bidField.setText(String.valueOf(SingletonUser.getInstance().getUser().wallet.balance));

            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {}
            });



            bid = false;
        }
        else {
            if (neW > old) {
                String oldText = auctionInfoField.getText();
                auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + SingletonUser.getInstance().getUser().getUsername() + " bidded " + text);
                currentBidField.setText(text + " €");

                bid = true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong bid");
                alert.setHeaderText("You can't bid less than the current bid.");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                    }
                });

                bid = false;
            }
        }

        return bid;
    }

    public void biddingTextBot(String text, int bid) {
        // when the bot is bidding
        int neW = bid;
        int old = Integer.parseInt(currentBidField.getText().substring(0, currentBidField.getText().length() - 2));

        if(neW > old) {
            String oldText = auctionInfoField.getText();
            auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + text + " bidded " + bid + " €");
            currentBidField.setText(bid + " €");
        }
    }

    public void endOfEnglishAuctionItem() throws IOException {
        String oldText = auctionInfoField.getText();
        String[] splited = oldText.split("\n");
        String[] winner = splited[splited.length - 1].split(" ");
        String name = winner[0];

        if(!(winner[1].equals("bidded"))) {
            name += " " + winner[1];
        }

        auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + "\n --- AUCTION ENDED ---\n The winner is " + name);

        if(name.equals(SingletonUser.getInstance().getUser().getUsername())) {
            SingletonUser.getInstance().getUser().auctionsWon++;
            SingletonUser.getInstance().getUser().auctionsJoined++;
            SingletonUser.getInstance().getUser().wallet.withdraw(SingletonItem.getInstance().getAuctionedItem().currentBid);
        }
        else {
            SingletonUser.getInstance().getUser().auctionsJoined++;
        }

        //odstranenie zo zoznamu
        ItemsSerializeTXT.deletionItem(SingletonItem.getInstance().getAuctionedItem().name);

    }

    public void biddingTextFPSB(String text) {
        String oldText = auctionInfoField.getText();

        auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + text);
    }

    public void endOfFPSBAuctionItem(String text, boolean userWon, int userBidValue) throws IOException {
        String oldText = auctionInfoField.getText();
        //auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + text);

        auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + "\n --- AUCTION ENDED ---\n" + text);

        if(userWon) {
            SingletonUser.getInstance().getUser().auctionsWon++;
            SingletonUser.getInstance().getUser().auctionsJoined++;
            SingletonUser.getInstance().getUser().wallet.withdraw(userBidValue);
        }
        else {
            SingletonUser.getInstance().getUser().auctionsJoined++;
        }

        //odstranenie zo zoznamu
        ItemsSerializeTXT.deletionItem(SingletonItem.getInstance().getAuctionedItem().name);

    }

    public void endOfAuctionChamber() throws IOException {
        final int[] income = {0};

        String oldText = auctionInfoField.getText();
        String[] splited = oldText.split("\n");
        String[] winner = splited[splited.length - 1].split(" ");
        String name = winner[0];

        if(!(winner[1].equals("bidded"))) {
            name += " " + winner[1];
        }

        auctionInfoField.setText(oldText + (oldText.isEmpty() ? "" : "\n") + "\n --- AUCTION ENDED ---\n The winner is " + name);

        if(name.equals(SingletonUser.getInstance().getUser().getUsername())) {
            SingletonUser.getInstance().getUser().auctionsJoined++;
            SingletonUser.getInstance().getUser().chambersBought++;

            // from stuckoverwlof idea - error Not on FX application thread; currentThread = Timer-0
            Platform.runLater(new Runnable() {
                public void run() {
                    String price = "\n";
                    int prizeValue = 0;
                    for(int i = 0; i < SingletonChamber.getInstance().getChamber().items.size(); i++) {
                        price += SingletonChamber.getInstance().getChamber().items.get(i).name + " " + SingletonChamber.getInstance().getChamber().items.get(i).value + " €\n";
                        prizeValue += SingletonChamber.getInstance().getChamber().items.get(i).value;
                    }

                    income[0] = prizeValue - Integer.valueOf(currentBidField.getText().substring(0, currentBidField.getText().length() - 2));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You won");
                    alert.setHeaderText("You successfully auctioned chamber " + SingletonChamber.getInstance().getChamber().chamberNumber +
                            " for " + currentBidField.getText().substring(0, currentBidField.getText().length() - 2) + " €.");
                    alert.setContentText("Items you found in chamber are: " + price + "\nValue of found stuff is " + prizeValue + " €.\n" +
                            "Your final income/loss is " + income[0] + " €.");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {}
                    });

                    // need to send to function the oposite value
                    if(income[0] < 0) {
                        SingletonUser.getInstance().getUser().wallet.withdraw(abs(income[0]));
                    }
                    else {
                        SingletonUser.getInstance().getUser().wallet.withdraw(~(income[0] - 1));
                    }
                }
            });

        }
        else {
            SingletonUser.getInstance().getUser().auctionsJoined++;
        }

        //odstranenie zo zoznamu
        ChambersSerializeTXT.deletionChamber(SingletonChamber.getInstance().getChamber().chamberNumber);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemInAuction = SingletonItem.getInstance().getAuctionedItem();
        chamberInAuction = SingletonChamber.getInstance().getChamber();
        typeOfAuction = SingletonItem.getInstance().getTypeOfAuction();

        switch (typeOfAuction) {
            case "English Auction":
                if(itemInAuction != null) {
                    try {
                        Auction auction = new Auction(itemInAuction, new EnglishAuctionSetup(this));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        Auction auction = new Auction(chamberInAuction, new EnglishAuctionSetup(this));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "Japanese Auction":
                if(itemInAuction != null) {
//                    try {
//                        Auction auction = new Auction(itemInAuction, new JapaneseAuctionSetup(this));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                    /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Please choose other type of auction");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {}
                    });*/
                }
            case "First-Price Sealed-Bid Auction":
                if(itemInAuction != null) {
                    try {
                        Auction auction = new Auction(itemInAuction, new FPSB_AuctionSetup(this));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }

        if(itemInAuction != null) {
            try {
                image.setImage(new Image(new FileInputStream(itemInAuction.imagePath)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            currentBidField.setText(String.valueOf(itemInAuction.startingPrice) + " €");
            nameOfObject.setText(itemInAuction.name);
        }
        else {
            try {
                image.setImage(new Image(new FileInputStream(chamberInAuction.imagePath)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // every chamber starts at 100 €
            currentBidField.setText(100 + " €");
            nameOfObject.setText("Chamber " + String.valueOf(chamberInAuction.chamberNumber));
        }

        userName.setText(SingletonUser.getInstance().getUser().getUsername());


        //TODO lambda
        //TODO handler
        leaveButton.setOnAction(actionEvent -> {
            final Stage stage = (Stage) leaveButton.getScene().getWindow();
            stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
            stage.close();
        });

        //TODO listener
        bidField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    //"\\d{0,7}([\\.]\\d{0,4})?" - desatinne cislo; velkost 0-7 cisel, bodka, 0-4 cisla, bodka moze nemusi byt

                    bidField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
