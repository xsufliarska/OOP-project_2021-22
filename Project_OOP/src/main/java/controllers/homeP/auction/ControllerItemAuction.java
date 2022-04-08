package controllers.homeP.auction;

import controllers.ControllerHomePageTopBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import main.Auction;
import main.Popup;
import main.model.AuctionedItem;
import main.serialize.AuctionsSerializeTXT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControllerItemAuction extends ControllerHomePageTopBar implements Initializable {

    @FXML
    private Button addItemButton;
    @FXML
    private Button auctionsButton;
    @FXML
    private HBox buttonBar;
    @FXML
    private Button logoutButton;
    @FXML
    private Button profileButton;
    @FXML
    private BorderPane rootPane;
    @FXML
    private Button statsButton;
    @FXML
    private Button walletButton;


    @FXML
    private ImageView imageItem;
    @FXML
    private TextField info;
    @FXML
    private Button auctionInfoButton;

    @FXML
    private Button joinAuctionButton;
    @FXML
    private ComboBox<String> typeOfAuction;
    @FXML
    private ListView<AuctionedItem> listAuction;


    ObservableList<String> auctionList = FXCollections.observableArrayList("English Auction",
            "Japanese Auction", "First-Price Sealed-Bid Auction", "");

    AuctionedItem chosen = null;
    ObservableList<AuctionedItem> auctionItems = null;


    @FXML
    void joinAuctionClicked(ActionEvent event) throws IOException {
        if(typeOfAuction.getValue() != "" && chosen != null) {
            BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/auctionWindow.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        else if(typeOfAuction.getValue() == "") {
            info.setAlignment(Pos.CENTER_LEFT);
            info.setText("Choose type of auction");
        }
        else {
            info.setAlignment(Pos.CENTER_LEFT);
            info.setText("Choose auction");
        }
    }

    public void itemsInAuction() throws FileNotFoundException {

    }




    @FXML
    void auctionInfoButtonClicked(ActionEvent event) throws IOException {
        Popup infoPopup = new Popup();
        infoPopup.initialize();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addItemsClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            auctionsClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logoutClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            profileClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            statsClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            walletClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //typeOfAuction.setValue("English Auction");
        typeOfAuction.setValue("");
        typeOfAuction.setItems(auctionList);

        typeOfAuction.setOnAction(actionEvent -> {
            new Auction(typeOfAuction.getValue());
            /*switch (typeOfAuction.getValue()) {
                case "English Auction":
                    System.out.println("English auction selected");
                    break;
                case "Japanese Auction":
                    System.out.println("Japanese auction selected");
                    break;
                case "First-Price Sealed-Bid Auction":
                    System.out.println("First-Price Sealed-Bid/Blind auction selected");
                    break;
                default:
                    System.out.println("English auction selected");
                    break;
            }*/
        });

        try {
            itemsInAuction();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // load file
        File file = new File("auctions.txt");
        Scanner fr;

        AuctionsSerializeTXT items = new AuctionsSerializeTXT();
        try {
            auctionItems = items.deserializeAuctions(auctionItems);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        listAuction.getItems().clear();
        listAuction.setItems(auctionItems);


        listAuction.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AuctionedItem>() {
            @Override
            public void changed(ObservableValue<? extends AuctionedItem> observableValue, AuctionedItem auctionedItem, AuctionedItem t1) {

                int index = 0;
                index = listAuction.getSelectionModel().getSelectedIndex();
                chosen = auctionItems.get(index);

                try {
                    imageItem.setImage(new Image(new FileInputStream(chosen.imagePath)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
