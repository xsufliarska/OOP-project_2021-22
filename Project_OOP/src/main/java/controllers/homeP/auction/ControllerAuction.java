package controllers.homeP.auction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Auction;
import main.model.auction.Chamber;
import main.model.singleton.SingletonChamber;
import main.model.singleton.SingletonItem;
import main.model.auction.AuctionedItem;
import main.model.singleton.SingletonUser;
import main.setup_strategy.EnglishAuctionSetup;
import main.setup_strategy.FPSB_AuctionSetup;
import main.setup_strategy.JapaneseAuctionSetup;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAuction implements Initializable {

    @FXML
    private TextArea auctionInfoField;
    @FXML
    private Button bidButton;
    @FXML
    private TextField bidField;
    @FXML
    private Text currentBid;
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

    int bidded = 0;


    @FXML
    void bid(ActionEvent event) {
        bidded = Integer.parseInt(currentBid.getText());
    }

    @FXML
    void leave(ActionEvent event) {}



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AuctionedItem itemInAuction = SingletonItem.getInstance().getAuctionedItem();
        Chamber chamberInAuction = SingletonChamber.getInstance().getChamber();
        String typeOfAuction = SingletonItem.getInstance().getTypeOfAuction();

        switch (typeOfAuction) {
            case "English Auction":
                if(itemInAuction != null) {
                    try {
                        Auction auction = new Auction(itemInAuction, new EnglishAuctionSetup());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        Auction auction = new Auction(chamberInAuction, new EnglishAuctionSetup());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "Japanese Auction":
                if(itemInAuction != null) {
                    try {
                        Auction auction = new Auction(itemInAuction, new JapaneseAuctionSetup());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            case "First-Price Sealed-Bid Auction":
                if(itemInAuction != null) {
                    try {
                        Auction auction = new Auction(itemInAuction, new FPSB_AuctionSetup());
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

            currentBid.setText(String.valueOf(itemInAuction.currentBid) + " €");
            nameOfObject.setText(itemInAuction.name);
        }
        else {
            try {
                image.setImage(new Image(new FileInputStream(chamberInAuction.imagePath)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            currentBid.setText(String.valueOf(chamberInAuction.currentBid) + " €");
            nameOfObject.setText("Chamber " + String.valueOf(chamberInAuction.chamberNumber));
        }

        userName.setText(SingletonUser.getInstance().getUser().getUsername());


        leaveButton.setOnAction(actionEvent -> {
            final Stage stage = (Stage) leaveButton.getScene().getWindow();
            stage.close();
        });
    }
}
